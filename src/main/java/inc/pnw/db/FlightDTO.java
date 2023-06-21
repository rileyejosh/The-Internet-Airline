package inc.pnw.db;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {

  private FlightModel flight;
<<<<<<< Updated upstream
  private CityDTO city;
  
=======
  private CityDTO originCity;
  private CityDTO arrivalCity;
  


  public CityDTO getOriginCity() {
    return originCity;
  }

  public void setOriginCity(CityDTO originCity) {
    this.originCity = originCity;
  }

  public CityDTO getArrivalCity() {
    return arrivalCity;
  }

  public void setArrivalCity(CityDTO arrivalCity) {
    this.arrivalCity = arrivalCity;
  }

>>>>>>> Stashed changes
  public FlightModel getFlight() {
    return flight;
  }

  public void setFlight(FlightModel flight) {
    this.flight = flight;
  }

<<<<<<< Updated upstream
  public CityDTO getCity() {
    return city;
  }

  public void setCity(CityDTO city) {
    this.city = city;
  }
=======

  
  
>>>>>>> Stashed changes
  
  
  
}
