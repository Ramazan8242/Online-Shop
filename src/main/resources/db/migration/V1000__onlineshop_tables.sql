use `onlineshop`;

create table baskets (id integer not null auto_increment, price integer not null, client_id integer, product_id integer, primary key (id)) engine=InnoDB;
create table clients (id integer not null auto_increment, email varchar(128), enabled bit, fullname varchar(128), password varchar(128), role varchar(128), primary key (id)) engine=InnoDB;
create table feedbacks (id integer not null auto_increment, date datetime(6), review_content varchar(255), client_id integer, order_id integer, primary key (id)) engine=InnoDB;
create table orders (id integer not null auto_increment, client_id integer, primary key (id)) engine=InnoDB;
create table orders_products (order_id integer not null, products_id integer not null) engine=InnoDB;
create table products (id integer not null auto_increment, image varchar(255), name varchar(128), price decimal(19,2), order_id integer, primary key (id)) engine=InnoDB;
alter table orders_products add constraint UK_qmviv5y7625wak8tjq4nirybh unique (products_id);
alter table baskets add constraint FKkfm6v8tpljcg2t31hto7jtj7i foreign key (client_id) references clients (id);
alter table baskets add constraint FKpj8ae6deicwsnvyj3cl254l3t foreign key (product_id) references products (id);
alter table feedbacks add constraint FKjl6ggk5fjfudwi5g2ljwohxqf foreign key (client_id) references clients (id);
alter table feedbacks add constraint FKbdhoov2mv332ks2m84owt5tv3 foreign key (order_id) references orders (id);
alter table orders add constraint FKm2dep9derpoaehshbkkatam3v foreign key (client_id) references clients (id);
alter table orders_products add constraint FKqgxvu9mvqx0bv2ew776laoqvv foreign key (products_id) references products (id);
alter table orders_products add constraint FKe4y1sseio787e4o5hrml7omt5 foreign key (order_id) references orders (id);
alter table products add constraint FKr3aftk48ylvntpui7l04kbcc1 foreign key (order_id) references orders (id);