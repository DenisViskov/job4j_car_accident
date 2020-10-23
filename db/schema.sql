CREATE TABLE accident (
  id serial primary key;
  name varchar(2000)
);

insert into accident(name) values ('first');
insert into accident(name) values ('second');
insert into accident(name) values ('third');