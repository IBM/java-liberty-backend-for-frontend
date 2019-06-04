# WARNING: This repository is no longer maintained :warning:

> This repository will not be updated. The repository will be kept available in read-only mode.

[![](https://img.shields.io/badge/IBM%20Cloud-powered-blue.svg)](https://cloud.ibm.com)
[![Platform](https://img.shields.io/badge/platform-java-lightgrey.svg?style=flat)](https://www.ibm.com/developerworks/learn/java/)

# Create and deploy a Java Backend For Frontend (BFF) using Java EE

> We have similar patterns available for [Node.js](https://github.com/IBM/nodejs-backend-for-frontend), [Swift](https://github.com/IBM/swift-backend-for-frontend), and [Java Spring](https://github.com/IBM/spring-backend-for-frontend) as well!

In this code pattern, you will create a Backend for Frontend (BFF) web service using Java EE [MicroProfile](https://microprofile.io/) running on [WebSphere Liberty](https://developer.ibm.com/wasdev/), matching a RESTful API documented in [Swagger](https://swagger.io/).

A BFF can be used to elegantly expose complex backend systems to multiple client-facing platforms, such as iOS and the web, without building a monolothic API that attempts to serve all clients equally. Different types of clients require different types of user experiences, and having a backend API tightly coupled to each specific user experience actually makes for a much more loosely coupled system overall. This pattern helps frontend teams iterate on features faster by giving them more control over the APIs they interact with, without affecting the user experience or development team driving a sister frontend.

When you have completed this code pattern, you will understand how to:

* Build out the Backend for Frontend (BFF) architecture pattern
* Deploy to Kubernetes, Cloud Foundry or a DevOps Pipeline
* Operate an application with monitoring and distributed trace
* Connect to provisioned services

![](doc/source/images/architecture.png)

## Video

Learn more about the Backend for Frontend pattern in this tech talk:

[![BFFs and GraphQL, terms you should know and why](https://img.youtube.com/vi/B5OdK21ZevI/maxresdefault.jpg)](https://www.youtube.com/watch?v=B5OdK21ZevI)

## Steps

> As an alternative to the steps below, you can [create this project as a starter kit](https://cloud.ibm.com/developer/appservice/create-app?starterKit=704af9af-c07b-33ab-881c-e89ec39b0aae) on IBM Cloud, which automatically provisions required services, and injects service credentials into a custom fork of this pattern. Then, you can skip directly to step 4 below.

1. [Install development tools](#1-install-development-tools)
1. [Configuration](#2-configuration)
1. [Project contents](#3-project-contents)
1. [Run](#4-run)

## 1. Install development tools

* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Java 8 JDK from IBM (AIX, Linux, z/OS, IBM i)](https://www.ibm.com/developerworks/java/jdk/),
    or [Download a Liberty server package](https://developer.ibm.com/wasdev/downloads/download-latest-stable-websphere-liberty-runtime/)
    that contains the IBM JDK (Windows, Linux)

## 2. Configuration

The application is configured to provide JAX-RS REST capabilities, JNDI, JSON parsing and Contexts and Dependency Injection (CDI).

These capabilities are provided through dependencies in the `pom.xml` file and Liberty features enabled in the server config file found in `src/main/liberty/config/server.xml`.

## 3. Project contents

The BFF application has a health endpoint which is accessible at `<host>:<port>/javalibertybackendforfrontend/health`. The context root is set in the `src/main/webapp/WEB-INF/ibm-web-ext.xml` file. The ports are set in the `pom.xml` file and exposed to the CLI in the `cli-config.yml` file.

The project contains IBM Cloud specific files that are used to deploy the application as part of a IBM Cloud DevOps flow. The `.bluemix` directory contains files used to define the IBM Cloud toolchain and pipeline for your application. The `manifest.yml` file specifies the name of your application in IBM Cloud, the timeout value during deployment and which services to bind to.

Credentials are either taken from the `VCAP_SERVICES` environment variable that IBM Cloud provides or from environment variables passed in by JNDI (see the server config file `src/main/liberty/config/server.xml`).

## 4. Run

To build and run the application:

1. `mvn install`
1. `mvn liberty:run-server`

To run the application in Docker use the Docker file called `Dockerfile`. If you do not want to install Maven locally you can use `Dockerfile-tools` to build a container with Maven installed.

The application exposes the following endpoints:

* Health endpoint: `<host>:<port>/<contextRoot>/health`
* Swagger API: `<host>:<port>/ibm/api/explorer/`, you will need to login with the credentials set in your `server.xml` file. By default these are `guest` and `password`.

The context root is set in the `src/main/webapp/WEB-INF/ibm-web-ext.xml` file. The ports are set in the `pom.xml` file and exposed to the CLI in the `cli-config.yml` file.

## License

This code pattern is licensed under the Apache License, Version 2. Separate third-party code objects invoked within this code pattern are licensed by their respective providers pursuant to their own separate licenses. Contributions are subject to the [Developer Certificate of Origin, Version 1.1](https://developercertificate.org/) and the [Apache License, Version 2](https://www.apache.org/licenses/LICENSE-2.0.txt).

[Apache License FAQ](https://www.apache.org/foundation/license-faq.html#WhatDoesItMEAN)
