use `onlineshop`;

create table clients(
id integer(11) not null AUTO_INCREMENT,
name varchar (128) not null,
address varchar (128) not null,
email varchar (128) not null,
primary key (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table orders(
id integer(11) not null AUTO_INCREMENT,
primary key (id)
);

create table products(
id integer(11) not null AUTO_INCREMENT,
name varchar (128) not null,
primary key (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;