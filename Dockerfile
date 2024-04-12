FROM openjdk:21
ADD target/mongodb-shop.jar mongodb-shop.jar
ENTRYPOINT ["java","--enable-preview","-jar","/mongodb-shop.jar"]