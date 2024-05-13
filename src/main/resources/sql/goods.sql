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


INSERT INTO goods (`id`,`date`,`description`,`discount`,`image`,`name`,`price`,`quantity`,`state`,`vendor_id`) VALUES
(1,'2024/5/1','200 gr chicken + cheese  Lettuce + tomato','0','goods1.png','chicken burger','22','4.8','in stock',2),
(2,'2024/5/1','200 gr meat + Lettuce cheese + onion + tomato','0','goods2.png','cheese burger','25','4.9','in stock',2),
(3,'2024/5/1','350 gr chicken + cheese  Lettuce + tomato','15%','goods3.png','Big chicken burger','38','5','sold out',2),
(4,'2024/5/1','350 gr meat + Lettuce cheese + onion + tomato','33%','goods4.png','Big cheese burger','45','5','sold out',2);
