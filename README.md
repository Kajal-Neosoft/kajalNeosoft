--------------------------------------SQL INTERVIEW QUESTIONS---------------------------------------------------------------------------------

join in sql , types of join in sql

CREATE TABLE Student (      
  id int PRIMARY KEY IDENTITY,     
  admission_no varchar(45) NOT NULL,  
  first_name varchar(45) NOT NULL,      
  last_name varchar(45) NOT NULL,  
  age int,  
  city varchar(25) NOT NULL      
);  


CREATE TABLE Fee (   
  admission_no varchar(45) NOT NULL,  
  course varchar(45) NOT NULL,      
  amount_paid int,    
);  


INSERT INTO Student (admission_no, first_name, last_name, age, city)       
VALUES (3354,'Luisa', 'Evans', 13, 'Texas'),       
(2135, 'Paul', 'Ward', 15, 'Alaska'),       
(4321, 'Peter', 'Bennett', 14, 'California'),    
(4213,'Carlos', 'Patterson', 17, 'New York'),       
(5112, 'Rose', 'Huges', 16, 'Florida'),  
(6113, 'Marielia', 'Simmons', 15, 'Arizona'),    
(7555,'Antonio', 'Butler', 14, 'New York'),       
(8345, 'Diego', 'Cox', 13, 'California');  

INSERT INTO Fee (admission_no, course, amount_paid)       
VALUES (3354,'Java', 20000),       
(7555, 'Android', 22000),       
(4321, 'Python', 18000),    
(8345,'SQL', 15000),       
(5112, 'Machine Learning', 30000);  

1) INNER JOIN - we will get matched data from both the table based on conditions.

select student.admission_no, student.first_name,
student.last_name,fee.course,fee.amount_paid 
from student inner join fee 
on student.admission_no = fee.admission_no;

2) OUTER JOIN 
	1) LEFT JOIN
	select student.admission_no, 
	student.first_name,student.last_name,
	fee.course,fee.amount_paid 
	from student left join fee 
	on student.admission_no = fee.admission_no;
	
	2) RIGHT JOIN
	select student.admission_no, 
	student.first_name,student.last_name,
	fee.course,fee.amount_paid 
	from student right join fee 
	on student.admission_no = fee.admission_no;
	
	3) FULL JOIN
	select student.admission_no, 
	student.first_name,student.last_name,
	fee.course,fee.amount_paid 
	from student full join fee 
	on student.admission_no = fee.admission_no;
	
3) self join - self join means ek hi table khud se join hota hai , but isko acheive karne ke liye we can join by using inner join or left join.
   for example suppose if we have study table and in study table columns are (s_id,c_id,since_year) here s_id and c_id is foreign key which is taken from
   student and course table. now we want to find the student who have enrolled atleast in two courses. for that humlog alias use karke ek hi table ko use 
   kar sakte hai jaise ki example are given below.
   
   select t1.s_id from study as t1, study as t2 where t1.s_id = t2.s_id and t1.c_id <> t2.c_id.
   it means jaha pr s_id same hona chhaiye par course id is not equal to.
   
   here by consider above table student and fee. i want to find the course in atleast two student has enrolled .
   select t1.id from student as t1, student as t2 where t1.admission_no = t2.admission_no and t1.id <> t2.id; //output will be id 3,4
   
4) cross join - cross join means product of two table. if you want display the all records from both table then go with cross join. for example if
   you have a student which has 5 rows and fees table which has 3 row of records then the result will be 5*3=15 record will be display in the final 
   cross join result.
   
   syntax- select column_name from table name1 cross join table name2;
   
   example - select student.id,student.first_name,fee.course,fee.amount_paid from student cross join fee;
   
   
   
 ------group by and having clause-------------
 
 group by - the group by clause is used in conjuction with select statement and aggregate functions to group rows together by common column values;
			aggregate functions are(count , min ,max, sum etc) when we use group by use aggregate functions complusory. 
			jab bhi hum group by karenge it is not compulsory to use two column together because we are not performing join here we can simple use one
			single table.
			
			syntax -  select column from table_name where condition group by column_name(s); (where is optional here)(if you want to use order by then 
					  use after group by.
		    
			if you two show the result from two table and you want to use gropu by then the syntax will be
			syntax - select columns from table1 inner join table2 on table1.column_name = table2.column_name where condition group by column_name(s);
			
			select last_name, age ,admission_no, count(admission_no) from student group by admission_no;
			select first_name, age ,admission_no, count(admission_no) as total from student group by admission_no;
			
			when we want column data from two table
			select student.first_name, student.age ,student.admission_no, count(student.admission_no) as total ,fee.course from student inner join
			fee on student.admission_no = fee.admission_no group by admission_no;
			
			select student.first_name, student.age ,student.admission_no, count(student.admission_no) as total ,fee.course from student inner join 
			fee on student.admission_no = fee.admission_no where age > 13 group by admission_no;
			
			select student.first_name, student.age , count(student.admission_no) as total ,fee.course from student inner join fee 
			on student.admission_no = fee.admission_no where age > 13 group by student.admission_no order by count(student.admission_no);
			
			
			real project understanding.
			
Having cluase - mostly use with group by ye jo bhi group by clause ki help se result milega and count jo bhi rahega suppoe if u want apply some condition
				over there then go with having clause like having total student > 5.
				
				syntax - select columns from table_name group by column name(s) having condition;
				(if u are using where then use it before group by and use having after group by )
				
				select student.first_name, student.age , count(student.admission_no) as total ,fee.course from student inner join fee on student.admission_no = 
				fee.admission_no where age > 13 group by student.admission_no having count(student.admission_no) > 1 order by count(student.admission_no) desc;
	
-----------------------ACID PROPERTY---------------------------------------------

In order to maintain consistency in a database, before and after the transaction, certain properties are followed. These are called ACID properties.

Atomicity: By this, we mean that either the entire transaction takes place at once or doesn’t happen at all. There is no midway i.e. 
transactions do not occur partially. Each transaction is considered as one unit and either runs to completion or is not executed at all. 
It involves the following two operations. 
	—Abort: If a transaction aborts, changes made to the database are not visible. 
	—Commit: If a transaction commits, changes made are visible. 
	 Atomicity is also known as the ‘All or nothing rule’. (ya to pura transaction success ho ya to nhi)
	 
consistency - This means that integrity constraints must be maintained so that the database is consistent before and after the transaction. 
It refers to the correctness of a database.(after successfully transaction and logically corrected according to the database then we can say 
consistency maintain)

isolation : Isolation ensures that multiple transactions can execute concurrently without interfering with each other. 
Each transaction must be isolated from other transactions until it is completed.

Durability : Durability ensures that once a transaction is committed, its changes are permanent and will survive any subsequent system failures.
The transaction’s changes are saved to the database permanently, and even if the system crashes, the changes remain intact and can be recovered. 
(it means ager hmara transaction successfully commits then vo database me permanently save hona chahiye chahe kuch bhi ho system or hardware failure 
ager ata hai to bhi mujhe chnages dikhne chahiye naki kuch reflect ho, data lost nhi hon chahiye )


-----------------Transaction state---------------------
1) active ----> partially committed -----> committed ----> terminatted
   ram            ram                      hd(hard disk)  resouces close


   in case of fail transaction before commited
2) active ----> failed ----> abort -----> terminatted

   ram       (suppose partially commited ke baad fail ho gya) ---> kill or restart the process ----> resouces rollback
   
   
-----------------------Normalization-------------------------------------

normalization is the process of organizing the data in the database. it is performed to reduce the data redundency in a database.data redundency means
having the same data at multiple place.  it is compulsory to remove data redundency because it causes anomalies mean error and it very hard for
database administrator to maintain it.

1) 1NF - a relation will be in 1NF if it contains atomic value (means single value), it disallows the multi valued attribute 
(a column can not have multiple value) inshort 1 row me multiple data nhi de sakte. for example kajal is having two mobile number then u can not define it
in a single row . enter kajal in second row again with second mobile number.


example - before normalization

create table unnormalized_employee(id int primary key, name varchar(20), course varchar(20));
insert into unnormalized_employee(id,name,course) values(1,'kajal','IT,CSS'),(2,'Riddhi','IT,ECE'),(3,'Anchal','MECH/EXE');

after normalization
create table normalized_employeewith1NF(id int , name varchar(20), course varchar(20));
insert into normalized_employeewith1NF(id,name,course) values(1,'kajal','IT'),(1,'kajal','CSS'),(2,'Riddhi','IT'),(2,'Riddhi','ECE'),(3,'Anchal','MECH'),(3,'Anchal','EXE');
select * from normalized_employeewith1NF;



2) 2NF - the table must be in 1NF and not contain any partial dependency (in short fully dependent on primarky key (the values should be unique))

example same as above - 1NF is already created;

create table normalized_employewith2NF(id int primary key, name varchar(30)); // no partilly depenedeny
insert into normalized_employewith2NF(id,name) values(1,'kajal'),(2,'Riddhi'),(3,'Anchal');
select * from normalized_employewith2NF;


3) 3NF - A table will be in 3NF  if it is in 2NF and if there is no transitive dependency for non prime attributes then the table is in 3NF.
   example suppose we have a student table - (name , rollnumber(primary key), branch , fee) here in this table fees is dependent on branch where both are
   non primary key attribute(both are candidate key which is dependent to each other it means here is transitive depenedeny) so to make a table in 3NF 
   remove the transitive dependecy first for that we will create two table like first one is (name, rollmumber, branch) and second table is (branch, fee).
   
    create table unormalized_employee3NF(roll_no int primary key,name varchar(20), branch varchar(20),fees long);
	insert into unormalized_employee3NF(roll_no,name,branch,fees) values(21,'kajal','cse',20000),(22,'Ridhhi','AIML',30000),(23,'Anchal','DS',40000),(24,'anugya','ece',50000);
	select * from unormalized_employee3NF;
	create table ormalized_employee3NF(roll_no int primary key,name varchar(20), branch varchar(20));
	insert into ormalized_employee3NF(roll_no,name,branch) values(21,'kajal','cse'),(22,'Ridhhi','AIML'),(23,'Anchal','DS'),(24,'anugya','ece');
	rename table ormalized_employee3NF to normalized_employee3NF;
	select * from normalized_employee3NF;
	create table normalized_employeewith3NFtran_depe( branch varchar(20),fees long);
	insert into normalized_employeewith3NFtran_depe(branch,fees) values('cse',20000),('AIML',30000),('DS',40000),('ece',50000);
	select * from normalized_employeewith3NFtran_depe;
	   
	create table unormalized_employee3NF(roll_no int primary key,name varchar(20), branch varchar(20),fees long);
	insert into unormalized_employee3NF(roll_no,name,branch,fees) values(21,'kajal','cse',20000),(22,'Ridhhi','AIML',30000),(23,'Anchal','DS',40000),(24,'anugya','ece',50000);
	select * from unormalized_employee3NF;
	   
   
   
----------------------------Stored Procedures-------------------------------
So if you have an SQL query that you write over and over again, save it as a stored procedure, and then just call it to execute it.

DELIMITER - iska jo default value rehta hai ; to hum jab procedure use karte hai to multiple time ; use karte hai to hum sql ko bolte jabtk tujhe delimeter ka
humne jo synatx diya hota hai na dikhe tabtak execute mat krna.

1) without parameter
syntax - DELIMITER //
		 CREATE PROCEDURE GetAllStudent()
		 BEGIN
			SELECT * FROM student;
		 END //
		 DELIMITER ;


syntax - to execute stored procedure - call GetAllStudent();

2) With In parameter - In this procedure, we have used the IN parameter as 'var1' of integer type to accept a number from users. 
					  Its body part fetches the records from the table using a SELECT statement and returns only those rows that will be supplied by the user.
syntax - DELIMITER && 
		 create procedure getStudentByLimit(IN var1 int)
		 begin
			 select * from student limit var1;
		 end &&
		 DELIMITER ;

syntax - call getStudentByLimit(5);					  

3) Procedures with OUT Parameter - In this procedure, we have used the OUT parameter as the 'mark' of integer type. Its body part fetches the 
								   maximum marks from the table using a MAX() function.
								
syntax- DELIMITER &&
		CREATE PROCEDURE DisplayMaxMarks(OUT marks int)
		BEGIN
			select max(admission_no) into marks from student;
		END &&
		DELIMITER ;
syntax - call DisplayMaxMarks(@M);
syntax - select @M;

4) PROCEDURE with INOUT parameters - In this procedure, we have used the INOUT parameter as 'var1' of integer type. Its body part first fetches 
									 the marks from the table with the specified id and then stores it into the same variable var1. The var1 first acts 
									 as the IN parameter and then OUT parameter. Therefore, we can call it the INOUT parameter mode.
									
syntax - DELIMITER &&  
		 CREATE PROCEDURE display_marks (INOUT var1 INT)  
		 BEGIN  
			SELECT admission_no INTO var1 FROM student WHERE id = var1;   
		 END &&  
		 DELIMITER ;
		
syntax - SET @result = 6; 

		 call display_marks (@result) ;

		 select @result;
									 
	
----------------------function in sql --------------------------
it is a set of sql statement that perform some task or operation and return some values.	

syntax -    CREATE FUNCTION function_name [ (parameter datatype [, parameter datatype]) ]   
			RETURNS return_datatype  
			BEGIN  
			Declaration_section  
			Executable_section  
			END;  

stored procedure vs function -
1)the function must return a value but in stored procedure it is optional even a procedure can return null values or zero value.
2)function can have only input parameter for it where as procedure can have input or output parameters.
3)function can be call from procedure where as procedure can not be called from function;
   
what is view in sql
	1) view for single table
	create view studentview as select 
	first_name,last_name from student
	where admission_no > 5000;

	2) view for multiple table
	create view studentfeeview as select 
	student.admission_no,student.first_name,
	fee.course,fee.amount_paid from student,
	fee where student.admission_no = fee.admission_no;
	
	3) drop view studentview;
	
what is index in sql
-The Index in SQL is a special table used to speed up the searching of the data in the database tables. 
It also retrieves a vast amount of data from the tables frequently. The INDEX requires its own space in the hard disk.

-In SQL, an Index is created on the fields of the tables. We can easily build one or more indexes on a table. 
The creation and deletion of the Index do not affect the data of the database.

1) on single column of a table
CREATE INDEX Index_Name ON Table_Name ( Column_Name);

create index index_firstname on student(admission_no);
if u want to searching
select * from student where first_name='peter';

2) on multiple column of a index
CREATE INDEX Index_Name ON Table_Name ( column_name1, column_name2, ...., column_nameN); 
select first_name , last_name from student where first_name='peter' and last_name='bennett';

to drop the index in mysql
ALTER TABLE student DROP INDEX index_firstname_lastname;



CREATE TABLE User (id int primary key, name varchar(100) , registrationDate date); 
-> create table user(id int primary key auto_increment,name varchar(100),registrationDate date);

CREATE TABLE Address (id int primary key, user_id int, city varchar(100), state varchar(100), zipcode bigint);
-> create table address(id int primary key auto_increment,user_id int, city varchar(100), state varchar(100),zipcode bigint);
   alter table address ADD CONSTRAINT foreign key(user_id) references user(id);
   
CREATE TABLE Account (id int primary key, user_id int, account_type int, account_balance int);
-> create table account(id int primary key auto_increment, user_id int,foreign key(user_id) references user(id),account_type int, account_balance int);

write a query for retive all user data from user for recently 10 register user belonging to delhi.
-> select user.id,user.name,user.registrationDate,address.city from user left join address 
   on user.id = address.user_id where address.city='delhi' 
   order by user.registrationDate desc limit 1;
   

Do you have idea about query optimization and how .
-> use limit, use index, avoid select * ,use proper join , avoid subquesry, normalize your database, partitioning.

1. About career and role
2. Students
------------
sid - PK
sname - name of the student

Subjects
-----------
subid - PK
subname - name of the subject

Marks
--------
mid - PK
sid - FK to Students
subid - FK to Subjects. 
marks - marks obtained in the subject. 

Find out names of students who have obtained more than 50 marks in Maths.
Using JOIN syntax.
->
	SELECT s.sname
	FROM students s
	JOIN marks m ON s.sid = m.sid
	JOIN subjects sub ON m.subid = sub.subid
	WHERE m.marks > 50 AND sub.subname = 'Math';
	
	
write query to join 3 tables
cars - id (PK) and name 
parts - pid(PK) , pname and cars_id(FK)
productparts - ppid(PK), pname and parts_id(FK)

find the no of parts where car is swift and product is sumsung.


-> 
	SELECT COUNT(pp.ppid) AS no_of_parts
	FROM cars c
	JOIN parts p ON c.id = p.cars_id
	JOIN productparts pp ON p.pid = pp.parts_id
	WHERE c.name = 'Swift' AND pp.pname LIKE '%Samsung%';
	
