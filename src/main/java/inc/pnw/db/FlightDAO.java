package inc.pnw.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The FlightDAO class is responsible for retrieving data from the AirlineDB
 * database. It retrieves all rows from the Flight table and returns a
 * collection of Flight objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class FlightDAO implements Dao<FlightModel, Object>{
  
 // create the database manager
  DatabaseManager dbManager = new DatabaseManager();

	public List<FlightModel> getAll() throws SQLException, ClassNotFoundException {
		List<FlightModel> flights = null;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try (org.sql2o.Connection conn = dbManager.getConnection()) {
			String sql = "SELECT * FROM Flight";
			flights = conn.createQuery(sql).executeAndFetch(FlightModel.class);


		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

		return flights;
	}

  @Override
  public Optional<FlightModel> get(Object id) {
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
  public List<FlightModel> getByParameters(Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return null;
  }

}
