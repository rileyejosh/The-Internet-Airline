package inc.puc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The FlightDAO class is responsible for retrieving data from the AirlineDB
 * database. It retrieves all rows from the Flight table and returns a
 * collection of Flight objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class FlightDAO {

	String databaseURL = "jdbc:sqlserver://localhost:1433;databaseName=AirlineDB";
	String user = "db-puc";
	String password = "inc";

	public List<Flight> list() throws SQLException, ClassNotFoundException {
		List<Flight> flights = new ArrayList<Flight>();
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
			String sql = "SELECT cid, email, password FROM customer WHERE lower(email) = '<Email>'";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);

			/*
			 * while (result.next()) { int id = result.getInt("cityid"); String title =
			 * result.getString("title"); String state = result.getString("state"); City
			 * city = new City(id, title, state);
			 * 
			 * customers.add(city);
			 * 
			 * }
			 */

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}

		return flights;
	}

	// main method for debugging
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		FlightDAO f = new FlightDAO();
		for (int i = 0; i < f.list().size() - 1; i++) {

			// System.out.println(c.list().get(i).getTitle() + c.list().get(i).getState());
		}
	}
}
