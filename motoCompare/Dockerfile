#
# Build stage
#
#FROM maven:3.6.0-jdk-8-slim AS build
#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:16

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/semnomeainda
COPY /target/semnomeainda-*.jar spring-app.jar
#ENTRYPOINT ["java", "-jar", "spring-app.jar"]

SHELL ["/bin/sh", "-c"]
#COPY --from=build /home/app/target/semnomeainda-0.0.1-SNAPSHOT.jar /usr/local/lib/semnomeainad.jar
#ENTRYPOINT ["java","-jar","/usr/local/lib/semnomeainad.jar"]
EXPOSE 8080
EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar spring-app.jar --spring.profile.active=${PROFILE}