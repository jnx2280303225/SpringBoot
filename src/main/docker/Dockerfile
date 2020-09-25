FROM java:8
EXPOSE 12468
VOLUME /app
ADD springboot.jar app.jar
RUN sh -c 'touch /springboot.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /springboot.jar" ]