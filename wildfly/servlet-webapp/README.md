# Servlet Web Application

A simple Java Servlet web application for WildFly 39 using Java 25.

## Prerequisites

- Java 25 JDK
- Maven 3.9+
- WildFly 39 (optional - can be provisioned by Maven)

## Project Structure

```
servlet-webapp/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── servlet/
        │               └── HelloServlet.java
        └── webapp/
            ├── index.html
            └── WEB-INF/
```

## Building the Application

To build the WAR file:

```bash
mvn clean package
```

This will create `target/servlet-webapp.war`

## Deploying to WildFly

### Option 1: Using WildFly Maven Plugin (Recommended)

The project includes the WildFly Maven Plugin which can provision and deploy the application:

```bash
mvn wildfly:run
```

This will:
1. Download and provision a WildFly server
2. Deploy the application
3. Start the server

### Option 2: Deploy to Existing WildFly Server

If you have WildFly 39 already running:

```bash
mvn wildfly:deploy
```

Or manually copy the WAR file:

```bash
cp target/servlet-webapp.war $WILDFLY_HOME/standalone/deployments/
```

## Accessing the Application

Once deployed, access the application at:

- Home page: http://localhost:8080/servlet-webapp/
- Hello Servlet: http://localhost:8080/servlet-webapp/hello
- Hello with parameter: http://localhost:8080/servlet-webapp/hello?name=YourName

## Servlet Details

### HelloServlet

- **URL Pattern:** `/hello`
- **HTTP Methods:** GET, POST
- **Parameters:**
  - `name` (optional) - Name to display in greeting

**Example:**
```
http://localhost:8080/servlet-webapp/hello?name=Developer
```

## Development

### Adding New Servlets

1. Create a new Java class extending `HttpServlet`
2. Add the `@WebServlet` annotation with URL pattern
3. Override `doGet()` or `doPost()` methods
4. Rebuild and redeploy

### Technology Stack

- **Java:** 25
- **Jakarta EE:** Servlet 6.0
- **Application Server:** WildFly 39
- **Build Tool:** Maven
