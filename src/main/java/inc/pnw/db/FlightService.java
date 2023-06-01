package inc.pnw.db;

import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

public class FlightService extends ServiceBase {
  
  private static List<FlightDTO> flightList;
  private static List<FlightModel> flights;
  private static CityDAO cityDao = new CityDAO();
  private static FlightDAO flightDao;

  
  public static void main(String[] args) {
    
    
  }
   static List<FlightDTO> getCityNamesForFlights(List<FlightModel> flights) throws ClassNotFoundException, SQLException {
     flights = new ArrayList<>();
     flightList = new ArrayList<>();
     Map<Integer, String> cityMap = CityService.getCityIDName();
     
     for(FlightModel f : flights ) {

       // add all flights to the FlightDto.Flight attribute
       FlightDTO fDto = new FlightDTO();
       fDto.setFlight(f);  
       fDto.setCity(new CityDTO());
       fDto.getCity().getCity().get().setTitle(cityMap.get(f.getOrig()));
       fDto.getCity().getCity().get().setTitle(cityMap.get(f.getDest()));
   
       // add flights /w city names to list of flight DTOs
       flightList.add(fDto);
     }
    return flightList;
  }
   
  static List<FlightModel> retrieveDepartureFlights(String origCity, String destCity, java.sql.Date dDate) {
    
    Map<String, Object> fMap = new HashMap<String, Object>();
    fMap.put("orig", origCity);
    fMap.put("dest", destCity);
    fMap.put("dDate", dDate);
    
    return flightDao.getByParameters(fMap);
      
      
  }
  
  static List<FlightModel> retrieveReturnFlights(int dFlight, java.sql.Date rDate) throws ClassNotFoundException, SQLException {
    List<FlightModel> f;
    List<FlightModel> g;
    flightDao = new FlightDAO();
    f = flightDao.getAll();
    g = flightDao.getAll();
    flights = new ArrayList<FlightModel>();
    for(FlightModel flight : f) {
      
      for(FlightModel flightG : g) {
        
        if(flight.getOrig() == flightG.getDest() && flight.getDest() == flightG.getOrig()) {
          
          if((flight.getId() == dFlight) && (flightG.fdate.compareTo(rDate) == 0)) {
            
            flights.add(flightG);
            
          }
        }
      }
      
    }
    /**
     *  SELECT G.*
        FROM Flight F
        JOIN Flight G ON F.orig = G.dest AND F.dest = G.orig
        WHERE F.fid = 6
        AND G.fdate = '2023-03-25'
        ORDER BY G.ftime;
     */
    // Should return -- '30', '987', '2023-03-25', '13:15:00', '120', '1', '250', '200', '1', '3'
    
    return flights;
    
  }
}
