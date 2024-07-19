alter table employees alter column identifier set not null;
alter table employees alter column identifier set default gen_random_uuid();

alter table employees alter column hiredate set not null;
alter table employees alter column hiredate set default current_date;

alter table employees alter column created_at set not null;
alter table employees alter column created_at set default now();

alter table employees alter column updated_at set not null;
alter table employees alter column updated_at set default now();