USE qcdb;

alter table qcdb.user
    modify id bigint auto_increment;

alter table qcdb.user
    auto_increment = 1;

alter table qcdb.user
    modify name varchar(255) not null;

alter table qcdb.user
    modify password varchar(255) not null;