# Start with a base image containing Java runtime (Amazon Corretto is open-source and freely available)
FROM amazoncorretto:17 as builder

# Information around who maintains the image
LABEL maintainer="pcuestamorer@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file (when packaged)
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} spring-cash-cards-api.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cash-cards-api.jar"]
