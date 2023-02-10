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
	
	public int insertClassName(ClassName cn) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		try {
		String sql= "insert into ClassName values(?, ?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(2, cn.getCName());
		ps.setString(1, cn.getCid());
		return ps.executeUpdate();
		}catch (SQLException e) {
			e.getSQLState();
		}
		return 0;
	}
	
	public List<ClassName> getallclasses() throws ClassNotFoundException, SQLException{
		ArrayList<ClassName> list= new ArrayList<>();
		Connection con =DbUtil.getConn();
		String sql="select * from ClassName";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			ClassName cn = new ClassName();
			cn.setCid(rs.getString(1));
			cn.setCName(rs.getString(2));
			list.add(cn);
		}
		return list;
	}
	
	public int updateClassName(ClassName cn) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		String sql="update ClassName set className=? where cid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cn.getCName());
		ps.setString(2, cn.getCid());
		return ps.executeUpdate();
	}
	
	public int deleteClassName(ClassName cn) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getConn();
		String sql="delete from ClassName where cid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, cn.getCid());
		return ps.executeUpdate();
	}

}
