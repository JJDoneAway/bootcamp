# Play around with kubernetes

## Preconditions
* account on [hub.docker.com]
* have Docker installed
* be logged in `docker login`

## build project
1. try if it is working `mvn spring-boot:run`and open [http://localhost:8080]
2. try shutdown [http://localhost:8080/kill]
3. create jar `mvn clean install`
4. test jar 
    1. cd target
    2. java -jar app.jar
    3. [http://localhost:8080]
    4. kill `ctrl`+ `c`
5. build docker container
