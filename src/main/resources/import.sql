-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- create sequence if not exists employees_seq start 1;

create table if not exists employees (
    id serial primary key,
    identifier uuid,
    firstname varchar(255),
    lastname varchar(255),
    hiredate date,
    created_at timestamp,
    updated_at timestamp
);

alter table employees alter column identifier set not null;
alter table employees alter column identifier set default gen_random_uuid();

alter table employees alter column hiredate set not null;
alter table employees alter column hiredate set default current_date;

alter table employees alter column created_at set not null;
alter table employees alter column created_at set default now();

alter table employees alter column updated_at set not null;
alter table employees alter column updated_at set default now();

insert into employees (id, firstname, lastname) values 
(nextval('employees_seq'), 'selim', 'horri');

insert into employees (id, firstname, lastname) values
(nextval('employees_seq'), 'aziz', 'horri');

insert into employees (id, firstname, lastname) values
(nextval('employees_seq'), 'amine', 'ladjimi');