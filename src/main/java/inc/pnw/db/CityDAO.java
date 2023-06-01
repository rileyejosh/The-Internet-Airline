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
public class CityDAO implements Dao<CityModel, Object> {

  
  @Override
  public Optional<CityModel> get(Object id) {
    CityModel city;

    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM city WHERE cityid = :cityid";

      city = connection.createQuery(sql).addParameter("cityid", id)
          .executeAndFetchFirst(CityModel.class);


    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
    return Optional.ofNullable(city);
  }

  @Override
  public List<CityModel> getAll() throws SQLException, ClassNotFoundException {

    List<CityModel> cities = new ArrayList<CityModel>();
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM city ORDER BY title, state";
      cities = connection.createQuery(sql).executeAndFetch(CityModel.class);


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

  @Override
  public List<CityModel> getByParameters(Map<String, Object> parameters) {
    List<CityModel> cities = null;
    parameters = new HashMap<String, Object>();
    DatabaseManager dbManager = new DatabaseManager();
    
    
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      
      String sql = dbManager.buildQuery(parameters);
      cities = connection.createQuery(sql)
          .bind(parameters)
          .executeAndFetch(CityModel.class);
    }
    return cities;
  }
  
  public static void main(String[] args) {
    CityDAO cd = new CityDAO();
    try {
      List<CityModel> c = cd.getAll();
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
