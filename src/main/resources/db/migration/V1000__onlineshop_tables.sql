create schema if not exists onlineshop collate utf8mb4_0900_ai_ci;

create table if not exists clients
(
	id int auto_increment
		primary key,
	address varchar(224) null,
	age int null,
	email varchar(255) null,
	name varchar(128) null,
	constraint UK_srv16ica2c1csub334bxjjb59
		unique (email)
);

create table if not exists orders
(
	id int auto_increment
		primary key,
	client_id int null,
	constraint FKm2dep9derpoaehshbkkatam3v
		foreign key (client_id) references clients (id)
);

create table if not exists products
(
	id int auto_increment
		primary key,
	image varchar(255) null,
	name varchar(128) null,
	price int null,
	order_id int null,
	constraint FKr3aftk48ylvntpui7l04kbcc1
		foreign key (order_id) references orders (id)
);