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
import java.util.HashMap;
import java.util.Optional;

import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

/**
 * The CityDAO class is responsible for retrieving data from the AirlineDB database. It retrieves
 * all rows from the City table and returns a collection of City objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
<<<<<<< Updated upstream
public class CityDAO implements Dao<CityModel, Object> {

=======
<<<<<<< Updated upstream
public class CityDAO implements Dao {
  
  public static void main(String[] args) {
    CityDAO cd = new CityDAO();
    List<CityModel> c;
    try {
      c = cd.getAll();
      System.out.println(c.size());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
  }
>>>>>>> Stashed changes
  
  @Override
  public Optional<CityModel> get(Object id) {
    CityModel city;
=======
public class CityDAO implements Dao<City, Object> {

  
  @Override
  public Optional<City> get(Object id) {
    City city;
>>>>>>> Stashed changes

    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM city WHERE cityid = :cityid";
<<<<<<< Updated upstream

      city = connection.createQuery(sql).addParameter("cityid", id)
=======
<<<<<<< Updated upstream
         
      city = connection.createQuery(sql)
          .addParameter("cityid", id)
>>>>>>> Stashed changes
          .executeAndFetchFirst(CityModel.class);
=======

      city = connection.createQuery(sql).addParameter("cityid", id)
          .executeAndFetchFirst(City.class);
>>>>>>> Stashed changes


    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
    return Optional.ofNullable(city);
  }

  @Override
  public List<City> getAll() throws SQLException, ClassNotFoundException {

    List<City> cities = new ArrayList<City>();
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM city ORDER BY title, state";
      cities = connection.createQuery(sql).executeAndFetch(City.class);


    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }

    return cities;
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

  @Override
  public List<CityModel> getByParameters(Map<String, Object> parameters) {
    List<CityModel> cities = null;
=======
<<<<<<< Updated upstream
}
=======

  @Override
  public List<City> getByParameters(Map<String, Object> parameters) {
    List<City> cities = null;
>>>>>>> Stashed changes
    parameters = new HashMap<String, Object>();
    DatabaseManager dbManager = new DatabaseManager();
    
    
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      
      String sql = dbManager.buildQuery(parameters);
      cities = connection.createQuery(sql)
          .bind(parameters)
<<<<<<< Updated upstream
          .executeAndFetch(CityModel.class);
=======
          .executeAndFetch(City.class);
>>>>>>> Stashed changes
    }
    return cities;
  }
  
  public static void main(String[] args) {
    CityDAO cd = new CityDAO();
    try {
<<<<<<< Updated upstream
      List<CityModel> c = cd.getAll();
=======
      List<City> c = cd.getAll();
>>>>>>> Stashed changes
      System.out.println(c.size());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  }
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes
