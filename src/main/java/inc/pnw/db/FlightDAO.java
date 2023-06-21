package inc.pnw.db;


import java.sql.SQLException;
<<<<<<< Updated upstream
import java.text.ParseException;
=======
<<<<<<< Updated upstream
import java.sql.Statement;
=======
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
>>>>>>> Stashed changes
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import org.sql2o.Query;

/**
 * The FlightDAO class is responsible for retrieving data from the AirlineDB database. It retrieves
 * all rows from the Flight table and returns a collection of Flight objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
public class FlightDAO {

	String databaseURL = "jdbc:sqlserver://localhost:1433;databaseName=airlinedb";
	String user = "db_puc";
	String password = "josh";

	public List<FlightModel> list() throws SQLException, ClassNotFoundException {
		List<FlightModel> flights = new ArrayList<FlightModel>();

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
=======
>>>>>>> Stashed changes
public class FlightDAO implements Dao<FlightModel, Object> {

  FlightModel flightDto = new FlightModel();
  DatabaseManager dbManager = new DatabaseManager();
  List<FlightModel> flights;

  @Override
  public Optional<FlightModel> get(Object id) {

    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM Flight WHERE fid = :fid";

      flightDto = connection.createQuery(sql).addParameter("fid", id)
          .executeAndFetchFirst(FlightModel.class);


    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
    return Optional.ofNullable(flightDto);
  }


  @Override
  public List<FlightModel> getByParameters(Map<String, Object> parameters) {
    List<FlightModel> flights = new ArrayList<>();

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
        String sql = "SELECT * FROM flight WHERE ";

        // Build the SQL query dynamically based on the parameters
        List<String> conditions = new ArrayList<>();
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            String key = entry.getKey();
<<<<<<< Updated upstream
            
=======
>>>>>>> Stashed changes
            conditions.add(key + " = :" + key);
        }
        sql += String.join(" AND ", conditions);

        // Execute the query and map the result to FlightModel objects
        Query query = connection.createQuery(sql);
        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
<<<<<<< Updated upstream
            
=======
>>>>>>> Stashed changes
            query.addParameter(key, value);
        }
        flights = query.executeAndFetch(FlightModel.class);
    } catch (Exception ex) {
<<<<<<< Updated upstream
=======
        // Handle or log the exception appropriately
>>>>>>> Stashed changes
        ex.printStackTrace();
        throw ex;
    }

    return flights;
}
<<<<<<< Updated upstream
   
=======
  
  public static void main(String[] args) {
    List<FlightModel> testF = new ArrayList<FlightModel>();
    
    Map<String, Object> fMap = new HashMap<String, Object>();
    LocalDate localDate = LocalDate.of(2023, 3, 25);

    // Convert the java.time.LocalDate to java.sql.Date
    java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
    fMap.put("orig", "3");
    fMap.put("dest", "1");
    fMap.put("fdate", sqlDate);
    FlightDAO fd = new FlightDAO();
    System.out.println(fd.getByParameters(fMap));
    
    
  }

>>>>>>> Stashed changes
 

  @Override
  public List<FlightModel> getAll() throws SQLException, ClassNotFoundException {
    List<FlightModel> flights;
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM flight";
      flights = connection.createQuery(sql).executeAndFetch(FlightModel.class);


    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }

    return flights;
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

<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
}
