package inc.pnw.db;

import java.sql.Date;

/**
 * The Flight model class represents a row in the Flight table.
 * 
 * @author Joshua Riley
 *
 */
public class FlightModel {

	private int fid, fnumber, classFlight, capacity, available, orig, dest;
	Date fdate;
	private String ftime;
	private float price;

	public FlightModel(int fid, int fnumber, int classFlight, int capacity, int available, int orig, int dest, Date fdate,
			String ftime, float price) {
		super();
		this.fid = fid;
		this.fnumber = fnumber;
		this.classFlight = classFlight;
		this.capacity = capacity;
		this.available = available;
		this.orig = orig;
		this.dest = dest;
		this.fdate = fdate;
		this.ftime = ftime;
		this.price = price;

	}
	public FlightModel(int orig, int dest, Date fdate) {
	  
	  this.orig = orig;
	  this.dest = dest;
	  this.fdate = fdate;
	  
	}

	public int getId() {
		return fid;
	}

	public void setId(int fid) {
		this.fid = fid;
	}

	public int getNumber() {
		return fnumber;
	}

	public void setNumber(int fnumber) {
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

	public Date getDate() {
		return fdate;
	}

	public void setDate(Date fdate) {

		this.fdate = fdate;
	}

	public String getTime() {
		return ftime;
	}

	public void setTime(String ftime) {

		this.ftime = ftime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {

		this.price = price;
	}

}
