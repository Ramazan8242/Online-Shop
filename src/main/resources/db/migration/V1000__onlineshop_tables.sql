use `onlineshop`;

create table clients (id integer not null auto_increment, address varchar(224), age integer, email varchar(255), name varchar(128), primary key (id)) engine=InnoDB;
create table orders (id integer not null auto_increment, client_id integer, primary key (id)) engine=InnoDB;
create table products (id integer not null auto_increment, image varchar(255), name varchar(128), price decimal, order_id integer, primary key (id)) engine=InnoDB;
alter table clients add constraint UK_srv16ica2c1csub334bxjjb59 unique (email);
alter table orders add constraint FKm2dep9derpoaehshbkkatam3v foreign key (client_id) references clients (id);
alter table products add constraint FKr3aftk48ylvntpui7l04kbcc1 foreign key (order_id) references orders (id);