use storefront;
drop table city;
drop table zipcode;
drop table state;

create table state(
start int,
end int,
state_name varchar(25),
primary key(start)
);

create table zipcode(
code int,
start int,
primary key(code),
foreign key(start) REFERENCES state(start)
);

create table city(
city_code int,
start int,
city_name varchar(25),
foreign key(start) references state(start)
);

insert into state 
values (30, 34, 'Rajasthan'),
(12, 13, 'Haryana'),
(793, 794, 'Meghalaya');

insert into zipcode
values (343041, 30),
(307026, 30),
(124001, 12),
(793001, 793);

insert into city
values (3, 30, 'Abu Road'),
(4, 12, 'Rohtak');

select code, city_name, state_name
from zipcode as z
inner join state as s on s.start = z.start and round(code/10000) between s.start and s.end
inner join city as c on s.start = c.start and c.city_code = mod(round(code/1000), 10);