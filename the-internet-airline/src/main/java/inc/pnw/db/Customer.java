package inc.pnw.db;

/**
 * The Customer model class represents a row in the Customer table.
 * 
 * @author Joshua Riley
 *
 */
public class Customer {

	private int cid;
	private String cname, email, address, password;

	public Customer(int cid, String cname, String email, String address, String password) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.address = address;
		this.password = password;

	}

	public int getId() {
		return cid;
	}

	public void setId(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return cname;
	}

	public void setName(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

}
