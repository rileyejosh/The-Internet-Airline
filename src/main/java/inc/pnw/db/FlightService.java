package inc.pnw.db;

import java.util.HashMap;
import java.util.List;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class FlightService extends ServiceBase {
  
  private static List<FlightDTO> flightList;
  private static List<FlightModel> flights;
  private static FlightDAO flightDao;
  private static FlightDTO fDto;

  
  public static void main(String[] args) {
      
      List<String> t = new ArrayList<String>();
      t.add("[{\"originCity\":\"Tokyo\",\"destinationCity\":\"Delhi\",\"date\":\"2023-03-20\",\"flightNumber\":\"1003\",\"available\":\"20\",\"flightClass\":\"3\",\"flightTime\":\"15:00:00\",\"price\":\"200.0\"}]");
      t.add("{\"originCity\":\"Delhi\",\"destinationCity\":\"Tokyo\",\"date\":\"2023-03-25\",\"flightNumber\":\"6 \",\"available\":\"1\",\"flightClass\":\"25\",\"flightTime\":\"13:45:00\",\"price\":\"100.0\"}");
      List<FlightDTO> ft = FlightService.getFlightTicket(t);
      
      System.out.println(ft.get(0).getOriginCity().getCity().get());
// // Create a java.time.LocalDate object representing the desired date
//    LocalDate localDate = LocalDate.of(2023, 03, 25);
//
//    // Convert the java.time.LocalDate to java.sql.Date
//    java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
//
//    System.out.println(sqlDate); // Output: 2023-03-20
//    List<FlightModel> f = FlightService.retrieveDepartureFlights("3", "1", sqlDate);
//    try {
//      List<FlightModel> r = FlightService.retrieveReturnFlights(Integer.parseInt(ServiceBase.filterJson("{\"originCity\":\"Delhi\",\"destinationCity\":\"Tokyo\",\"date\":\"2023-03-25\",\"flightNumber\":\"6 \",\"available\":\"1\",\"flightClass\":\"25\",\"flightTime\":\"13:45:00\",\"price\":\"100.0\"}", "flightNumber").trim()), sqlDate);
//      for(FlightModel rf : r ) {
//        System.out.println(rf.getFid() + " " + rf.getFnumber());
//      }
//    } catch (ClassNotFoundException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (SQLException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (JsonMappingException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (NumberFormatException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (JsonProcessingException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
    
  }
   static List<FlightDTO> getCityNamesForFlights(List<FlightModel> flights) throws ClassNotFoundException, SQLException {
     flightList = new ArrayList<>();
     Map<String, String> cityMap = CityService.getCityIDName();

     for(FlightModel f : flights ) {

       // add all flights to the FlightDto.Flight attribute
       fDto = new FlightDTO();
       fDto.setFlight(f);  
       fDto.setOriginCity(new CityDTO());
       fDto.setArrivalCity(new CityDTO());
       fDto.getOriginCity().setCity(CityService.createCity());
       fDto.getArrivalCity().setCity(CityService.createCity());
       fDto.getOriginCity().getCity().get().setTitle(cityMap.get(String.valueOf(f.getOrig())));
       fDto.getArrivalCity().getCity().get().setTitle(cityMap.get(String.valueOf(f.getDest())));

   
       // add flights /w city names to list of flight DTOs
       flightList.add(fDto);
     }
    return flightList;
  }
   
  static List<FlightModel> retrieveDepartureFlights(String origCity, String destCity, java.sql.Date dDate) {
    
    Map<String, Object> fMap = new HashMap<String, Object>();
    fMap.put("orig", origCity);
    fMap.put("dest", destCity);

    fMap.put("fdate", dDate);
    flightDao = new FlightDAO();

    return flightDao.getByParameters(fMap);
      
      
  }
  
  static FlightDTO retrieveFlight(String jsonStr) {
    
    FlightDTO flight = new FlightDTO();
    flight.setOriginCity(new CityDTO());
    flight.setArrivalCity(new CityDTO());
    flight.setFlight(new FlightModel());

    List<String> flightStr = ServiceBase.convertJsonToList(jsonStr);
    for(int i = 0; i < flightStr.size(); i++) {
        
      switch (i) {
        case 0:
            flight.getOriginCity().setCity(Optional.ofNullable(new City()));
            flight.getOriginCity().getCity().get().setTitle(flightStr.get(i));
            break;
        case 1:
            flight.getArrivalCity().setCity(Optional.ofNullable(new City()));
            flight.getArrivalCity().getCity().get().setTitle(flightStr.get(i));
            break;
        case 2:
            flight.getFlight().setFdate(java.sql.Date.valueOf(flightStr.get(i).trim()));
            break;
        case 3:
            flight.getFlight().setFnumber(Integer.valueOf(flightStr.get(i).trim()));
            break;
        case 4:
            flight.getFlight().setAvailable(Integer.valueOf(flightStr.get(i).trim()));
            break;
        case 5:
            flight.getFlight().setClassFlight(Integer.valueOf(flightStr.get(i).trim()));
            break;
        case 6:
            flight.getFlight().setFtime(java.sql.Time.valueOf(flightStr.get(i).trim()));
            break;
        case 7:
            flight.getFlight().setPrice(Float.valueOf( flightStr.get(i).trim()));
            
      }
         
    }
       
    return flight;
  }
 
  static List<FlightDTO> getFlightTicket(List<String> flight) {
    
    List<FlightDTO> flightTicket = new ArrayList<FlightDTO>();
    
    for(String s : flight ) {
      
      flightTicket.add(FlightService.retrieveFlight(s.replaceAll("\\[|\\]", "")));
    }
    
    return flightTicket;
  }
  
  static int getFlightTicketPrice(List<FlightDTO> f) {
    
    int sum = 0;
    
    for(FlightDTO dto : f)
      sum += dto.getFlight().getPrice();
    
//    if(f.size() > 1)
//      double originalPrice = 100.0;
//    double discountPercentage = 40.0;
//    double discountAmount = originalPrice * (discountPercentage / 100.0);
//    double finalPrice = originalPrice - discountAmount;
    return sum;
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
          

          if((flight.getFid() == dFlight) && (flightG.fdate.compareTo(rDate) == 0)) {
            
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
