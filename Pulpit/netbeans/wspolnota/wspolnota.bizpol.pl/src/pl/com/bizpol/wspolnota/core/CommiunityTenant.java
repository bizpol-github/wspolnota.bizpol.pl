package pl.com.bizpol.wspolnota.core;

public class CommiunityTenant {

	private int id;
        private int commiunity_id;
	private String name;
	private String last_name;
	private String email;
	private String tel;

	public CommiunityTenant() {
		
	}
	
	public CommiunityTenant(int commiunity_id, String name, String last_name, String email, String tel) {
		super();
                this.commiunity_id = commiunity_id;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.tel = tel;
	}
	
	public CommiunityTenant(int id, int commiunity_id, String name, String last_name, String email, String tel) {
		super();
                this.id = id;
		this.commiunity_id = commiunity_id;
		this.name = name;
		this.last_name = last_name;
		this.email = email;
		this.tel = tel;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
        
        public int getCommiunityId() {
		return commiunity_id;
	}
	
	public void setCommiunityId(int id) {
		this.commiunity_id = id;
	}
	
	public String getName() {
		return name;
	}
        
        public void setname(String name) {
		this.name = name;
	}
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
        
        public String getEmail() {
		return email;
	}
	
	public void setEmail(String street) {
		this.email = street;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String street_no) {
		this.tel = street_no;
	}

	@Override
	public String toString() {
		return name + " " + last_name;
	}
}
