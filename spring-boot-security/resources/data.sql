

/*
CREATE TABLE SYS_USER(
  id int(11) AUTO_INCREMENT,
  username varchar(255),
  password varchar(255),
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE SYS_ROLE(
  id int(11) AUTO_INCREMENT,
  name varchar(255),
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE SYS_USER_ROLES(
  SYS_USER_ID int(11),
  ROLES_ID int(11),
  PRIMARY KEY (SYS_USER_ID,ROLES_ID),
  foreign key(SYS_USER_ID) references SYS_USER(id),    
  foreign key(ROLES_ID) references SYS_ROLE(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

insert into SYS_USER(id,username,password) values(1,'deepsky','123');
insert into SYS_USER(id,username,password) values(2,'zhaoxj','123');

insert into SYS_ROLE(id,name) values(1,'ROLE_ADMIN');
insert into SYS_ROLE(id,name) values(2,'ROLE_USER');

insert into SYS_USER_ROLES(SYS_USER_ID,ROLES_ID) values(1,1);
insert into SYS_USER_ROLES(SYS_USER_ID,ROLES_ID) values(2,2);

*/
