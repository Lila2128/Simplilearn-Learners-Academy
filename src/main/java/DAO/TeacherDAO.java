package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnect.DbUtil;
import pojo.Students;
import pojo.Teachers;

public class TeacherDAO {
	
	//INSERT OPERATION----------------------------------
	public int insertTeachers(Teachers t) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.getConn();
		try {
		System.out.println("entered TeacherDAO");
		String sql= "insert into teacherlist values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, t.getTid());
		ps.setString(2, t.getFname());
		ps.setString(3, t.getLname());
		System.out.println(new java.sql.Date(t.getDOB().getTime()));
		ps.setDate(4, new java.sql.Date(t.getDOB().getTime()));  //here getDOB is of util.Date package and need to be converted into sql.Date format
		ps.setString(5, t.getAddress());
		ps.setLong(6, t.getPhone());
		ps.setString(7, t.getDesignation());
		return ps.executeUpdate();
		}catch(SQLException e) {
			e.getSQLState();
		}
		return 0;
	}
	
	//RETRIEVE OPERATION OF ALL THE TEACHERS-----------------------------------
	public List<Teachers> getallteachers() throws ClassNotFoundException, SQLException{
		ArrayList<Teachers> list= new ArrayList<>();
		Connection con =DbUtil.getConn();
		String sql="select * from teacherlist";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			Teachers t = new Teachers();
			t.setTid(rs.getString(1));
			t.setFname(rs.getString(2));
			t.setLname(rs.getString(3));
			t.setDOB(rs.getDate(4));
			t.setAddress(rs.getString(5));
			t.setPhone(rs.getLong(6));
			t.setDesignation(rs.getString(7));
			list.add(t);
		}
		return list;

	}
	
	//UPDATE OPERATION------------------------------------------------------
	public int updateTeacher(Teachers t) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		String sql="update teacherlist set firstName=? , LastName=? , DOB=? , Address=? , phone=?, designation= ? where tid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, t.getFname());
		ps.setString(2, t.getLname());
		ps.setDate(3 , new java.sql.Date(t.getDOB().getTime()) );
		ps.setString(4, t.getAddress());
		ps.setLong(5, t.getPhone());
		ps.setString(6, t.getDesignation());
		ps.setString(7, t.getTid());
		return ps.executeUpdate();
	}
	
	//DELETE OPEARTION------------------------------------------------
	public static int deleteTeacher(String id) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getConn();
		String sql="delete from teacherlist where tid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
		
		
}
