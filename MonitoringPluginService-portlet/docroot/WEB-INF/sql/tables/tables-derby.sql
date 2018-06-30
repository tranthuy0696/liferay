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

create table Network (
	networkId bigint not null primary key,
	time_ timestamp,
	down double,
	up double
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
