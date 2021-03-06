drop database lportal;
create database lportal;

go

use lportal;

create table Cpu (
	cpuId bigint not null primary key,
	time_ datetime null,
	value float
);

create table Heap (
	heapId bigint not null primary key,
	time_ datetime null,
	value float
);

create table NonHeap (
	nonHeapId bigint not null primary key,
	time_ datetime null,
	value float
);

create table Ram (
	ramId bigint not null primary key,
	time_ datetime null,
	value float
);

create table SessionRequest (
	sessionRequestId bigint not null primary key,
	sessionId nvarchar(75) null,
	time_ datetime null,
	ip nvarchar(75) null,
	browser nvarchar(75) null,
	os nvarchar(75) null,
	login bit
);


create index IX_5A3FC89E on Ram (time_);


