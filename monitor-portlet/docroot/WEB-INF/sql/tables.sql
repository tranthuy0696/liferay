create table Cpu (
	cpuId LONG not null primary key,
	time_ DATE null,
	min DOUBLE,
	max DOUBLE,
	aver DOUBLE
);

create table Ram (
	ramId LONG not null primary key,
	time_ DATE null,
	min DOUBLE,
	max DOUBLE,
	aver DOUBLE
);

create table monitoring (
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);