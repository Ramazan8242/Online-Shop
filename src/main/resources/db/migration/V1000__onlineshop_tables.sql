use `onlineshop`;

create table clients(
id integer not null AUTO_INCREMENT,
name varchar (128) not null,
age integer not null,
address varchar (128) not null,
email varchar (128) not null,
primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table products(
id integer not null AUTO_INCREMENT,
name varchar(128) not null,
price integer not null,
image varchar(128) not null,
primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table orders(
id integer not null AUTO_INCREMENT,
client_id integer not null,
product_id integer not null,
primary key (id),
INDEX FK_client_idx (client_id),
INDEX FK_product_idx (product_id),
CONSTRAINT FK_client FOREIGN KEY (client_id) REFERENCES clients (id),
CONSTRAINT FK_product FOREIGN KEY (product_id) REFERENCES products (id)
);

-- create table orders_products (
-- order_id integer not null,
-- products_id integer not null
-- )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;