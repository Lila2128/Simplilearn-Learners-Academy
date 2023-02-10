package pojo;

public class ClassName {
	
	public String cName;
	public String cid;
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCName() {
		return cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "ClassName [cName=" + cName + ", cid=" + cid + "]";
	}




}
