package inc.pnw.db;

import java.sql.Date;
import java.sql.Time;

public class FlightDTO {

  private FlightModel flight;
  private CityDTO city;
  
  public FlightModel getFlight() {
    return flight;
  }

  public void setFlight(FlightModel flight) {
    this.flight = flight;
  }

  public CityDTO getCity() {
    return city;
  }

  public void setCity(CityDTO city) {
    this.city = city;
  }
  
  
  
}
