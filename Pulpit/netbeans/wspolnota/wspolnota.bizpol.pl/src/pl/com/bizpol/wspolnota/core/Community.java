package pl.com.bizpol.wspolnota.core;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author netcom
 */
public final class Community implements Serializable{

	private int id = 0;
	private String name;
	private String short_name;
	private String street;
	private String street_no;
	private int city_id;
        private int zone_id;
        private Country country;
        private boolean enabled;
        
        private boolean isOpened = false;        
        private List<Integer> tenants = null;
        private boolean changed = false;
        
        private final Object[][] data = new Object[10][3];

    /**
     *
     */
    public Community() {
		
	}
	
    /**
     *
     * @param name
     * @param short_name
     * @param street
     * @param street_no
     * @param city_id
     * @param zone_id
     * @param country
     * @param enabled
     */
    public Community(String name, String short_name, String street, String street_no, int city_id, int zone_id, Country country, boolean enabled) {
		super();
		this.name = name;
		this.short_name = short_name;
		this.street = street;
		this.street_no = street_no;
		this.city_id = city_id;
                this.zone_id = zone_id;
                this.country = country;
                this.enabled = enabled;
                setTableArray();
	}
	
    /**
     *
     * @param id
     * @param name
     * @param short_name
     * @param street
     * @param street_no
     * @param city_id
     * @param zone_id
     * @param country
     * @param enabled
     * @param tenants
     */
    public Community(int id, String name, String short_name, String street, String street_no, int city_id, int zone_id, Country country, boolean enabled, List tenants) {
		super();
                this.id = id;
		this.name = name;
		this.short_name = short_name;
		this.street = street;
		this.street_no = street_no;
		this.city_id = city_id;
                this.zone_id = zone_id;
                this.country = country;
                this.enabled = enabled;
                this.tenants = tenants;
                this.setTableArray();
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
    public String getName() {
		return name;
	}
        
    /**
     *
     * @param name
     */
    public void setName(String name) {
		this.name = name;
	}

    /**
     *
     * @return
     */
    public String getShortName() {
		return short_name;
	}
	
    /**
     *
     * @param short_name
     */
    public void setShortName(String short_name) {
		this.short_name = short_name;
	}
        
    /**
     *
     * @return
     */
    public String getStreet() {
		return street;
	}
	
    /**
     *
     * @param street
     */
    public void setStreet(String street) {
		this.street = street;
	}
	
    /**
     *
     * @return
     */
    public String getStreetNo() {
		return street_no;
	}
	
    /**
     *
     * @param street_no
     */
    public void setStreetNo(String street_no) {
		this.street_no = street_no;
	}
	
    /**
     *
     * @return
     */
    public int getCityId() {
		return city_id;
	}

    /**
     *
     * @param city_id
     */
    public void setCityId(int city_id) {
		this.city_id = city_id;
	}
        
    /**
     *
     * @return
     */
    public int getZoneId() {
		return zone_id;
	}

    /**
     *
     * @param zone_id
     */
    public void setZoneId(int zone_id) {
		this.zone_id = zone_id;
	}
        
    /**
     *
     * @return
     */
    public Country getCountry() {
		return country;
	}

    /**
     *
     * @param country
     */
    public void setCountry(Country country) {
		this.country = country;
	}
        
    /**
     *
     * @return
     */
    public boolean getEnabled() {
		return enabled;
	}

    /**
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
        
    /**
     *
     * @return
     */
    public List getTenants() {
		return tenants;
	}

    /**
     *
     * @param tenants
     */
    public void setTenants(List tenants) {
		this.tenants = tenants;
	}
        
    /**
     *
     * @return
     */
    public boolean hasTenants() {
		return this.tenants.size() > 0;
	}
        
    /**
     *
     * @return
     */
    public boolean getIsOpened() {
		return isOpened;
	}

    /**
     *
     * @param opened
     */
    public void setIsOpened(boolean opened) {
		this.isOpened = opened;
	}
        
    /**
     *
     * @return
     */
    public Object[][] getTableArray() {
		return data;
	}
        //ustawiam tanle array
        //name, value, type, editable

    /**
     *
     */
        public void setTableArray(){
            this.data[0] = new Object[]{"id", this.id, "int", "0"};
            this.data[1] = new Object[]{"name", this.name, "String", "1"};
            this.data[2] = new Object[]{"short_name", this.short_name, "String", "1"};
            this.data[3] = new Object[]{"street", this.street, "String", "1"};
            this.data[4] = new Object[]{"street_no", this.street_no, "String", "1"};
            this.data[5] = new Object[]{"city_id", this.city_id, "int", "1"};
            this.data[6] = new Object[]{"zone_id", this.zone_id, "int", "1"};
            this.data[7] = new Object[]{"country", this.country, "Country", "1"};
            this.data[8] = new Object[]{"enabled", this.enabled, "boolean", "1"};
            
            String hasTenants = (this.tenants.size() > 0) ? "tak" : "nie";
            this.data[9] = new String[]{"tenants", hasTenants + "(" + tenants.size() + ")", "List", "0"};
        }
        
    /**
     *
     * @return
     */
    public boolean isChanged(){
            return changed;
        }        
        
    /**
     *
     * @param changed
     */
    public void setChanged(boolean changed){
            this.changed = changed;
        }
        
    /**
     *
     * @return
     */
    @Override
	public String toString() {
		return short_name;
	}
        
    /**
     *
     * @return
     */
    public String toStringAll() {
		return "ID:" + id + ", " + name + ", " + short_name + ", " + street + ", " + street_no + ", " + city_id + ", " + zone_id + ", " + country + ", " + enabled;
	}
}
