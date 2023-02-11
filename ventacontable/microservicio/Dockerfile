FROM openjdk:13-slim

ARG TZ='America/Bogota'
ENV TZ=${TZ}
WORKDIR /home
COPY build/libs/ventacontable-0.0.1-SNAPSHOT.jar /home/ventacontable.jar

RUN cp /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone
CMD ["java", "-Duser.timezone=${TZ}", "-jar", "/home/ventacontable.jar"]


EXPOSE 8080