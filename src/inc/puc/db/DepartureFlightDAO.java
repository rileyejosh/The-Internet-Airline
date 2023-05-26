package inc.puc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is responsible for retrieving data from the AirlineDB database. It retrieves all rows
 * that match the query submitted on the Departure Flights screen from the Flight and City tables
 * and returns a collection of objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class DepartureFlightDAO implements Dao {

  private String orig, dest;
  private Date dDate;

  // create the database manager
  DatabaseManager dbManager = new DatabaseManager();

  public DepartureFlightDAO(String orig, String dest, Date dDate) {

    this.orig = orig;
    this.dest = dest;
    this.dDate = dDate;
  }

  @Override
  public List<DepartureFlightModel> getAll() throws SQLException, ClassNotFoundException {

    int origF = 0, destF = 0, flightNumber = 0, available = 0, flightClass = 0;
    Time flightTime = null;
    float price = 0;
    java.sql.Date destD = null;
    String origCity = " ", destCity = " ";
    List<DepartureFlightModel> flights = new ArrayList<DepartureFlightModel>();

    // connect to the database
    try (org.sql2o.Connection conn = dbManager.getConnection()) {
      /*
       * Query 1 uses the origin city, destination city, departure date, and return date, selected
       * by the user on the home page, to search for matching flights in the database.
       * 
       */
      String query1 = "SELECT fid, fnumber, fdate, ftime, orig, dest, avaliable, class, price "
          + "FROM Flight" + " WHERE ORIG = " + orig + " AND DEST = " + dest + " AND fdate = '"
          + dDate + "' ORDER BY ftime;";


      ResultSet result = dbManager.executeQuery(query1);
      while (result.next()) {
        flightTime = result.getTime("ftime");
        available = result.getInt("avaliable");
        flightClass = result.getInt("class");
        price = result.getFloat("price");
        destD = result.getDate("fdate");
        DepartureFlightModel flight = new DepartureFlightModel(origF, destF, flightNumber,
            available, flightClass, flightTime, price, destD);
        flights.add(flight);

      }
      /*
       * Queries 3 and 4 will retrieve the city names of the origin and destination cities for each
       * flight. These queries will be performed once for each flight found by Query 1.
       */
      String query3 =
          "SELECT title, state, cityid" + " FROM City" + " WHERE cityid = + " + origF + ";";
      result = dbManager.executeQuery(query3);
      while (result.next()) {

        origCity = result.getString("title");
        int cityID = result.getInt("cityid");
        for (int i = 0; i < flights.size(); i++) {

          if (flights.get(i).getOrig() == cityID)
            flights.get(i).setOrigCity(origCity);
        }


      }

      String query4 =
          "SELECT title, state, cityid" + " FROM City" + " WHERE cityid = + " + destF + ";";
      result = dbManager.executeQuery(query4);
      while (result.next()) {

        destCity = result.getString("title");
        int cityID = result.getInt("cityid");
        for (int i = 0; i < flights.size(); i++) {

          if (flights.get(i).getDest() == cityID)
            flights.get(i).setDestCity(destCity);
        }
      }
      return flights;
    }
  }

  // main method for debugging

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    String o = "3", d = "4";

    Date dd = Date.valueOf("2023-01-02");
    DepartureFlightDAO c = new DepartureFlightDAO(o, d, dd);
    List<DepartureFlightModel> f = c.getAll();
    if (f.size() == 0)
      System.out.println(f.size());
    for (DepartureFlightModel flight : f) {
      System.out.println(flight.getDest());
      System.out.println(flight.getOrig());
      System.out.println(flight.getFdate());
      System.out.println(flight.getclassFlight());
      System.out.println(flight.getAvailable());
      System.out.println(flight.getFtime());
      System.out.println(flight.getPrice());


    }
  }

  @Override
  public Optional get(long id) {
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

  @Override
  public Optional get(int id) {
    // TODO Auto-generated method stub
    return null;
  }

}
