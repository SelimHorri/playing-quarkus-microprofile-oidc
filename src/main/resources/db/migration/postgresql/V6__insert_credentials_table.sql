insert into credentials (username, password, roles, employee_id) values
('selimhorri', '$2a$12$7P3BB1bAHcy7LgNzatG/X.FZl1f8KsW/GlfIXy.hd1xkAIx9tj/Eu', 'USER,EMPLOYEE', (select id from employees where firstname = 'selim' and lastname = 'horri'));

insert into credentials (username, password, roles, employee_id) values
('azizhorri', '$2a$12$nLK4/arHFNmpRCh5sfn7eecP3TdCQvLlU76WizaugDkZ9gqUCVoii', 'EMPLOYEE', (select id from employees where firstname = 'aziz' and lastname = 'horri'));

insert into credentials (username, password, roles, employee_id) values
('amineladjimi', '$2a$12$Sxx72d90/cgFW0hrtC.HGeW1ZwgZDZiF/4R9WwO05zKLvlDq03fie', 'ADMIN', (select id from employees where firstname = 'amine' and lastname = 'ladjimi'));