# Read Me First

The following was discovered as part of building this project:

* The original package name 'org.schoolapp.school-app' is invalid and this project uses 'org.schoolapp.schoolapp'
  instead.

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.14/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.14/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.14/reference/htmlsinge/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## How to deploy:

#### Navigate to root directory of the project(directory of pom.xml is the root) and run below steps:

1. **Run mvn clean install**
2. **sh deploy.sh < start>**   -- argument can be start,stop,restart
    1. for example ***sh deploy.sh start*** will start the app
