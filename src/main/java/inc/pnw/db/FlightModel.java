package inc.pnw.db;

import java.sql.Date;
import java.sql.Time;

/**
 * The Flight model class represents a row in the Flight table.
 * 
 * @author Joshua Riley
 *
 */
public class FlightModel {

	private int fid, fnumber, classflight, capacity, available;
    protected int orig;
    protected int dest;
	Date fdate;
	private Time ftime;
	private double price;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getFnumber() {
		return fnumber;
	}

	public void setFnumber(int fnumber) {
		this.fnumber = fnumber;
	}

	public int getclassFlight() {
		return classflight;
	}

	public void setClassFlight(int classFlight) {
		this.classflight = classFlight;
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

<<<<<<< Updated upstream
	public Time getTime() {
		return ftime;
	}

	public void setTime(Time ftime) {
=======
<<<<<<< Updated upstream
	public String getTime() {
		return ftime;
	}

	public void setTime(String ftime) {
=======
	public Time getFtime() {
		return ftime;
	}

	public void setFtime(Time ftime) {
>>>>>>> Stashed changes
>>>>>>> Stashed changes

		this.ftime = ftime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {

		this.price = price;
	}

}
