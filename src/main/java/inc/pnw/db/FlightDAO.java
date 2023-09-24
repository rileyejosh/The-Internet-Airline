package inc.pnw.db;


import java.sql.SQLException;

import java.text.ParseException;
import java.time.LocalDate;

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


    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      String sql = "SELECT * FROM flight WHERE ";

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
      flights = query.executeAndFetch(FlightModel.class);
    } catch (Exception ex) {

      // Handle or log the exception appropriately

      ex.printStackTrace();
      throw ex;
    }

    return flights;
  }


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
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      FlightModel f = (FlightModel) t;

      String sql =
          "INSERT INTO flight (fnumber, fdate, ftime, price, classFlight, capacity, available, orig, dest) "
              + "VALUES (:fnumber, :fdate, :ftime, :price, :classFlight, :capacity, :available, :orig, :dest)";
      connection.createQuery(sql).addParameter("fnumber", f.getFnumber())
          .addParameter("fdate", f.getFdate()).addParameter("ftime", f.getFtime())
          .addParameter("price", f.getPrice()).addParameter("classFlight", f.getClassFlight())
          .addParameter("capacity", f.getCapacity()).addParameter("available", f.getAvailable())
          .addParameter("dest", f.getDest()).addParameter("orig", f.getOrig()).executeUpdate();

    }

  }



  @Override
  public void delete() {
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      String sql = "DELETE FROM flight";
      connection.createQuery(sql).executeUpdate();

    }

  }


  @Override
  public void update(Object t) {
    DatabaseManager dbManager = new DatabaseManager();
    try (org.sql2o.Connection connection = dbManager.getConnection()) {

      FlightModel f = (FlightModel) t;

      String sql =
          "UPDATE flight SET (fnumber = :fnumber, fdate = :fdate,  ftime = :ftime, price = :price, classFlight = :classFlight, capacity = :capacity, available = :available, orig = :orig, dest = :dest";
      connection.createQuery(sql).addParameter("fnumber", f.getFnumber())
          .addParameter("fdate", f.getFdate()).addParameter("ftime", f.getFtime())
          .addParameter("price", f.getPrice()).addParameter("classFlight", f.getClassFlight())
          .addParameter("capacity", f.getCapacity()).addParameter("available", f.getAvailable())
          .addParameter("orig", f.getOrig()).addParameter("dest", f.getDest()).executeUpdate();

    }

  }


  @Override
  public void updateByParameters(Map<String, Object> parameters, Map<String, Object> conditions) {
    DatabaseManager dbManager = new DatabaseManager();

    try (org.sql2o.Connection connection = dbManager.getConnection()) {
      System.out.println(parameters.size());
      StringBuilder sql = new StringBuilder("UPDATE flight SET ");

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
      String sql = "DELETE FROM flight WHERE ";

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




}
