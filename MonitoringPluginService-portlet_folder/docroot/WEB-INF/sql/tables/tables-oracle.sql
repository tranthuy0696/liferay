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
