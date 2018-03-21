1.建立调用关系
APIService --> restaurantservice.findById -->userservice.findById


2.启动Eureka、Api、Restaurant、User、zipkin


调用：
http://localhost:8092/restaurants/1  

查看跟踪：
http://localhost:9998/