FROM anapsix/alpine-java:8
COPY target/app.jar /application/app.jar
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /application/app.jar