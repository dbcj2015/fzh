package com.bjsxt.nw185.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.nw185.dao.AssetDAO;
import com.bjsxt.nw185.dao.DistributionDAO;
import com.bjsxt.nw185.dao.DistributionDetailDAO;
import com.bjsxt.nw185.dao.FaultDAO;
import com.bjsxt.nw185.dao.ReceiveDAO;
import com.bjsxt.nw185.dao.TakebackDAO;
import com.bjsxt.nw185.dao.TakeoutDAO;
import com.bjsxt.nw185.entity.Asset;
import com.bjsxt.nw185.entity.Distribution;
import com.bjsxt.nw185.entity.DistributionDetail;
import com.bjsxt.nw185.entity.Fault;
import com.bjsxt.nw185.entity.Receive;
import com.bjsxt.nw185.entity.Takeback;
import com.bjsxt.nw185.entity.Takeout;
import com.bjsxt.nw185.service.exception.BussinessException;

@Service("assetService")
@Transactional(rollbackFor=Exception.class)
public class AssetService {
	@Resource(name="assetDAO")
	private AssetDAO assetDAO = null; 
	@Resource
	private DistributionDAO distributionDAO = null;
	
	@Resource
	private DistributionDetailDAO distributionDetailDAO = null;
	@Resource
	private ReceiveDAO receiveDAO = null;
	@Resource
	private TakeoutDAO takeoutDAO = null;
	@Resource
	private TakebackDAO takebackDAO  = null;
	@Resource
	private FaultDAO faultDAO  = null;
	public List<Map> findByProperty(Map params){
		return assetDAO.findByProperty(params);
	}
	/**
	 * 查询库存
	 * @param branchId
	 * @return
	 */
	public List<Map> groupStoreAsset(Integer branchId){
		Map param = new HashMap();
		param.put("branchId", branchId);
		return assetDAO.groupStoreAsset(param);
	}
	
	/**
	 * 设备划拨
	 * @param productId 型号
	 * @param branchId 划拨单位
	 * @param num 划拨数量
	 * @throws BussinessException
	 */
	public void distribution(Integer productId ,Integer branchId ,Integer num ) throws BussinessException{
		Map param = new HashMap();
		param.put("productId", productId);
		param.put("state" , 2);
		param.put("branchId", 1); 
		param.put("st", 0);
		param.put("r", num);
		List<Map> store = assetDAO.findByProperty(param);//查询省行库存指定型号设备
		if(store.size() < num){
			throw new BussinessException("库存数量不足,本次派发失败");
		}
		//建立划拨凭证
		Distribution dist = new Distribution();
		dist.setDistTime(new Date());
		dist.setFromBranchId(1);
		dist.setToBranchId(branchId);
		dist.setState(3);//变更为设备划拨状态,详情查看t_state
		distributionDAO.insert(dist);//保存设备划拨凭证
		//循环分配
		for(Map s : store){
			Integer id = (Integer)s.get("assetId"); //获取每一个库存设备的id号
			Asset ass = assetDAO.findById(id); //获取对应的实体类
			ass.setBranchId(branchId);
			ass.setState(3);
			assetDAO.update(ass);//更新资产状态
			//保存划拨明细
			DistributionDetail dd = new DistributionDetail();
			dd.setAssetId(ass.getAssetId());
			dd.setDistId(dist.getDistId());
			distributionDetailDAO.insert(dd);
		}
	}
	/**
	 * 接收设备
	 * @param distId 划拨单号
	 * @param empId 接收人编号
	 * @throws BussinessException 
	 */
	public void receive(Integer distId , Integer empId) throws BussinessException{
		Distribution dis = distributionDAO.findById(distId);//获取划拨单
		if(dis.getState() != 3){
			throw new BussinessException("划拨单已被接收,禁止重复操作");
		}
		dis.setState(4);//设置为设备已被接收
		distributionDAO.update(dis);//更新划拨单状态为已已接受
		Map param = new HashMap();
		param.put("distId", dis.getDistId());
		List<Map> ddList = distributionDetailDAO.findByProperty(param); //查询下发对应的接受设备明细
		for(Map dd : ddList){
			Asset ass = assetDAO.findById((Integer)dd.get("assetId"));
			ass.setState(2);//接收后的设备状态为在库,存储在分行
			assetDAO.update(ass);//更新设备状态
		}
		Receive receive = new Receive();
		receive.setDistId(distId); //划拨单号
		receive.setEmpId(empId);//接收人编号
		receive.setReceiveTime(new Date());
		receiveDAO.insert(receive);
	}
	
	/**
	 * 设备领用
	 * @param t
	 * @param branchId 分行编号
	 * @param productId 设备类型ID
	 * @throws BussinessException 
	 */
	public void takeout(Takeout t , Integer branchId , Integer productId) throws BussinessException{
		
		Map checkSN = new HashMap();
		checkSN.put("sn", t.getSn());
		List checkSNList = this.assetDAO.findByProperty(checkSN);
		if(checkSNList.size() > 0){//设备编号SN已存在禁止重复添加
			throw new BussinessException("设备编号" + t.getSn() + "已被使用,请勿重复登记");
		}
		
		
		Map param = new HashMap();
		param.put("branchId", branchId);
		param.put("state", 2);//查询分行指定的在库设备
		param.put("runState", 6);//运行正常设备才允许被领用
		param.put("productId", productId); //设备型号
		param.put("st", 0);
		param.put("r", 1);//每次只领用登记1个
		List<Map> storeAssets = this.assetDAO.findByProperty(param);//查询分行在库设备
		if(storeAssets.size() == 0 ){
			throw new BussinessException("库存设备不足,设备领用登记失败");
		}
		
		
		Integer assetId = (Integer)storeAssets.get(0).get("assetId");
		t.setAssetId(assetId);
		takeoutDAO.insert(t);//保存登记信息
		Asset ass = assetDAO.findById(assetId);//查询设备对象,更改设备状态为"正在使用"
		ass.setState(5); //更改设备状态为"在用"
		ass.setSn(t.getSn()); //设置SN
		ass.setEmpId(t.getUserId()); //设置用户编号
		assetDAO.update(ass); //更新设备记录
	}
	
	/**
	 * 回收
	 * @param t 回收实体类
	 * @throws BussinessException
	 */
	
	public void takeback(Takeback t ) throws BussinessException{
		Asset ass = assetDAO.findById(t.getAssetId());
		if(ass == null || ass.getState() != 5){
			throw new BussinessException("当前设备状态不可被回收");
		}
		if(ass == null || ass.getRunState() != 6){
			throw new BussinessException("已报修或报废设备不允许回收,请先维修");
		}
		takebackDAO.insert(t);//保存登记信息
		//查询设备对象,更改设备状态为"正在使用"
		ass.setState(2); //更改设备状态为"在库"
		ass.setSn(null); //回收后设备编号清空
		ass.setEmpId(null); //当前用户
		assetDAO.update(ass); //更新设备记录
	}
	
	/**
	 * 设备报修
	 * @param f
	 * @throws BussinessException
	 */
	public void fault(Fault f) throws BussinessException{
		Asset ass = assetDAO.findById(f.getAssetId());
		if(ass == null || ass.getRunState() != 6){
			throw new BussinessException("当前设备状态不可报修");
		}
		f.setFaultState(9);
		faultDAO.insert(f);
		ass.setRunState(7);//设备状态为故障
		this.assetDAO.update(ass);
	}
	
	/**
	 * 设备维修
	 * @param f
	 * @throws BussinessException
	 */
	public void maintenance(Fault f) throws BussinessException{
		Fault source = faultDAO.findById(f.getFaultId());//获取原始故障信息
		
		Asset ass = assetDAO.findById(source.getAssetId());
		
		if(ass == null || ass.getRunState() != 7){
			throw new BussinessException("当前设备状态没有故障,无需维修");
		}
		
		source.setVenderId(f.getVenderId());
		source.setMaintenanceTime(f.getMaintenanceTime());
		source.setMaintenanceDetail(f.getMaintenanceDetail());
		source.setCost(f.getCost());
		source.setFaultState(f.getFaultState());	
		faultDAO.update(source);
		if(source.getFaultState() == 10){//维修完毕恢复正常
			ass.setRunState(6);//设备恢复正常
		}else if(source.getFaultState() == 11){ //报废设备
			ass.setRunState(8);//设备运行状态已报废
			ass.setState(12);//设备状态为:已报废
			ass.setSn(null);//释放设备编号
		}
		assetDAO.update(ass);
	}
}
