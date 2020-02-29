package pl.com.bizpol.wspolnota.core;

public class Commiunity {

	private int id;
	private String name;
	private String short_name;
	private String street;
	private String street_no;
	private int city_id;
        private int zone_id;
        private int country_id;
        private int enabled;

	public Commiunity() {
		
	}
	
	public Commiunity(String name, String short_name, String street, String street_no, int city_id, int zone_id, int country_id, int enabled) {
		super();
		this.name = name;
		this.short_name = short_name;
		this.street = street;
		this.street_no = street_no;
		this.city_id = city_id;
                this.zone_id = zone_id;
                this.country_id = country_id;
                this.enabled = enabled;
	}
	
	public Commiunity(int id, String name, String short_name, String street, String street_no, int city_id, int zone_id, int country_id, int enabled) {
		super();
                this.id = id;
		this.name = name;
		this.short_name = short_name;
		this.street = street;
		this.street_no = street_no;
		this.city_id = city_id;
                this.zone_id = zone_id;
                this.country_id = country_id;
                this.enabled = enabled;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
        
        public void setname(String name) {
		this.name = name;
	}
	public String getShortName() {
		return short_name;
	}
	
	public void setShortName(String short_name) {
		this.short_name = short_name;
	}
        
        public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreetNo() {
		return street_no;
	}
	
	public void setStreetNo(String street_no) {
		this.street_no = street_no;
	}
	
	
	public int getCityId() {
		return city_id;
	}

	public void setCityId(int city_id) {
		this.city_id = city_id;
	}
        
        public int getZoneId() {
		return zone_id;
	}

	public void setZoneId(int zone_id) {
		this.zone_id = zone_id;
	}
        
        public int getCountryId() {
		return country_id;
	}

	public void setCountryId(int country_id) {
		this.country_id = country_id;
	}
        
        public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return name + " -> " + street + " " + street_no;
	}
}
