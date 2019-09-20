package inc.puc.db;

/**
 * The Flight model class represents a row in the Flight table.
 * 
 * @author Joshua Riley
 *
 */
public class Flight {

	private int fid, fnumber, classFlight, capacity, available, orig, dest;
	private String fdate, ftime;
	private float price;

	public Flight(int fid, int fnumber, int classFlight, int capacity, int available, int orig, int dest, String fdate,
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

	public String getDate() {
		return fdate;
	}

	public void setDate(String fdate) {

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
