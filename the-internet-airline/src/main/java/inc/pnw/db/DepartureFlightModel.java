package inc.pnw.db;

import java.sql.Date;
import java.sql.Time;

/**
 * The DepartureFlight model class combines rows from the Flight and City tables to populate the Departure Flight page.
 * 
 * @author Joshua Riley
 *
 */
public class DepartureFlightModel {
  private int fid, fnumber, classFlight, capacity, available, orig, dest;
  private Date fdate;
  private String origCity, destCity;
  private Time ftime;
  private float price;
  

  
  public DepartureFlightModel(int origID, int destID, int fnumber, int avail, int fClass, Time fTime, 
      float price, Date destD) {
      
    this.orig = origID;
    this.dest = destID;
    this.fnumber = fnumber;
    this.available = avail;
    this.classFlight = fClass;
    this.ftime = fTime;
    this.price = price;
    this.fdate = destD;
      
    
  }
  
  public String getOrigCity() {
    return origCity;
  }
  
  public void setOrigCity(String o) {
    
    this.origCity = o;
    
  }
  
  public String getDestCity() {
    return destCity;
  }
  
  public void setDestCity(String d) {
    
    this.destCity = d;
    
  }
  
  
  
  public int getId() {
      return fid;
  }

  public void setId(int fid) {
      this.fid = fid;
  }

  public int getFnumber() {
      return fnumber;
  }

  public void setFnumber(int fnumber) {
      this.fnumber = fnumber;
  }

  public int getclassFlight() {
      return classFlight;
  }

  public void setClassFlight(int classFlight) {
      this.classFlight = classFlight;
  }

  public int getCapacity() {
      return capacity;
  }

  public void setCapacity(int capacity) {

      this.capacity = capacity;
  }

  public int getAvailable() {
      return available;
  }

  public void setAvailable(int available) {
      this.available = available;
  }

  public int getOrig() {
      return orig;
  }

  public void setOrig(int orig) {
      this.orig = orig;
  }

  public int getDest() {
      return dest;
  }

  public void setDest(int dest) {
      this.dest = dest;
  }

  public Date getFdate() {
      return fdate;
  }

  public void setFdate(Date fdate) {

      this.fdate = fdate;
  }

  public Time getFtime() {
      return ftime;
  }

  public void setFtime(Time ftime) {

      this.ftime = ftime;
  }

  public float getPrice() {
      return price;
  }

  public void setPrice(float price) {

      this.price = price;
  }

}
