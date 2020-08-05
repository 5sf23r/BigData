create table exam(
	id int primary key auto_increment,
	name varchar(20) not null,
	chinese double,
	math double,
	english double
);

insert into exam values(null,'关羽',85,76,70);
insert into exam values(null,'张飞',70,75,70);
insert into exam values(null,'赵云',90,65,95);
-----------------------------------------------------------------------------
create table orders(
			id int,
			product varchar(20),
			price float
		);

		insert into orders(id,product,price) values(1,'电视',900);
		insert into orders(id,product,price) values(2,'洗衣机',100);
		insert into orders(id,product,price) values(3,'洗衣粉',90);
		insert into orders(id,product,price) values(4,'桔子',9);
		insert into orders(id,product,price) values(5,'洗衣粉',90);

-----------------------------------------------------------------------------
create table dept(
id int primary key auto_increment,
name varchar(20)
);
insert into dept values (null,'财务部'),(null,'人事部'),(null,'科技部'),(null,'销售部');


create table emp(
id int primary key auto_increment,
name varchar(20),
dept_id int
);
insert into emp values (null,'张飞',1),(null,'关羽',2),(null,'刘备',3),(null,'赵云',4);
		