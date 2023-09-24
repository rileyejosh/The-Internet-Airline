package inc.pnw.db;

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
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

/**
 * The CityDAO class is responsible for retrieving data from the AirlineDB database. It retrieves
 * all rows from the City table and returns a collection of City objects to the caller.
 * 
 * @author Joshua Riley
 *
 */

public class CityDAO implements Dao<City, Object> {

  
  @Override
  public Optional<City> get(Object id) {
    City city;


    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM city WHERE cityid = :cityid";


      city =
          connection.createQuery(sql).addParameter("cityid", id).executeAndFetchFirst(City.class);



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

    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      City c = (City) t;

      String sql =
          "INSERT INTO city (title, state, iata_code) " + "VALUES (:title, :state, :iata_code)";
      connection.createQuery(sql).addParameter("title", c.getTitle())
          .addParameter("state", c.getState()).addParameter("iata_code", c.getIata_Code())
          .executeUpdate();

    }

  }

  @Override
  public void delete() {
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      String sql = "DELETE FROM city";
      connection.createQuery(sql).executeUpdate();

    }

  }

  @Override
  public List<City> getByParameters(Map<String, Object> parameters) {
    List<City> cities = null;

    parameters = new HashMap<String, Object>();
    DatabaseManager dbManager = new DatabaseManager();


    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      String sql = "SELECT * FROM city WHERE ";

      // Build the SQL query dynamically based on the parameters
      List<String> conditions = new ArrayList<>();
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        String key = entry.getKey();

        conditions.add(key + " = :" + key);
      }
      sql += String.join(" AND ", conditions);

      // Execute the query and map the result to FlightModel objects
      Query query = connection.createQuery(sql);
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();

        query.addParameter(key, value);

      }
      cities = query.executeAndFetch(City.class);
    }
    return cities;
  }

  @Override
  public void updateByParameters(Map<String, Object> parameters, Map<String, Object> conditions) {

    DatabaseManager dbManager = new DatabaseManager();

    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      System.out.println(parameters.size());
      StringBuilder sql = new StringBuilder("UPDATE city SET ");

      int i = 0;
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        i++;
        if (i == parameters.size())
          sql.append(entry.getKey()).append(" = :").append(entry.getKey());
        else
          sql.append(entry.getKey()).append(" = :").append(entry.getKey()).append(", ");

      }
      sql.append(" WHERE ");

      // Build the SQL query dynamically based on the parameters
      List<String> condition = new ArrayList<>();
      for (Map.Entry<String, Object> entry : conditions.entrySet()) {
        String key = entry.getKey();

        condition.add(key + " = :" + key);
      }
      sql.append(String.join(" AND ", condition));

      // Execute the query and map the result to FlightModel objects
      Query query = connection.createQuery(sql.toString());
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();

        query.addParameter(key, value);

      }
      for (Map.Entry<String, Object> entry : conditions.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();

        query.addParameter(key, value);

      }
      query.executeUpdate();
      System.out.println(query.toString());
    }
  }


  @Override
  public void deleteByParameters(Map<String, Object> parameters) {
    DatabaseManager dbManager = new DatabaseManager();

    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "DELETE FROM city WHERE ";

      // Build the SQL query dynamically based on the parameters
      List<String> conditions = new ArrayList<>();
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        String key = entry.getKey();

        conditions.add(key + " = :" + key);
      }
      sql += String.join(" AND ", conditions);

      // Execute the query and map the result to FlightModel objects
      Query query = connection.createQuery(sql);
      for (Map.Entry<String, Object> entry : parameters.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();

        query.addParameter(key, value);

      }
      query.executeUpdate();
    }

  }

  @Override
  public void update(Object t) {
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      City c = (City) t;

      String sql =
          "UPDATE city SET (title = :title, state = :state, iata_code = :iata_code";
      connection.createQuery(sql).addParameter("title", c.getTitle())
          .addParameter("state", c.getState()).addParameter("iata_code", c.getIata_Code())
          .executeUpdate();

    }

  }

}

