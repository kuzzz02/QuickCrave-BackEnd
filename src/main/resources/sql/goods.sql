-- Active: 1677071639187@@127.0.0.1@3306@qcdb
USE qcdb;

alter table qcdb.goods
    modify id bigint auto_increment;

alter table qcdb.goods
    auto_increment = 1;

alter table qcdb.goods
    modify name varchar(255) not null;

alter table qcdb.goods
    modify price varchar(255) not null;

alter table qcdb.goods
    modify number varchar(255) not null;

alter table qcdb.goods
    modify vendor_id bigint not null;


INSERT INTO goods (`id`,`description`,`discount`,`image`,`name`,`price`,`number`,`vendor_id`) VALUES
(1,'200 gr chicken + cheese  Lettuce + tomato','0','goods1.png','chicken burger','22','1421',2),
(2,'200 gr meat + Lettuce cheese + onion + tomato','0','goods2.png','cheese burger','25','1231',2),
(3,'350 gr chicken + cheese  Lettuce + tomato','15%','goods3.png','Big chicken burger','38','970',2),
(4,'350 gr meat + Lettuce cheese + onion + tomato','33%','goods4.png','Big cheese burger','45','450',2);
