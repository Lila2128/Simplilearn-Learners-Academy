package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DbConnect.DbUtil;
import pojo.Subjects;

public class SubjectsDAO {
	//INSERT OPERATION----------------------------------
	public int insertSubjects(Subjects sub) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.getConn();
		try {
		System.out.println("entered SubjectDAO");
		String sql= "insert into subjects values(?, ?, ?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sub.getSubid());
		ps.setString(2, sub.getClassname());
		ps.setString(3, sub.getSubjects());
		return ps.executeUpdate();
		}catch(SQLException e) {
			e.getSQLState();
		}
		
		return 0;
	}
	
	//RETRIEVE OPERATION OF ALL THE SUBJECTS--------------------------------
	public List<Subjects> getallsubjects() throws ClassNotFoundException, SQLException{
		ArrayList<Subjects> list= new ArrayList<>();
		Connection con =DbUtil.getConn();
		String sql="select * from subjects";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			Subjects sub = new Subjects();
			sub.setSubid(rs.getString(1));
			sub.setClassname(rs.getString(2));
			sub.setSubjects(rs.getString(3));
			list.add(sub);
		}
		return list;

	}
	
	//UPDATE OPERATION--------------------------------------------
	public int updateSubjects(Subjects sub) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		String sql="update subjects set class=? , subjects=? where subid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, sub.getClassname());
		ps.setString(2, sub.getSubjects());
		ps.setString(3, sub.getSubid());
		return ps.executeUpdate();
	}
	
	//DELETE OPERATION------------------------------------------------By passing unique id from the list to delete the record when clicked on the list
	public static int deleteSubjects(String id) throws ClassNotFoundException, SQLException {
		Connection con=DbUtil.getConn();
		String sql="delete from subjects where subid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}

		
		

}
