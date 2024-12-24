# Proxy Object Project

This project demonstrates the use of Java Dynamic Proxies and CGLIB proxies. It's built with Maven and requires Java 17 or later (tested with Java 22).

## Project Structure

The project is structured as follows:

*   `src/main/java`: Contains the main application code.
*   `pom.xml`: The Maven project configuration file.

## Dependencies

The project uses the following dependencies:

*   CGLIB (for CGLIB proxy examples)

## Building the Project

To build the project, use Maven:

```bash
mvn clean package 
```
## Test Dynamic Proxy

```bash
# Running Dynamic proxy
java -jar proxy-1.0-SNAPSHOT.jar dynamic-proxy
```

## Test CGLIB Proxy

```bash
# Running Dynamic proxy
 java --add-opens java.base/java.lang=ALL-UNNAMED -jar proxy-1.0-SNAPSHOT.jar cglib-proxy
```