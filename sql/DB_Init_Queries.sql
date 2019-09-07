--Database Initialization Queries for the AirlineDB tables--
CREATE TABLE Customer (
	cid INTEGER NOT NULL PRIMARY KEY,
	cname CHAR(80) NOT NULL,
	email CHAR(40) NOT NULL, UNIQUE (email),
	address CHAR(200),
	password CHAR(16) NOT NULL
);


CREATE TABLE City (
	cityid INTEGER NOT NULL PRIMARY KEY,
	title CHAR(50) NOT NULL,
	state CHAR(2) NOT NULL
);

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



