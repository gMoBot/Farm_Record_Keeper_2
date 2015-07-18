
drop table if exists farm_profile;
drop table if exists block_profile;
drop table if exists application_profile;
drop table if exists product_profile;
drop table if exists applicator_profile;
drop table if exists app_block_jtable;

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
	weather_condition char(30),
	temp char(20),
	wind_speed char(20),
	wind_direction char (20),
	FOREIGN KEY(farm_id) references farm_profile(farm_id),
	FOREIGN KEY(block_id) references block_profile(block_id),
--remove fk desig from blockName
--	FOREIGN KEY(block_name) references block_profile(block_name),
	FOREIGN KEY(product_name) references product_profile(product_name),
	FOREIGN KEY(appl_id) references applicator_profile(appl_id)
);

create table product_profile (
	product_name char(60),
	farm_id char(20),
	epa_number char(20) PRIMARY KEY,
	active_ingredient char(30),
	rei_hrs char(10),
	phi_days char(10),
 FOREIGN KEY(farm_id) references farm_profile(farm_id)

);

--create table app_block_jtable (
--		app_id INTEGER NOT NULL UNIQUE,
--		block_id INTEGER NOT NULL,
--		PRIMARY KEY (app_id, block_id),
----		UNIQUE KEY app_id_UNIQUE (app_id),
----		KEY fk_app (app_id),
----		KEY fk_block (block_id),
----		CONSTRAINT fk_app
--		FOREIGN KEY (app_id) REFERENCES application_profile (app_id),
----		CONSTRAINT fk_block
--		FOREIGN KEY (block_id) REFERENCES block_profile (block_id)
--
--);


.separator ,
.import farmProfile.txt farm_profile
.import block_profile.txt block_profile
.import applicator_profile.txt applicator_profile
.import product_profile.txt product_profile
