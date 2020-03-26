FROM adoptopenjdk/openjdk8-openj9:latest

ENV JAVA_OPTS="-server -Xmx2G -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:+UseG1GC -XX:+OptimizeStringConcat -XX:+HeapDumpOnOutOfMemoryError -XX:+UseStringDeduplication -XX:+CMSParallelRemarkEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"
ADD /target/*.jar /app.jar

RUN sh -c 'touch /app.jar'
VOLUME /tmp

USER root

ADD target/classes/sebrae.crt /etc/ssl/certs/

RUN keytool -import -keystore $JAVA_HOME/jre/lib/security/cacerts -storepass changeit -noprompt -file /etc/ssl/certs/sebrae.crt -alias 'certificado-sebrae'

EXPOSE 8080
CMD echo "The application will start..." && \
    java $JAVA_OPTS -Djavax.net.ssl.trustStore=$JAVA_HOME/jre/lib/security/cacerts -Djava.security.egd=file:/dev/./urandom -jar /app.jar
