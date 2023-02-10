package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnect.DbUtil;
import pojo.ClassName;

public class ClassDAO {

	//INSERT OPERATION--------------------------------
	public int insertClassName(ClassName cn) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		try {
		String sql= "insert into ClassName values(?, ?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(2, cn.getClassname());
		ps.setString(1, cn.getCid());
		return ps.executeUpdate();
		}catch (SQLException e) {
			e.getSQLState();
		}
		return 0;
	}
	
	//RETRIEVE OPERATION-------------------------------------------------------------
	public List<ClassName> getallclasses() throws ClassNotFoundException, SQLException{
		ArrayList<ClassName> list= new ArrayList<>();
		Connection con =DbUtil.getConn();
		String sql="select * from ClassName";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			ClassName cn = new ClassName();
			cn.setCid(rs.getString(1));
			cn.setClassname(rs.getString(2));
			list.add(cn);
		}
		return list;
	}
	
	//UPDATE OPERATION--------------------------------------------------------------
	public int updateClassName(ClassName cn) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		String sql="update ClassName set className=? where cid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cn.getClassname());
		ps.setString(2, cn.getCid());
		return ps.executeUpdate();
	}
	
	//DELETE OPEARTION-----------------------By passing unique id from the class list to delete that record
	public static int deleteClassName(String id) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getConn();
		String sql="delete from ClassName where cid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}

}
