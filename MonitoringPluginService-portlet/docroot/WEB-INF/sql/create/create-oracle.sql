drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table Cpu (
	cpuId number(30,0) not null primary key,
	time_ timestamp null,
	value number(30,20)
);

create table Heap (
	heapId number(30,0) not null primary key,
	time_ timestamp null,
	value number(30,20)
);

create table Network (
	networkId number(30,0) not null primary key,
	time_ timestamp null,
	down number(30,20),
	up number(30,20)
);

create table NonHeap (
	nonHeapId number(30,0) not null primary key,
	time_ timestamp null,
	value number(30,20)
);

create table Ram (
	ramId number(30,0) not null primary key,
	time_ timestamp null,
	value number(30,20)
);


create table SessionRequest (
	sessionRequestId number(30,0) not null primary key,
	sessionId VARCHAR2(75 CHAR) null,
	time_ timestamp null,
	ip VARCHAR2(75 CHAR) null,
	browser VARCHAR2(75 CHAR) null,
	os VARCHAR2(75 CHAR) null,
	login number(1, 0)
);


create index IX_5A3FC89E on Ram (time_);



quit