package inc.puc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The CityDAO class is responsible for retrieving data from the AirlineDB
 * database. It retrieves all rows from the City table and returns a collection
 * of City objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class CityDAO {

	String databaseURL = "jdbc:sqlserver://localhost:1433;databaseName=AirlineDB";
	String user = "db-puc";
	String password = "inc";

	public List<City> list() throws SQLException, ClassNotFoundException {
		List<City> cities = new ArrayList<City>();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
			String sql = "SELECT * FROM city ORDER BY title, state";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("cityid");
				String title = result.getString("title");
				String state = result.getString("state");
				City city = new City(id, title, state);

				cities.add(city);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		return cities;
	}

	// main method for debugging
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CityDAO c = new CityDAO();
		for (int i = 0; i < c.list().size() - 1; i++)

			System.out.println(c.list().get(i).getTitle() + c.list().get(i).getState());

	}
}
