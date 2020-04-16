drop table if exists employeeSkill;
drop table if exists skill;
Drop table if exists employee;
drop table if exists address;



Drop type if exists role;
drop type if exists businessUnit;
Create Type role AS ENUM ('Technical Consultant', 'Project Manager', 'Director', 'Chief');
Create type businessUnit AS ENUM ('Digital Experience Group', 'Adobe', 'IBM NBU', 'API Management');


create table employee (
employeeId varchar (100) UNIQUE NOT NULL,
firstName varchar (15),
lastName varchar (20),
addressId varchar (100),
contactEmail varchar (255),
companyEmail varchar (255),
birthDate varchar (11),
hireDate varchar (11),
role role,
businessUnit businessUnit,
assignedTo varchar (255),
CONSTRAINT pk_employee_employeeId PRIMARY KEY (employeeId)
);

create table address (
addressId varchar (60) UNIQUE NOT NULL PRIMARY KEY,
street varchar (30)NOT NULL,
suite varchar (30),
city varchar (30) NOT NULL,
region varchar (3) NOT NULL,
postal varchar (6) NOT NULL,
country varchar (2) NOT NULL
);

create table skill (
skillId varchar (60) UNIQUE NOT NULL PRIMARY KEY,
name varchar (30) NOT NULL,
type varchar (30)
);

create table employeeSkill (
employeeId varchar (60) NOT NULL,
skillId varchar (60) NOT NULL,
experience integer DEFAULT 0 CHECK (experience >= 0),
summary varchar (30),
CONSTRAINT pk_employeeSkill_employeeId_skillId PRIMARY KEY (employeeId, skillId)
);


ALTER TABLE employeeSkill ADD FOREIGN KEY (employeeId) REFERENCES employee(employeeId);
ALTER TABLE employeeSkill ADD FOREIGN KEY (skillId) REFERENCES skill(skillId);


INSERT INTO employee (employeeId, firstName, lastName, addressId, contactEmail, companyEmail, birthdate, hireDate, role, businessUnit, assignedTo) VALUES ('qiwhd8qydqwdqjdbuo', 'Bill', 'Test', '92ej12eu1endwqw81', 'contactEmail@geemale.com', 'bTest@perficient.com', '11/11/1911','12/12/2012', 'Director', 'Adobe', 'Testy McGee');
INSERT INTO employee (employeeId, firstName, lastName, addressId, contactEmail, companyEmail, birthdate, hireDate, role, businessUnit, assignedTo) VALUES ('eufewfyuehf', 'Will', 'Tester', '92eflkadjfoiaj', 'contactEmail@geemale.com', 'WTester@perficient.com', '11/11/1912','1/1/2012', 'Director', 'Adobe', 'Testy McGee');
