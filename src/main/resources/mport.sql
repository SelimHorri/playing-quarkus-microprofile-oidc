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

create table if not exists credentials (
    id serial primary key,
    username varchar(255),
    password varchar(255),
    roles varchar(255),
    employee_id int,
    created_at timestamp,
    updated_at timestamp
);

alter table credentials alter column username set not null;
alter table credentials alter column password set not null;
alter table credentials alter column roles set not null;
alter table credentials alter column employee_id set not null;
alter table credentials add constraint fk_employees_employee_id foreign key (employee_id) references employees (id);

alter table credentials alter column created_at set not null;
alter table credentials alter column created_at set default now();
alter table credentials alter column updated_at set not null;
alter table credentials alter column updated_at set default now();

insert into credentials (id, username, password, roles, employee_id) values
(nextval('credentials_seq'), 'selimhorri', '$2a$12$7P3BB1bAHcy7LgNzatG/X.FZl1f8KsW/GlfIXy.hd1xkAIx9tj/Eu', 'USER,EMPLOYEE', (select id from employees where firstname = 'selim' and lastname = 'horri'));

insert into credentials (id, username, password, roles, employee_id) values
(nextval('credentials_seq'), 'azizhorri', '$2a$12$nLK4/arHFNmpRCh5sfn7eecP3TdCQvLlU76WizaugDkZ9gqUCVoii', 'EMPLOYEE', (select id from employees where firstname = 'aziz' and lastname = 'horri'));

insert into credentials (id, username, password, roles, employee_id) values
(nextval('credentials_seq'), 'amineladjimi', '$2a$12$Sxx72d90/cgFW0hrtC.HGeW1ZwgZDZiF/4R9WwO05zKLvlDq03fie', 'ADMIN', (select id from employees where firstname = 'amine' and lastname = 'ladjimi'));