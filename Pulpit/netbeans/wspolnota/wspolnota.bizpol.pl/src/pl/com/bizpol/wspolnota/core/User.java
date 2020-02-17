package pl.com.bizpol.wspolnota.core;

public class User {

	private int id;
	private String login;
	private String pass;
	private String nicename;
	private String email;
	private int status;

	public User() {
		
	}
	
	public User(String login, String pass, String nicename, String email, int status) {
		super();
		this.login = login;
		this.pass = pass;
		this.nicename = nicename;
		this.email = email;
		this.status = status;
	}
	
	public User(int id, String login, String pass, String nicename, String email, int status) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.nicename = nicename;
		this.email = email;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
        
        public void setLogin(String login) {
////////		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
        
        public String getNicename() {
		return nicename;
	}
	
	public void setNicename(String nicename) {
		this.nicename = nicename;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return login + " -> " + nicename;
	}
}
