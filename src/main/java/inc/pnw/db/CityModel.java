package inc.pnw.db;

import java.util.Objects;

/**
 * The City model class represents a row in the City table.
 * 
 * @author Joshua Riley
 *
 */
public class CityModel {

	private int cityid;
	private String title;
	private String state;

	
	public CityModel(int id, String title, String state) {
		super();
		this.cityid = id;
		this.title = title;
		this.state = state;
	}

	public int getId() {
		return cityid;
	}

	public void setId(int id) {
		this.cityid = id;
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

  @Override
  public int hashCode() {
    return Objects.hash(cityid, state, title);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CityModel other = (CityModel) obj;
    return cityid == other.cityid && Objects.equals(state, other.state)
        && Objects.equals(title, other.title);
  }

}
