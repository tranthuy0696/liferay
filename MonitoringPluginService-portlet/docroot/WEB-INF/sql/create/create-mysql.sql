drop database if exists lportal;
create database lportal character set utf8;
use lportal;

create table Cpu (
	cpuId bigint not null primary key,
	time_ datetime null,
	value double
) engine InnoDB;

create table Heap (
	heapId bigint not null primary key,
	time_ datetime null,
	value double
) engine InnoDB;

create table Network (
	networkId bigint not null primary key,
	time_ datetime null,
	down double,
	up double
) engine InnoDB;

create table NonHeap (
	nonHeapId bigint not null primary key,
	time_ datetime null,
	value double
) engine InnoDB;

create table Ram (
	ramId bigint not null primary key,
	time_ datetime null,
	value double
) engine InnoDB;


create table SessionRequest (
	sessionRequestId bigint not null primary key,
	sessionId varchar(75) null,
	time_ datetime null,
	ip varchar(75) null,
	browser varchar(75) null,
	os varchar(75) null,
	login tinyint
) engine InnoDB;


create index IX_5A3FC89E on Ram (time_);


