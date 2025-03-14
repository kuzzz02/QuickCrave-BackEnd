USE qcdb;

alter table qcdb.vendor
    modify id bigint auto_increment;

alter table qcdb.vendor
    auto_increment = 1;

alter table qcdb.vendor
    modify name varchar(255) not null;

alter table qcdb.vendor
    modify password varchar(255) not null;

alter table qcdb.vendor
    modify phone varchar(255) not null;

alter table qcdb.vendor
    modify address varchar(255) not null;

alter table qcdb.vendor
    alter column state set default "open";

INSERT INTO vendor (`id`,`address`,`date`,`description`,`email`,`image`,`name`,`password`,`phone`,`portrait`,`state`,fee,`quantity`,time,`category`) VALUES
(1,'scnu','2024/5/1','Cheap but Tasty','12161@xx.mail','KFC_detail.png','KFC','123456','18112','KFC.png','open',2,'4.9',40,'burger'),
(2,'scnu','2024/5/1','Always be your friend','12161@xx.mail','MC_detail.png','MC','123456','45161','MC.png','open',3,'4.5',35,'burger'),
(3,'scnu','2024/5/1','Best Ever Burger','12161@xx.mail','BK_detail.png','Burger King','123456','35611','BK.png','open',10,'4.7',55,'burger'),
(4,'scnu','2024/5/1','Pick what you want just Suit Yourself!','12161@xx.mail','SW_detail.png','Subway','123456','88864','SW.png','closed',5,'4.5',45,'sandwich'),
(5,'scnu','2024/5/1','Have a nice party!','12161@xx.mail','Do_detail.png','Domino','123456','10917','Do.png','open',7,'4.3',40,'pizza'),
(6,'scnu','2024/5/1','Pricy and Delectable','12161@xx.mail','DM_detail.png','Da Michele','123456','55050','DM.png','closed',20,'5',20,'pizza');
