package com.bjsxt.model;

import com.jfinal.plugin.activerecord.Model;
//MVC
//MVC �ֲ��˾��ְ  V -> ��ͼ��  HTML/JSP
//C: Controller ->���Ʋ� ,�������ݣ�����Model�������ݣ���Ӧ���
//M: Model -> ģ�Ͳ㣬 ��������ҵ���߼��������ݿ⽻�� ����Jfinal��ͨ�����ǽ�Model��Service�ȼ�
public class Department extends Model<Department>{
	//Department�ȿ��Ե�ʵ���࣬Ҳ��Service�������⼴�๦����һ�����˳���Ĳ���
		public void createDept(Department d){
			//��������������ݿ�
			d.save();//�̳�model����
			
		}
}
