alter table credentials alter column username set not null;
alter table credentials alter column password set not null;
alter table credentials alter column roles set not null;
alter table credentials alter column employee_id set not null;
alter table credentials add constraint fk_employees_employee_id foreign key (employee_id) references employees (id);

alter table credentials alter column created_at set not null;
alter table credentials alter column created_at set default now();
alter table credentials alter column updated_at set not null;
alter table credentials alter column updated_at set default now();