USE qcdb;

alter table qcdb.orders
    modify id bigint auto_increment;

alter table qcdb.orders
    auto_increment = 1;

alter table qcdb.orders
    modify orders_id varchar(255) not null;

alter table qcdb.orders
    modify goods_id varchar(255) not null;

alter table qcdb.orders
    modify user_id bigint not null;

alter table qcdb.orders
    modify vendor_id bigint not null;

alter table qcdb.orders
    modify delivery_id bigint not null;