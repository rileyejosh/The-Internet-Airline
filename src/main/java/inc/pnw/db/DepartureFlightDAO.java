package inc.pnw.db;

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
import java.util.Map;
import java.util.HashMap;

/**
 * This class is responsible for retrieving data from the AirlineDB database. It retrieves all rows
 * that match the query submitted on the Departure Flights screen from the Flight and City tables
 * and returns a collection of objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class DepartureFlightDAO implements Dao<DepartureFlightModel, Object> {

  private String orig, dest;
  private Date dDate;
  int origF = 0, destF = 0, flightNumber = 0, available = 0, flightClass = 0;
  Time flightTime = null;
  float price = 0;
  java.sql.Date destD = null;
  String origCity = " ", destCity = " ";

  // create the database manager
  DatabaseManager dbManager = new DatabaseManager();
  
  List<CityModel> cities = null;
  List<DepartureFlightModel> flights = null;
  
  public DepartureFlightDAO(String orig, String dest, Date dDate) {

    this.orig = orig;
    this.dest = dest;
    this.dDate = dDate;
  }
  
  private void getCityForFlights(List<DepartureFlightModel> flights, List<CityModel> cities) {
      
      Map<Integer, String> cityMap = new HashMap<>();
      
      for(CityModel city : cities) {
        
        cityMap.put(city.getId(), city.getTitle());
      }
      for(DepartureFlightModel f : flights) {         
          
          int origCityId = f.getOrig();
          String origCity = cityMap.get(origCityId);
          f.setOrigCity(origCity);
          
      }    
  }
  
  @Override
  public List<DepartureFlightModel> getAll() throws SQLException, ClassNotFoundException {

    // connect to the database
    try (org.sql2o.Connection conn = dbManager.getConnection()) {
      /*
       * Query 1 uses the origin city, destination city, departure date, and return date, selected
       * by the user on the home page, to search for matching flights in the database.
       * 
       */
      
      String query1 = "SELECT fid, fnumber, fdate, ftime, orig, dest, avaliable, class, price " + 
      "FROM Flight WHERE ORIG = :orig AND DEST = :dest AND fdate = :dDate ORDER BY ftime;";
     
       flights = conn.createQuery(query1)
                         .addParameter("orig", orig)
                         .addParameter("dest", dest)
                         .addParameter("dDate", dDate)
                         .executeAndFetch(DepartureFlightModel.class);
        

      
      /*
       * Queries 2 and 3 will retrieve the city names of the origin and destination cities for each
       * flight. These queries will be performed once for each flight found by Query 1.
       */
      String query2 =
          "SELECT title, state, cityid FROM City WHERE cityid = :origF;";
      
      
      cities = conn.createQuery(query2).addParameter("origF", origF).executeAndFetch(CityModel.class);
      
      getCityForFlights(flights, cities);

      String query3 =
          "SELECT title, state, cityid  FROM City WHERE cityid = :destF;";
      cities = conn.createQuery(query3).addParameter("destF", destF).executeAndFetch(CityModel.class);
      
      getCityForFlights(flights, cities);
      
    }
      return flights;
   }

  @Override
  public Optional<DepartureFlightModel> get(Object id) {
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
  public List<DepartureFlightModel> getByParameters(Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return null;
  }

}
