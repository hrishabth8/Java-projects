create table blood_bank(
	Hospital_Id varchar(50),
	Hospital_Name varchar(50),
	pincode varchar(50),
	Adress varchar(50),
	Phone_No varchar(50),
	primary key (Hospital_Id)
);


Create table Login(
	Email_Id varchar(50),
	password varchar(50),
	primary key (Email_Id)
);

Create table LoginDetails(
	Name varchar(50),
	DoB Date,
	pincode varchar(50),
	Email_Id varchar(50),
	primary key (Email_Id)
);

create table blood_donation_slots(
	Email_Id varchar(50) NOT NULL,
	Date Date NOT NULL,
	Time Time NOT NULL,
	pincode varchar(50) NOT NULL,
	Hospital_Id varchar(50) NOT NULL,
	primary key(Email_Id),
	foreign key (Email_Id) references Login(Email_Id),
	UNIQUE(Email_Id, Date, Time)	
);

create table Request(
	Email_Id varchar(50) NOT NULL,
	Blood_Group varchar(50) NOT NULL,
	Quantity varchar(50) NOT NULL,
	pincode varchar(50) NOT NULL,
	Hospital_Id varchar(50) NOT NULL,
	Phone_No varchar(50) NOT NULL,
	date Date NOT NULL,
	primary key(Phone_No,Email_Id),
	foreign key (Email_Id) references login(Email_Id),
	FOREIGN KEY (Hospital_Id) REFERENCES blood_bank(Hospital_Id)
);

create table stock(
	Hospital_Id varchar(50),
	Apve int,
	Bpve int,
	Opve int,
	ABpve int,
	Anve int,
	Bnve int,
	Onve int,
	ABnve int,
	Primary key (Hospital_Id)
);