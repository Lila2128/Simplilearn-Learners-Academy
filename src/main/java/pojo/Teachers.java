package pojo;

import java.util.Date;

public class Teachers {
	
	public String tid;
	public String fname;
	public String lname;
	public Date DOB;
	public String address;
	public long phone;
	public String designation;
	
	public Teachers() {
		
	}
	
	public Teachers(String tid, String fname, String lname, Date dOB, String address, long phone, String designation) {
		super();
		this.tid= tid;
		this.fname = fname;
		this.lname = lname;
		DOB = dOB;
		this.address = address;
		this.phone = phone;
		this.designation = designation;
	}
	
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", fname=" + fname + ", lname=" + lname + ", DOB=" + DOB + ", address=" + address + ", phone="
				+ phone + ", designation=" + designation + "]";
	}
	
	

}
