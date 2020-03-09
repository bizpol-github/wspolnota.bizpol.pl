package pl.com.bizpol.wspolnota.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Community implements Serializable{

	private int id = 0;
	private String name;
	private String short_name;
	private String street;
	private String street_no;
	private int city_id;
        private int zone_id;
        private int country_id;
        private int enabled;
        private List<CommunityTenant> tenants = new ArrayList<>();
        private boolean community_window = false;
        private String[][] data = new String[9][2];
        private boolean changed = false;

	public Community() {
		
	}
	
	public Community(String name, String short_name, String street, String street_no, int city_id, int zone_id, int country_id, int enabled) {
		super();
		this.name = name;
		this.short_name = short_name;
		this.street = street;
		this.street_no = street_no;
		this.city_id = city_id;
                this.zone_id = zone_id;
                this.country_id = country_id;
                this.enabled = enabled;
                setTableArray();
	}
	
	public Community(int id, String name, String short_name, String street, String street_no, int city_id, int zone_id, int country_id, int enabled) {
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
                this.setTableArray();
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
        
        public void setName(String name) {
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
        
        public List<CommunityTenant> getTenants() {
		return tenants;
	}

	public void setTenants(List<CommunityTenant> tenants) {
		this.tenants = tenants;
	}
        
        public boolean getCommunityWindow() {
		return community_window;
	}

	public void setCommunityWindow(boolean community_window) {
		this.community_window = community_window;
	}
        
        public String[][] getTableArray() {
		return data;
	}
        
        public void setTableArray(){
            this.data[0] = new String[]{"id", String.valueOf(this.id), "int"};
            this.data[1] = new String[]{"name", this.name, "String"};
            this.data[2] = new String[]{"short_name", this.short_name, "String"};
            this.data[3] = new String[]{"street", this.street, "String"};
            this.data[4] = new String[]{"street_no", this.street_no, "String"};
            this.data[5] = new String[]{"city_id", String.valueOf(this.city_id), "int"};
            this.data[6] = new String[]{"zone_id", String.valueOf(this.zone_id), "int"};
            this.data[7] = new String[]{"country_id", String.valueOf(this.country_id), "int"};
            this.data[8] = new String[]{"enabled", String.valueOf(this.enabled), "int"};
        }
        
        public boolean isChanged(){
            return changed;
        }
        
        public void setChanged(boolean changed){
            this.changed = changed;
        }
        
	@Override
	public String toString() {
		return short_name;
	}
        
        public String toStringAll() {
		return "ID:" + id + ", " + name + ", " + short_name + ", " + street + ", " + street_no + ", " + city_id + ", " + zone_id + ", " + country_id + ", " + enabled;
	}
}
