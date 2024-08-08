create table if not exists credentials (
    id serial primary key,
    username varchar(255),
    password varchar(255),
    roles varchar(255),
    employee_id int,
    created_at timestamp,
    updated_at timestamp
);