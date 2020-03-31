package pl.com.bizpol.wspolnota.core;

/**
 *
 * @author netcom
 */
public class User {

	private int id;
	private String login;
	private String pass;
	private String nicename;
	private String email;
	private int status;
        private String display_name;
        private int parent;

    /**
     *
     */
    public User() {
		
	}
	
    /**
     *
     * @param login
     * @param pass
     * @param nicename
     * @param email
     * @param status
     * @param display_name
     * @param user_parent
     */
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
	
    /**
     *
     * @param id
     * @param login
     * @param pass
     * @param nicename
     * @param email
     * @param status
     * @param display_name
     * @param user_parent
     */
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
	
    /**
     *
     * @return
     */
    public int getId() {
		return id;
	}
	
    /**
     *
     * @param id
     */
    public void setId(int id) {
		this.id = id;
	}
	
    /**
     *
     * @return
     */
    public String getLogin() {
		return login;
	}
        
    /**
     *
     * @param login
     */
    public void setLogin(String login) {
////////		this.login = login;
	}

    /**
     *
     * @return
     */
    public String getPass() {
		return pass;
	}
	
    /**
     *
     * @param pass
     */
    public void setPass(String pass) {
		this.pass = pass;
	}
        
    /**
     *
     * @return
     */
    public String getNicename() {
		return nicename;
	}
	
    /**
     *
     * @param nicename
     */
    public void setNicename(String nicename) {
		this.nicename = nicename;
	}
	
    /**
     *
     * @return
     */
    public String getEmail() {
		return email;
	}
	
    /**
     *
     * @param email
     */
    public void setEmail(String email) {
		this.email = email;
	}
	
    /**
     *
     * @return
     */
    public int getStatus() {
		return status;
	}

    /**
     *
     * @param status
     */
    public void setStatus(int status) {
		this.status = status;
	}
        
    /**
     *
     * @return
     */
    public String getDisplayName() {
		return display_name;
	}

    /**
     *
     * @param display_name
     */
    public void setDisplayName(String display_name) {
		this.display_name = display_name;
	}
        
    /**
     *
     * @return
     */
    public int getParent() {
		return parent;
	}

    /**
     *
     * @param user_parent
     */
    public void setParent(int user_parent) {
		this.parent = user_parent;
	}

    /**
     *
     * @return
     */
    @Override
	public String toString() {
		return login + " -> " + nicename;
	}
}
