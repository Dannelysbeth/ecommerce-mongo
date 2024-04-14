# Use the official OpenJDK image as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/mongodb-shop.jar mongodb-shop.jar

# Run the JAR file
CMD ["java", "--enable-preview", "-jar", "mongodb-shop.jar"]
