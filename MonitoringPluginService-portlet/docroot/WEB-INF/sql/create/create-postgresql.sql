drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;

create table Cpu (
	cpuId bigint not null primary key,
	time_ timestamp null,
	value double precision
);

create table Heap (
	heapId bigint not null primary key,
	time_ timestamp null,
	value double precision
);

create table Network (
	networkId bigint not null primary key,
	time_ timestamp null,
	down double precision,
	up double precision
);

create table NonHeap (
	nonHeapId bigint not null primary key,
	time_ timestamp null,
	value double precision
);

create table Ram (
	ramId bigint not null primary key,
	time_ timestamp null,
	value double precision
);


create table SessionRequest (
	sessionRequestId bigint not null primary key,
	sessionId varchar(75) null,
	time_ timestamp null,
	ip varchar(75) null,
	browser varchar(75) null,
	os varchar(75) null,
	login bool
);


create index IX_5A3FC89E on Ram (time_);


