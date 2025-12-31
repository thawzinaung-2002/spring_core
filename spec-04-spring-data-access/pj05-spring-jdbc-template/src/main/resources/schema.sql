DROP TABLE IF EXISTS TOWNSHIP;
DROP TABLE IF EXISTS DISTRICT;
DROP TABLE IF EXISTS DIVISION;


create table DIVISION(
	id int primary key,
	name varchar(50) not null
);



create table DISTRICT(
	id int primary key,
	name varchar(50) not null,
	division_id int not null,
	foreign key (division_id) references DIVISION(id)
);



create table TOWNSHIP(
	id int primary key,
	name varchar(50) not null,
	district_id int not null,
	foreign key (district_id) references DISTRICT(id)
);