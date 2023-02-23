# Microservice example for user information consultation

This microservice was developed only for a simple integration test with the agenda voting service that makes an appointment to find out if the user is able to vote or not.

Voting microservice: https://github.com/tuliohsa87/voting-microservice

Since this microservice was only for basic test purposes, the security and validation issue of CPF were ignored. Then you can access some valid CPF generation platform and use normally.

Platform to generate valid CPF: https://www.4devs.com.br/

## Requirements

For building and running the application you need:

* Java JDK 17
* Maven 2

## Setup

For project local execution you need to access the `application.properties` file and modify the Prod environment variable for Dev as per below.

Production environment

        spring.profiles.active=prod

Development environment

        spring.profiles.active=dev

## Running the application locally

The simplest way to put the project to work is to perform the `` main`` method in the `io.github.tuliohsa87.userinfo.UserInfoApplication` class from your IDE, whether STS or INTELLIJ.

Another way is through the Maven command line:

``mvn spring-boot:run``

## Versioning

This project is using semantic version practices 2.0.0

In addition to using semantic version control, the version has also been inserted into each controller's URL, so when new features are created, they do not affect users who depend on the previous version and there will be a necessary time until users suit the new functionalities.

For more information about semantic version click [here](https://semver.org/lang/pt-BR/)
