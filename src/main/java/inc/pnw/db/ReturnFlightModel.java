package inc.pnw.db;

import java.sql.Date;
import java.sql.Time;

public class ReturnFlightModel {
  private int fid, fnumber, classFlight, capacity, orig, dest, cap, avail;
  private String depCity, arrCity;
  private Date fdate;
  private String origCity, destCity;
  private Time ftime;
  private float price;
  

  
  public ReturnFlightModel(String depCity, String arrCity, int fid, int fnumber, java.sql.Date fDate, Time fTime, 
      float price, int fClass, int cap, int avail) {
      
    this.depCity = depCity;
    this.arrCity = arrCity;
    this.fid = fid;
    this.fnumber = fnumber;
    this.fdate = fDate;
    this.ftime = fTime;
    this.price = price;
    this.classFlight = fClass;
    this.cap = cap;
    this.avail = avail;
   
    
  }
  
  public int getAvail() {
    return avail;
}

public void setAvail(int avail) {
    this.avail = avail;
}

  
  
  public int getCap() {
      return cap;
  }

  public void setCap(int cap) {
      this.cap = cap;
  }
  
  
  public String getdepCity() {
    return depCity;
  }
  
  public void setdepCity(String o) {
    
    this.depCity = o;
    
  }
  
  public String getArrCity() {
    return arrCity;
  }
  
  public void setDepCity(String o) {
    
    this.arrCity = o;
    
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
