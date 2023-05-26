package inc.pnw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

/**
 * The CustomerDAO class is responsible for retrieving data from the AirlineDB
 * database. It retrieves all rows from the Customer table and returns a
 * collection of Customer objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class CustomerDAO implements Dao{
	String databaseURL = "jdbc:sqlserver://localhost:1433;databaseName=airlinedb";
	String user = "db-puc";
	String password = "josh";

	public Optional<CustomerModel> get() throws SQLException, ClassNotFoundException {
		List<CustomerModel> customers = new ArrayList<CustomerModel>();
		DatabaseManager dbManager = new DatabaseManager();
		try (org.sql2o.Connection connection = dbManager.getConnection()) {
			String sql = "SELECT cid, email, password FROM customer WHERE lower(email) = :email";
			connection.createQuery(sql);

		} catch (Exception ex) {
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

  @Override
  public Optional get(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List getAll() throws SQLException, ClassNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void save(Object t) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void update(Object t, String[] params) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(Object t) {
    // TODO Auto-generated method stub
    
  }
}
