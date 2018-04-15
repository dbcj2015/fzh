import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClazzDao {

	public ArrayList getClazzInfo() throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql="select * from clazz";
		PreparedStatement pstmt = DBUtil.getPreparedStatement(conn, sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList list=new ArrayList();
		while(rs.next()){
			Clazz clazz=new Clazz();
			clazz.setCno(rs.getString("cno"));
			clazz.setCname(rs.getString("cname"));
			clazz.setLoc(rs.getString("loc"));
			list.add(clazz);
			//return list;--遍历一次就退出方法
		}
		DBUtil.closeAll(conn, rs, pstmt);
		return list;
	}
	
}
