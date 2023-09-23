-- DDL Commands for AirlineDB tables --

/** 
 * This table stores all of the information associated with a given user. 
 * It is used to authenticate users attempting to login as well as retrieving
 * their e-mail address and shipping information about user during check out.
 * A user's cid is used by other tables to track a user's orders and movement in the system.
 */
CREATE TABLE Customer (
	cid INTEGER NOT NULL PRIMARY KEY,
	cname CHAR(80) NOT NULL,
	email CHAR(40) NOT NULL, UNIQUE (email),
	address CHAR(200),
	password CHAR(16) NOT NULL
);

/** 
 * Each entry in this table represents a city that is a supported flight.
 * When a user searches for a specific flight, they first select origin and
 * destination cities.
 */
CREATE TABLE City (
	cityid INTEGER NOT NULL PRIMARY KEY,
	title CHAR(50) NOT NULL,
	state CHAR(2) NOT NULL,
	iata_code char(3)
);

/** 
 * Each entry in this table represents a flight the website is offering. 
 * When users search for flights, this table is consulted for that information.
 * The field fid is the primary key, while the field fnumber is simply the airplane's flight number,
 * which may not be unique. The fields, orig and dest, represent the origin and destination cities
 * for the flight that can be translated using the City table.
 * 
 * The field capacity represents the maximum number of tickets for the flight, and
 * the field available represents how many tickets are available. If, during a transaction,
 * the field available for a flight is ever set to be a negative number, then the application
 * server recognizes there are not enough tickets available to fulfill the order and aborts the transaction.
 */
CREATE TABLE Flight (
	fid INTEGER NOT NULL PRIMARY KEY,
	fnumber INTEGER,
	fdate DATE NOT NULL,
	ftime TIME NOT NULL,
	price REAL NOT NULL,
	class INTEGER NOT NULL,
	capacity INTEGER NOT NULL,
	available INTEGER NOT NULL,
	orig INTEGER NOT NULL,
	dest INTEGER NOT NULL,
	FOREIGN KEY (orig) REFERENCES City,
	FOREIGN KEY (dest) REFERENCES City 
);


/** 
 * This table stores one entry for each order the user places. The fields dfid and rfid
 * represent the departure and return flights, which can be translated using the Flight table.
 * If rfid is set to null then it signifies that this is a one-way flight; otherwise, the flight
 * is a round trip. The table also stores the credit card information for the flight, 
 * as well as an order date stamp.
 */
CREATE TABLE Reservation (
	ordernum INTEGER NOT NULL PRIMARY KEY,
	cid INTEGER NOT NULL,
	dfid INTEGER NOT NULL,
	rfid INTEGER,
	qty INTEGER NOT NULL,
	cardnum CHAR(16) NOT NULL,
	cardmonth INTEGER NOT NULL,
	cardyear INTEGER NOT NULL,
	order_date DATE,
	FOREIGN KEY (cid) REFERENCES Customer,
	FOREIGN KEY (dfid) REFERENCES Flight,
	FOREIGN KEY (rfid) REFERENCES Flight 
);



