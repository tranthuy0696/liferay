create table Cpu (
	cpuId bigint not null primary key,
	time_ date null,
	value double
);

create table Heap (
	heapId bigint not null primary key,
	time_ date null,
	value double
);

create table Network (
	networkId bigint not null primary key,
	time_ date null,
	down double,
	up double
);

create table NonHeap (
	nonHeapId bigint not null primary key,
	time_ date null,
	value double
);

create table Ram (
	ramId bigint not null primary key,
	time_ date null,
	value double
);


create table SessionRequest (
	sessionRequestId bigint not null primary key,
	sessionId varchar(75) null,
	time_ date null,
	ip varchar(75) null,
	browser varchar(75) null,
	os varchar(75) null,
	login boolean
);
