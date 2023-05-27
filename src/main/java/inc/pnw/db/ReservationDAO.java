package inc.pnw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The ReservationDAO class is responsible for retrieving data from the
 * AirlineDB database. It retrieves all rows from the Reservation table and
 * returns a collection of Reservation objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class ReservationDAO {

	String databaseURL = "jdbc:sqlserver://localhost:1433;databaseName=airlinedb";
	String user = "db_puc";
	String password = "josh";

	public List<ReservationModel> list() throws SQLException, ClassNotFoundException {
		List<ReservationModel> reservations = new ArrayList<ReservationModel>();

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

		return reservations;
	}

	// main method for debugging
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ReservationDAO r = new ReservationDAO();
		for (int i = 0; i < r.list().size() - 1; i++) {

			// System.out.println(c.list().get(i).getTitle() + c.list().get(i).getState());
		}
	}
}
