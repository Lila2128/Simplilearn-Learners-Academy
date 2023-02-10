package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnect.DbUtil;
import pojo.Students;

public class StudentDAO {
	
	//Insert Operations---------------------------------
	public int insertStudent(Students st) throws SQLException, ClassNotFoundException {
		Connection con= DbUtil.getConn();
		try {
		String sql="insert into studentlist values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, st.getStid());
		ps.setString(2, st.getSfname());
		ps.setString(3, st.getSlname());
		ps.setDate(4, new java.sql.Date(st.getsDOB().getTime())); //to convert Util form of Date to SQL form of date.
		ps.setString(5, st.getSaddress());
		ps.setString(6, st.getSphone());
		ps.setString(7, st.getClassname());
		return ps.executeUpdate();
		}catch(SQLException e) {
			e.getSQLState();
		}
		return 0;
	}
	
	//Retrieve Operation for All the Students-------------------------
	public List<Students> getallstudents() throws ClassNotFoundException, SQLException{
		ArrayList <Students> list= 	new ArrayList<>();
		Connection con= DbUtil.getConn();
		String sql= "select * from studentlist";
		PreparedStatement ps= con.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			Students st=new Students();
			st.setStid(rs.getString(1));
			st.setSfname(rs.getString(2));
			st.setSlname(rs.getString(3));
			st.setsDOB(rs.getDate(4));
			st.setSaddress(rs.getString(5));
			st.setSphone(rs.getString(6));
			st.setClassname(rs.getString(7));
			list.add(st);
		}
		return list;
	}
	
	//Retrieve Operation according based on the Class for Class Report-------------------------------------------------
	public static List<Students> getclassReport(String Class) {
		ArrayList <Students> list= 	new ArrayList<>();
		Students st=null; 
		Connection con;
		try {
			con = DbUtil.getConn();
			String sql= "select * from studentlist where sclass=?";
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, Class);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				st= new Students();
				st.setStid(rs.getString(1));
				st.setSfname(rs.getString(2));
				st.setSlname(rs.getString(3));
				st.setsDOB(rs.getDate(4));
				st.setSaddress(rs.getString(5));
				st.setSphone(rs.getString(6));
				st.setClassname(rs.getString(7));
				list.add(st);
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//Update Operations -----------------------------
	public int updateStudent(Students st) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getConn();
		String sql="update studentlist set sfname= ?, slname=?, sDOB=?, saddress=?, sphone=?, sclass=? where stid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, st.getSfname());
		ps.setString(2, st.getSlname());
		ps.setDate(3, new java.sql.Date(st.getsDOB().getTime()));
		ps.setString(4, st.getSaddress());
		ps.setString(5, st.getSphone());
		ps.setString(6, st.getClassname());
		ps.setString(7, st.getStid());
		return ps.executeUpdate();
	}
	
	//Delete Operations------------------ as per the record selected which fetches the unique id. 
	public static int deleteStudent(String id) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getConn();
		System.out.println("executing delete student DAO");
		String sql= "delete from studentlist where stid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
		
	}

}
