USE qcdb;

alter table qcdb.orders
    modify id bigint auto_increment;

alter table qcdb.orders
    auto_increment = 1;