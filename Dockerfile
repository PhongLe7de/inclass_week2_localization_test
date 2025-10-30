FROM maven:latest
LABEL author="phongle"

WORKDIR /app
COPY pom.xml /app
COPY . /app
RUN mvn package
CMD ["java", "-jar", "target/bmi.jar"]