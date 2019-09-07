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
		List<City> listCity = new ArrayList<>();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
			String sql = "SELECT * FROM city ORDER BY cityid";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("cityid");
				String title = result.getString("title");
				String state = result.getString("title");
				City category = new City(id, title, state);

				listCity.add(category);
				System.out.println("Connection successful");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		return listCity;
	}
}
