package inc.pnw.db;

/**
 * The City model class represents a row in the City table.
 * 
 * @author Joshua Riley
 *
 */
public class City {

	private int cityid;
	private String title;
	private String state;

	public City(int cityid, String title, String state) {
		super();
		this.cityid = cityid;
		this.title = title;
		this.state = state;
	}
	
	public City() {
	  
	}

	public int getCityid() {
	    return cityid;
	}

	public void setCityid(int cityid) {
	    this.cityid = cityid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
