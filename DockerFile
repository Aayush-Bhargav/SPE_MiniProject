# Use a lightweight official Java Runtime Environment (JRE) as the base image
FROM openjdk:17-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file created by Maven's 'package' goal
# from the host's 'target/' directory into the container's '/app' directory.
# NOTE: The JAR name must match your pom.xml's artifactId and version.
COPY target/scientific-calculator-project-1.0-SNAPSHOT.jar app.jar

# Command to run the JAR file when the container starts
# The Main class (com.spe.calculator.Main) runs the command line menu.
ENTRYPOINT ["java", "-jar", "app.jar"]
