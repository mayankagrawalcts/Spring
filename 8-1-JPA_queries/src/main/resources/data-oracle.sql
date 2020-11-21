insert into user_table(id, firstname, lastname, age,email_address)
values(10001,'Mayank','agrawal' ,12,'m@g.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10002,'Ranga','agrawa' ,12,'am@g.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10003,'Adam','grawal' ,12,'maa@gmail.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10004,'Jane','agra' ,12,'maaaa@g.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10005,'name1','ag' ,12,'mkyong@gmail.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10006,'Sharmila','test1' ,12,'maaa@g.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10007,'Nikil','test2' ,12,'mrr@g.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10008,'Thiru','test3' ,12,'rm@g.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10009,'Supriya','test4' ,12,'rm@gmail.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10010,'sasi','test5' ,12,'ma@gmail.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10011,'Mahbub','test6' ,12,'may@gmail.com');
insert into user_table(id, firstname, lastname, age,email_address)
values(10012,'Rajni','test7' ,12,'mayank@gmail.com');
insert into user_table(id, firstname,  age,email_address)
values(10013,'lastname is null' ,12,'mayankag@gmail.com');
insert into user_table(id, firstname,  age,email_address)
values(10014,'lastname is null' ,14,'mayankagra@gmail.com');

insert into course(id, name, created_date, last_updated_date)
values(10001,'JPA in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)
values(10002,'Spring in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date)
values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate());


insert into passport(id,passport_number)
values(40001,'E123456');
insert into passport(id,passport_number)
values(40002,'N123457');
insert into passport(id,passport_number)
values(40003,'L123890');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);
