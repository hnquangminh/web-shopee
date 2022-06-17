package entity;

public class Account {
	private int id;
    private String user;
    private String pass;
    private int admin;
    
	public int getAdmin() {
		return admin;
	}


	public void setAdmin(int admin) {
		this.admin = admin;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	public Account() {
	}
	

	public Account(int id, String user, String pass, int admin) {
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.admin = admin;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", admin=" + admin + "]";
	}






	


}
