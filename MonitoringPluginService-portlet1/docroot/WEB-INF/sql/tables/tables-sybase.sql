create table Cpu (
	cpuId decimal(20,0) not null primary key,
	time_ datetime null,
	value float
)
go

create table Heap (
	heapId decimal(20,0) not null primary key,
	time_ datetime null,
	value float
)
go

create table NonHeap (
	nonHeapId decimal(20,0) not null primary key,
	time_ datetime null,
	value float
)
go

create table Ram (
	ramId decimal(20,0) not null primary key,
	time_ datetime null,
	value float
)
go

create table SessionRequest (
	sessionRequestId decimal(20,0) not null primary key,
	sessionId varchar(75) null,
	time_ datetime null,
	ip varchar(75) null,
	browser varchar(75) null,
	os varchar(75) null,
	login int
)
go
