package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DbConnect.DbUtil;
import pojo.Teachers;

public class TeacherDAO {
	
	public int insertTeachers(Teachers t) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.getConn();
		try {
			String sql= "insert into TeacherList values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, t.getTid());
			ps.setString(2, t.getFname());
			ps.setString(3, t.getLname());
			ps.setDate(4, (Date) t.getDOB());
			ps.setString(5, t.getAddress());
			ps.setLong(6, t.getPhone());
			ps.setString(7, t.getDesignation());
		}catch(SQLException e) {
			e.getSQLState();
		}
		return 0;
	}

}
