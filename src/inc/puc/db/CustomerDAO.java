package inc.puc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The CustomerDAO class is responsible for retrieving data from the AirlineDB
 * database. It retrieves all rows from the Customer table and returns a
 * collection of Customer objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class CustomerDAO {
	String databaseURL = "jdbc:sqlserver://localhost:1433;databaseName=AirlineDB";
	String user = "db-puc";
	String password = "inc";

	public List<Customer> list() throws SQLException, ClassNotFoundException {
		List<Customer> customers = new ArrayList<Customer>();
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

		return customers;
	}

	// main method for debugging
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CustomerDAO c = new CustomerDAO();
		for (int i = 0; i < c.list().size() - 1; i++) {

			// System.out.println(c.list().get(i).getTitle() + c.list().get(i).getState());
		}
	}
}
