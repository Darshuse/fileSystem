FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} filesystem.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/filesystem.jar"]




version:'3'
services:

  postgres:
    image: postgres:13.1-alpine
    network_mode: bridge
    container_name: stcdb
    expose:
    - 5432
    ports:
      - 5432:5432
    environment:
         - POSTGRES_PASSWORD=root
         - POSTGRES_USER=root
         - POSTGRES_DB=file_managment

  springbootapp:
    image: docker-spring-boot-postgres:latest
    build:
      context: .
    network_mode: bridge
    container_name: stc-springboot-app-container
    expose:
      - 8080
    ports:
      - 8080:8080
    depends_on:
      - postgres
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/file_managment
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=root
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
    links:
      - postgres