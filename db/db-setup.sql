DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  price float NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45),
  last_name varchar(45),
  user_id varchar(45) NOT NULL,
  age int(4),
  salary float,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

insert into `product`(name,price) values('Laptop',34000);

insert into `t_users`(first_name,last_name,user_id,age,salary) values('Sayyed','Noman','snoman',39,40000);