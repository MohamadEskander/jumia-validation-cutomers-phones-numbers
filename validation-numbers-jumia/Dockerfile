FROM openjdk:8
ADD     target/validation-numbers-jumia.jar validation-numbers-jumia.jar
ADD sample.db sample.db
EXPOSE 8081
ENTRYPOINT [ "java","-jar","validation-numbers-jumia.jar" ]