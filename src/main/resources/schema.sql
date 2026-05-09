create table users(
id int primary key,
name varchar(255) not null,
email varchar(255) not null,
password varchar(20) not null,
phone varchar(255) not null,
role varchar(255) not null,
created_at timestamp not null
);