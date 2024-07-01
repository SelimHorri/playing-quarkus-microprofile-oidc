alter table employees alter column identifier set not null;
alter table employees alter column identifier set gen_random_uuid();

alter table employees alter column hiredate set not null;
alter table employees alter column hiredate set current_date;

alter table employees alter column created_at set not null;
alter table employees alter column created_at set now();

alter table employees alter column updated_at set not null;
alter table employees alter column updated_at set now();