package pl.com.bizpol.wspolnota.core;

public class User {

	private int id;
	private String login;
	private String pass;
	private String nicename;
	private String email;
	private int status;
        private String display_name;
        private int parent;

	public User() {
		
	}
	
	public User(String login, String pass, String nicename, String email, int status, String display_name, int user_parent) {
		super();
		this.login = login;
		this.pass = pass;
		this.nicename = nicename;
		this.email = email;
		this.status = status;
                this.display_name = display_name;
                this.parent = user_parent;
	}
	
	public User(int id, String login, String pass, String nicename, String email, int status, String display_name, int user_parent) {
		super();
		this.id = id;
		this.login = login;
		this.pass = pass;
		this.nicename = nicename;
		this.email = email;
		this.status = status;
                this.display_name = display_name;
                this.parent = user_parent;
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
        
        public String getDisplayName() {
		return display_name;
	}

	public void setDisplayName(String display_name) {
		this.display_name = display_name;
	}
        
        public int getParent() {
		return parent;
	}

	public void setParent(int user_parent) {
		this.parent = user_parent;
	}

	@Override
	public String toString() {
		return login + " -> " + nicename;
	}
}
