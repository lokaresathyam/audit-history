FROM openjdk:8-jre
ENV PORT=8082
COPY target/audit-history-consumer-1.0.0.jar audit-history-consumer.jar
COPY src/main/resources/application.properties application.properties
RUN apt-get update
RUN apt-get install -y netcat
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]