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