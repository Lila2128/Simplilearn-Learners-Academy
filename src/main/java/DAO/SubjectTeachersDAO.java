package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import DbConnect.DbUtil;
import pojo.SubjectTeachers;
import pojo.Teachers;

public class SubjectTeachersDAO {
	
	//INSERT OPERATION--------------------------------------
	public int insertSubjectTeachers(SubjectTeachers subt) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		try {
			System.out.println("entered SubjectTeacherDAO");
			String sql= "insert into depart (sclass, subjects, teachers) values( ?, ?, ?)";
			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setString(1, subt.getSubtId());
			String Class= subt.getClassname(); 
			System.out.println("SubjectTeacher DAO "+ Class);
			ps.setString(1, subt.getClassname());
			ps.setString(2, subt.getSubject());
			ps.setString(3, subt.getTeacher());
			System.out.println("insrt DAO executed");
			return ps.executeUpdate();
			}catch(SQLException e) {
				e.getSQLState();
			}
			return 0;
	}
	
	//RETRIEVE OPERATION FOR ALL THE SUBJECT TEACHERS FOR SPECIFIC CLASS WHEN PASSED FROM THE CLASS
	public static List<SubjectTeachers> getclassReport(String Class){
		System.out.println("executing Subject Teacher Report DAO");
		SubjectTeachers subteach = null;
		ArrayList <SubjectTeachers> list= new ArrayList<>();
		Connection con;
		try {
			con = DbUtil.getConn();
			String sql= "select * from depart where sclass=?";
			System.out.println(Class);
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, Class);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				subteach=new SubjectTeachers();
				subteach.setSubtId(rs.getString(1));
				subteach.setClassname(rs.getString(2));
				subteach.setSubject(rs.getString(3));
				subteach.setTeacher(rs.getString(4));
				list.add(subteach);
			}
			return list;	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	
	//DELETE RECORD----------------------------------by passing unique id
	public static int deleteSubjectTeachers( String id) throws ClassNotFoundException, SQLException {
		Connection con= DbUtil.getConn();
		String sql="delete from depart where sid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
	}
	
	

}
