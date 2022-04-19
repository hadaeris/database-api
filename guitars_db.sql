drop database guitardb;
drop user admin;

create user admin with password 'password';
create database guitardb with template=template0 owner=admin;
\connect guitardb;
alter default privileges grant all on tables to admin;
alter default privileges grant all on sequences to admin;

create table owners (
    owner_id integer primary key not null,
    first_name varchar(15),
    last_name varchar(15),
    email varchar(40)
);

create table guitars (
    guitar_id integer primary key not null,
    color varchar(15),
    frets varchar(15),
    body int,
    strings int,
    owner_id integer,
    foreign key (owner_id) references owners
);


create table users (
    user_id integer primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(40) not null,
    password text not null
);

create sequence users_seq increment 1 start 1;
create sequence guitars_seq increment 1 start 1
