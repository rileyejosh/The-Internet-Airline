package inc.pnw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The ReservationDAO class is responsible for retrieving data from the
 * AirlineDB database. It retrieves all rows from the Reservation table and
 * returns a collection of Reservation objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class ReservationDAO implements Dao<ReservationModel, Object> {

  // create the database manager
  DatabaseManager dbManager = new DatabaseManager();

	public List<ReservationModel> getAll() throws SQLException, ClassNotFoundException {
		List<ReservationModel> reservations = null;

		
		try(org.sql2o.Connection conn = dbManager.getConnection()) {
			String sql = "SELECT * FROM Reservation;";
			reservations = conn.createQuery(sql).executeAndFetch(ReservationModel.class);

			/*
			 * while (result.next()) { int id = result.getInt("cityid"); String title =
			 * result.getString("title"); String state = result.getString("state"); City
			 * city = new City(id, title, state);
			 * 
			 * customers.add(city);
			 * 
			 * }
			 */

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return reservations;
	}

  @Override
  public Optional<ReservationModel> get(Object id) {
    // TODO Auto-generated method stub
    return Optional.empty();
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

  @Override
  public List<ReservationModel> getByParameters(Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return null;
  }
}
