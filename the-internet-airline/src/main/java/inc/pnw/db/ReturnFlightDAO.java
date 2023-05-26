package inc.pnw.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReturnFlightDAO implements Dao {

  private java.sql.Date dDate;
  private java.sql.Date rDate;

  // create the database manager
  DatabaseManager dbManager = new DatabaseManager();

  public ReturnFlightDAO(java.sql.Date dDate, java.sql.Date rDate) {
    this.dDate = dDate;
    this.rDate = rDate;
  }

  @Override
  public Optional get(long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ReturnFlightModel> getAll() throws SQLException, ClassNotFoundException {
    String depCity, retCity;
    int retFid = 0, origF = 0, destF = 0, flightNumber = 0, flightClass = 0, flightCap = 0, flightAvail = 0;
    Time flightTime = null;
    float price = 0;
    java.sql.Date destD = null;

    List<ReturnFlightModel> flights = new ArrayList<ReturnFlightModel>();

    // connect to the database
    try (org.sql2o.Connection conn = dbManager.getConnection()) {

      /*
       * Query 1 uses the origin city, destination city, departure date, and return date, selected
       * by the user on the home page, to search for matching flights in the database.
       * 
       */
      String query = "SELECT"
          + " (SELECT title FROM city WHERE cityid = dep.orig) AS dep_city,"
          + " (SELECT title FROM city WHERE cityid = dep.dest) AS arr_city,"
          + " ret.fid AS ret_fid,"
          + " ret.fnumber AS ret_fnumber,"
          + " ret.fdate AS ret_fdate,"
          + " ret.ftime AS ret_ftime,"
          + " ret.price AS ret_price,"
          + " ret.class AS ret_class,"
          + " ret.capacity AS ret_capacity,"
          + " ret.avaliable AS ret_avaliable"
          + " FROM"
          + "  flight AS dep"
          + "  JOIN flight AS ret ON dep.orig = ret.dest AND dep.dest = ret.orig"
          + " WHERE"
          + "  dep.fdate = '" + dDate + "'" // TODO: Used prepared statements for inserted dates
          + "  AND ret.fdate = '" + rDate + "'"
          + "  AND dep.avaliable > 0"
          + "  AND ret.avaliable > 0;"
          ;


      ResultSet result = dbManager.executeQuery(query);
      while (result.next()) {
        depCity = result.getString("dep_city");
        retCity = result.getString("arr_city");
        retFid = result.getInt("ret_fid");
        flightNumber = result.getInt("ret_fnumber");
        destD = result.getDate("ret_fdate");
        flightTime = result.getTime("ret_ftime");
        price = result.getFloat("ret_price");
        flightClass = result.getInt("ret_class");
        flightCap = result.getInt("ret_capacity");
        flightAvail = result.getInt("ret_avaliable");    
        ReturnFlightModel flight = new ReturnFlightModel(depCity, retCity, retFid, flightNumber,
            destD, flightTime, price, flightClass, flightCap, flightAvail);
        flights.add(flight);

      }
      return flights;
    }
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
  
  // main method for debugging

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    
    Date dd = Date.valueOf("2023-03-20");
    Date rd = Date.valueOf("2023-03-25");
    ReturnFlightDAO rf = new ReturnFlightDAO(dd, rd);
    List<ReturnFlightModel> f = rf.getAll();
    if (f.size() == 0)
      System.out.println(f.size());
    for (ReturnFlightModel flight : f) {
      System.out.println(flight.getFdate());
      System.out.println(flight.getclassFlight());
      System.out.println(flight.getFtime());
      System.out.println(flight.getId());


    }
  }

  @Override
  public Optional get(int id) {
    // TODO Auto-generated method stub
    return null;
  }


}
