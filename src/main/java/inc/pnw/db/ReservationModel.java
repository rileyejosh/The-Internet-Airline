package inc.pnw.db;

/**
 * The Reservation model class represents a row in the Reservation table.
 * 
 * @author Joshua Riley
 *
 */
public class ReservationModel {

	private int orderNum, cid, dfid, rfid, qty, cardMonth, cardYear;
	private String cardNum, order_date;

	public ReservationModel(int orderNum, int cid, int dfid, int rfid, int qty, int cardMonth, int cardYear, String cardNum,
			String order_date) {
		super();
		this.orderNum = orderNum;
		this.cid = cid;
		this.dfid = dfid;
		this.rfid = rfid;
		this.qty = qty;
		this.cardMonth = cardMonth;
		this.cardYear = cardYear;
		this.cardNum = cardNum;
		this.order_date = order_date;

	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getDfid() {
		return dfid;
	}

	public void setDfid(int dfid) {
		this.dfid = dfid;
	}

	public int getRfid() {
		return rfid;
	}

	public void setRfid(int rfid) {
		this.rfid = rfid;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {

		this.cardNum = cardNum;
	}

	public int getCardMonth() {
		return cardMonth;
	}

	public void setCardMonth(int cardMonth) {
		this.cardMonth = cardMonth;
	}

	public int getCardYear() {
		return cardYear;
	}

	public void setCardYear(int cardYear) {
		this.cardYear = cardYear;
	}

	public String getOrderDate() {
		return order_date;
	}

	public void setOrderDate(String order_date) {

		this.order_date = order_date;
	}

}
