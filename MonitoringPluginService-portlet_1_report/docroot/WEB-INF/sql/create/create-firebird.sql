create database 'lportal.gdb' page_size 8192 user 'sysdba' password 'masterkey';
connect 'lportal.gdb' user 'sysdba' password 'masterkey';
create table Cpu (cpuId int64 not null primary key,time_ timestamp,value double precision);
create table Heap (heapId int64 not null primary key,time_ timestamp,value double precision);
create table NonHeap (nonHeapId int64 not null primary key,time_ timestamp,value double precision);
create table Ram (ramId int64 not null primary key,time_ timestamp,value double precision);
create table SessionRequest (sessionRequestId int64 not null primary key,sessionId varchar(75),time_ timestamp,ip varchar(75),browser varchar(75),os varchar(75),login smallint);
