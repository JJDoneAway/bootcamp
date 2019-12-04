# Play around with kubernetes

## My Blog
https://www.mt-ag.com/ein-hallo-welt-mit-minikube-und-windows-ein-missglucktes-experiment-2-2/

## Preconditions
* account on [hub.docker.com]
* have Docker installed
* be logged in `docker login`

## build project
1. try if it is working 
      1. `mvn spring-boot:run`
      2. open [http://localhost:8080]
      2. try shutdown http://localhost:8080/kill
3. create jar `mvn clean install`
4. test jar 
    1. cd target
    2. java -jar app.jar
    3. [http://localhost:8080]
    4. kill `ctrl`+ `c`
5. build docker container 
    * general format `docker build --tag {your user}\{your repo}:{your tag}`
    * mine `docker build --tag hoehne/test-kubernetes:first-test .`
6. run docker image locally
    1. genral format `docker run --rm -p 9090:8080 --name first-test {your user}\{your repo}:{your tag}`
    2. or  mine `docker run -d --rm -p 9090:8080 --name first-test hoehne/test-kubernetes:first-test`
    3. [http://localhost:9090]
    4. docker kill first-test

	
