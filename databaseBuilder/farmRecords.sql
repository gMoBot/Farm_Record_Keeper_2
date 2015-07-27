
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
	city char(10),
	zipcode char(20)
	);

create table applicator_profile (
	appl_id INTEGER PRIMARY KEY AUTOINCREMENT,
	app_number char(20),
	farm_id char(20),
	app_name char(60),
	street_address char(60),
	state_code char(10),
	city char(10),
	zipcode char(20),
  FOREIGN KEY(farm_id) references farm_profile(farm_id)

);

create table block_profile (
	block_id INTEGER PRIMARY KEY AUTOINCREMENT,
	farm_id char(20),
	block_name char(60),
	block_street_address char(60),
	block_state_code char(40),
	city char(10),
	block_zipcode char(40),
	block_size DECIMAL (10, 2),
	block_crop char(20),
	FOREIGN KEY(farm_id) references farm_profile(farm_id)
);

create table application_profile (
	app_id INTEGER PRIMARY KEY AUTOINCREMENT,
	farm_id char(20),
	block_name char(60),
	block_id INTEGER,
	product_name char(60),
	prod_id INTEGER,
	app_number char(20),
	appl_id INTEGER,
	app_date char(30),
    target_pest char(40),
    app_notes char(200),
	app_time char(30),
	app_rate char(30),
	rate_unit char(20),
	carrier_vol char(20),
	app_method char(30),
	rows_applied char(30),
	weather_condition char(30),
	temp char(20),
	wind_speed char(20),
	wind_direction char (20),
	FOREIGN KEY(farm_id) references farm_profile(farm_id),
	FOREIGN KEY(block_id) references block_profile(block_id),
	FOREIGN KEY(prod_id) references product_profile(prod_id),
	FOREIGN KEY(appl_id) references applicator_profile(appl_id)
);

create table product_profile (
	prod_id INTEGER PRIMARY KEY AUTOINCREMENT,
	product_name char(60),
	farm_id char(20),
	epa_number char(20),
	active_ingredient char(30),
	rei_hrs char(10),
	phi_days char(10),
 FOREIGN KEY(farm_id) references farm_profile(farm_id)

);

.separator ,
.import farmProfile.txt farm_profile
.import block_profile.txt block_profile
.import applicator_profile.txt applicator_profile
.import product_profile.txt product_profile
