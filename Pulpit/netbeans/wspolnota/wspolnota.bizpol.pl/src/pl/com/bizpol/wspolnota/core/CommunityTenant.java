package pl.com.bizpol.wspolnota.core;

import java.io.Serializable;

/**
 *
 * @author netcom
 */
public class CommunityTenant implements Serializable{

	private int id;
        private int commiunity_id;
	private String name;
	private String last_name;
	private String email;
	private String tel;

    /**
     *
     */
    public CommunityTenant() {
		
	}
	
    /**
     *
     * @param commiunity_id
     * @param name
     * @param last_name
     * @param email
     * @param tel
     */
    public CommunityTenant(int commiunity_id, String name, String last_name, String email, String tel) {
		super();
                this.commiunity_id = commiunity_id;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.tel = tel;
	}
	
    /**
     *
     * @param id
     * @param commiunity_id
     * @param name
     * @param last_name
     * @param email
     * @param tel
     */
    public CommunityTenant(int id, int commiunity_id, String name, String last_name, String email, String tel) {
		super();
                this.id = id;
		this.commiunity_id = commiunity_id;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.tel = tel;
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
    public int getCommiunityId() {
		return commiunity_id;
	}
	
    /**
     *
     * @param id
     */
    public void setCommiunityId(int id) {
		this.commiunity_id = id;
	}
	
    /**
     *
     * @return
     */
    public String getName() {
		return name;
	}
        
    /**
     *
     * @param name
     */
    public void setname(String name) {
		this.name = name;
	}

    /**
     *
     * @return
     */
    public String getLastName() {
		return last_name;
	}
	
    /**
     *
     * @param last_name
     */
    public void setLastName(String last_name) {
		this.last_name = last_name;
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
     * @param street
     */
    public void setEmail(String street) {
		this.email = street;
	}
	
    /**
     *
     * @return
     */
    public String getTel() {
		return tel;
	}
	
    /**
     *
     * @param street_no
     */
    public void setTel(String street_no) {
		this.tel = street_no;
	}

    /**
     *
     * @return
     */
    @Override
	public String toString() {
		return name + " " + last_name;
	}
}
