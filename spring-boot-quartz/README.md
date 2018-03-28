Spring Boot集成quart，从数据库读取定时配置，动态执行任务

1.配置ddl：
create table config(  
    id int(5) auto_increment primary key not null, 
    cron varchar(40)
);
2.执行SQL：
insert into config(id,cron) values(1,'0/10 * * * * ?');