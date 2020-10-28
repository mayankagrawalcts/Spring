create table IF NOT EXISTS items
(
   id integer not null,
   name varchar(255) not null,
   price integer not null,
   primary key(id)
);