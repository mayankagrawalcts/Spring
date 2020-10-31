create table if not exists item
(
id integer not null,
name varchar(255) not null,
price integer not null,
primary key(id)
);

create table if not exists person (
	id integer identity primary key,
	first_name varchar(30),
	last_name varchar(30)
);