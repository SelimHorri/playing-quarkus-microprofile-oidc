create table if not exists employees (
    id serial primary key,
    identifier uuid,
    firstname varchar(255),
    lastname varchar(255),
    hiredate date,
    created_at timestamp,
    updated_at timestamp
);