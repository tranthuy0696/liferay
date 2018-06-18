drop database lportal;
create database lportal;
connect to lportal;
create table Cpu (
	cpuId bigint not null primary key,
	time_ timestamp,
	value double
);

create table Heap (
	heapId bigint not null primary key,
	time_ timestamp,
	value double
);

create table NonHeap (
	nonHeapId bigint not null primary key,
	time_ timestamp,
	value double
);

create table Ram (
	ramId bigint not null primary key,
	time_ timestamp,
	value double
);

create table SessionRequest (
	sessionRequestId bigint not null primary key,
	sessionId varchar(75),
	time_ timestamp,
	ip varchar(75),
	browser varchar(75),
	os varchar(75),
	login smallint
);


create index IX_5A3FC89E on Ram (time_);


