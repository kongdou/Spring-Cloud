Spring Data Rest 
===
	Spring Data JPA是基于Spring Data 的Repository之上，可以将Repository自动输出为REST资源。
	目前Spring Data REST支持将Spring Data JPA、Spring Data MongoDB、Spring Data Neo4j、Spring Data Gemfire以及Spring Data Cassandra的Repository自动转换成REST服务。
	
	根据主键访问：
	http://localhost:8080/api/person/1
	根据姓名访问：
	http://localhost:8080/api/person/search/nameStartsWith?name=xxx
	
	