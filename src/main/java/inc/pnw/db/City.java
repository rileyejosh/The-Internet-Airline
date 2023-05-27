package inc.pnw.db;

/**
 * The City model class represents a row in the City table.
 * 
 * @author Joshua Riley
 *
 */
public class City {

	private int id;
	private String title;
	private String state;

	public City(int cityid, String title, String state) {
		super();
		this.id = cityid;
		this.title = title;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setState(String title) {
		this.title = state;
	}

}
