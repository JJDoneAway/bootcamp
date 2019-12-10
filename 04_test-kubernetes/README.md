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
    3. http://localhost:8080
    4. kill `ctrl`+ `c`
5. build docker container 
    * general format `docker build --tag {your user}\test-kubernetes:first-test`
    * mine `docker build --tag hoehne/test-kubernetes:first-test .`
6. run docker image locally
    1. genral format `docker run --rm -p 9090:8080 --name first-test {your user}\test-kubernetes:first-test`
    2. or  mine `docker run -d --rm -p 9090:8080 --name first-test hoehne/test-kubernetes:first-test`
    3. [http://localhost:9090]
    4. docker kill first-test
7. push docker image to global repository
     1. create on docker hub a public repository with the name `test-kubernetes` 
     2 push your image to it 
          * general `docker push hoehne/test-kubernetes:first-test`
          * mine: `docker push hoehne/test-kubernetes:first-test`
8. test global image
      1. list local images `docker image ls` ==> find your image and copy image id
      2. delete image `docker image rm {imgae id}`
      3. check if image is really deleted `docker image ls`
      4. run image which must be downloaden from the repository
            1. genral format `docker run --rm -p 9090:8080 --name first-test {your user}\test-kubernetes:first-test`
            2. or  mine `docker run -d --rm -p 9090:8080 --name first-test hoehne/test-kubernetes:first-test`
      5. http://localhost:9090
      6. http://localhost:9090/kill
9. deploy to kubernetes 
      1. `kubectl apply -f k8s-deployment.yml`
      2. `kubectl get deployments -A`
      3. `kubectl describe deployments -n default`
      4. `kubectl get services`
      5. http://localhost:30000
10. deploy and exec playground / inspector kube
      1. `kubectl apply -f inspector.yml`
      2. `kubectl get pods`
      3. `kubectl exec -it inspector-{id of the pod} -- /bin/bash`
      4. `curl test-kubernetes-service:8080`
      5. `exit`
      6. `kubectl delete deployment inspector`

        


	
