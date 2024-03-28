## Description

The application is software for managing an enterprise's product catalog. The manager can add new products, change them and delete them, as well as filter the list of products to find what they need. Before gaining access to and management of data, the manager must go through the authorization procedure. The application is connected to two databases, with which you can manage the list of products, as well as add other managers.

## Structure
The initial core architecture of the application was a single module that contained the necessary components to manage an enterprise product list on behalf of a manager, such as web pages, an entity class, a controller, a service, and a repository. Next, the application was expanded and became a multi-module application. It was divided into two modules. One of them is a web application for the manager, and the second is a REST API containing the logic for managing goods. The application also includes validation of data entered by the manager through the browser.

The module for managing the product catalog is connected to the PostgreSQL database to store a list of all products using Spring Data. The manager module is also connected to a database to store usernames, passwords, and roles for appropriate data access. An authentication procedure has also been introduced between the modules to prevent access to data by unauthorized persons.

All methods for working with databases in both modules are covered with tests to verify the correct operation of the application.

## Frameworks & Tools used in the application

Spring Boot, Spring MVC, Spring Data, Spring Security, PostgreSQL, JUnit.
