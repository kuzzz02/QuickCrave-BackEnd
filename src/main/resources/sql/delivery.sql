USE qcdb;

alter table qcdb.delivery
    modify id bigint auto_increment;

alter table qcdb.delivery
    auto_increment = 1;

alter table qcdb.delivery
    modify name varchar(255) not null;

alter table qcdb.delivery
    modify password varchar(255) not null;