
drop table if exists farm_profile;
drop table if exists block_profile;
drop table if exists application_profile;
drop table if exists product_profile;
drop table if exists applicator_profile;

create table farm_profile (
	farm_id INTEGER PRIMARY KEY AUTOINCREMENT,
	farm_name char(60),
	owner_name char(60),
	street_address char(60),
	state_code char(10),
	zipcode char(20)
	);

create table applicator_profile (
	app_number char(20) PRIMARY KEY,
-- 	add app name
	farm_id char(20),
	app_name char(60),
	street_address char(60),
	state_code char(10),
	zipcode char(20),
  FOREIGN KEY(farm_id) references farm_profile(farm_id)

);

create table block_profile (
	block_id INTEGER PRIMARY KEY AUTOINCREMENT,
	farm_id char(20),
	block_name char(60),
	block_street_address char(60),
	block_state_code char(40),
	block_zipcode char(40),
	block_size DECIMAL (10, 2),
	block_crop char(20),
	FOREIGN KEY(farm_id) references farm_profile(farm_id)
);

create table application_profile (
	app_id INTEGER PRIMARY KEY AUTOINCREMENT,
	farm_id char(20),
	block_name char(60),
	product_name char(60),
	app_number char(20),
	app_date char(30),
  target_pest char(40),
  app_notes char(200),
	app_time char(30),
	FOREIGN KEY(farm_id) references farm_profile(farm_id),
	FOREIGN KEY(block_name) references block_profile(block_name),
	FOREIGN KEY(product_name) references product_profile(product_name),
	FOREIGN KEY(app_number) references applicator_profile(app_number)
);

create table product_profile (
	product_name char(60),
	farm_id char(20),
	epa_number char(20) PRIMARY KEY,
	rei_hrs char(10),
	phi_days char(10),
 FOREIGN KEY(farm_id) references farm_profile(farm_id)

);


.separator ,
.import farmProfile.txt farm_profile

