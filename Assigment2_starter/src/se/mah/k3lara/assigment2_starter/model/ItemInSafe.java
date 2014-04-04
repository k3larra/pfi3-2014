package se.mah.k3lara.assigment2_starter.model;

public class ItemInSafe {
 private String company="";
 private String loginID="";
 private String password="";
 
	public ItemInSafe(String company) {
		this.company = company;
	}
	
	public ItemInSafe(String company, String loginID, String password) {
		this.company = company;
		this.loginID = loginID;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return company;
    }
}
