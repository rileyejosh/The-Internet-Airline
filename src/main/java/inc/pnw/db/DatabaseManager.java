package inc.pnw.db;

import java.sql.*;
import java.util.*;
import org.sql2o.Sql2o;

// TODO: Refactor Database Manager class
/**
 * Class that handles the connection with the database
 */
public class DatabaseManager {
  ////////////// fields ////////////////////////////

  private String connectionString =
      "jdbc:mysql://127.0.0.1:3306/airlinedb?" + "autoReconnect=true&useSSL=false";
  private String user = "db_puc";
  private String password = "josh";
  
  private org.sql2o.Connection conn;
  private Sql2o sql2o;

  //////////// constructors /////////////////////

  public DatabaseManager() {

  }
  
  /**
   * Constructor that takes the connection name, username, and password
   * 
   * @param connection string to access database
   * @param url the url of the database as a string
   */
  public DatabaseManager(String connStr, String user, String pass) {
    this.connectionString = connStr;
    this.user = user;
    this.password = pass;
    
  }

  /////////////// methods //////////////////////////

  /**
   * Method for getting a connection to a database
   * 
   * @throws SQLException
   */
  public org.sql2o.Connection getConnection() {
    // try the following
    try {
      sql2o = new Sql2o(connectionString, user, password);
      // Connect to the database
      conn = sql2o.open();
      return conn;
    } catch (Exception ex) {
      System.out.println("Could not connect to the database");
      ex.printStackTrace();
    }
    return null;
  }

  /**
   * Closes current database connection
   * 
   * @throws SQLException
   */
  public void closeConnection() {

    try {
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  /**
   * Method for testing the connection
   */
  public void testConnection() {
    // try the following
    try {

      
      // Connect to the database
      sql2o = new Sql2o(connectionString, user, password);
      
      // open the connection to the database
      conn = sql2o.open();
      
      // tell the user the connection was opened
      System.out.println("Connection established");

      // close the connection
      conn.close();

      // tell the user the connection was closed
      System.out.println("The connection was closed");

    } catch (Exception ex) {
      ex.getMessage();
      ex.printStackTrace();
    }
  }

  /**
   * Method to test a query and print the results
   * 
   * @param query the query to execute
   * @param numCols the number of columns in the result
   */
  public void testQuery(String query, int numCols) {

    // try the following
    try {

      // Connect to the database
      sql2o = new Sql2o(connectionString, user, password);
      
      // open the connection to the database
      conn = sql2o.open();



      conn.close();

    } catch (Exception ex) {
      ex.getMessage();
      ex.printStackTrace();
    }
  }

  public String buildQuery(Map<String, Object> parameters) {
    StringBuilder queryBuilder = new StringBuilder("SELECT * FROM flights WHERE ");
    List<String> conditions = new ArrayList<>();
    
    for (Map.Entry<String, Object> entry : parameters.entrySet()) {
      String key = entry.getKey();
      conditions.add(key + " = :" + key);
    }

    queryBuilder.append(String.join(" AND ", conditions));
    return queryBuilder.toString();
   
  }

}
