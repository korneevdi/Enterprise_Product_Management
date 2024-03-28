## Description



## Structure
The initial core architecture of the application was a single module that contained the necessary components to manage an enterprise product list on behalf of a manager, such as web pages, an entity class, a controller, a service, and a repository. Next, the application was expanded and became a multi-module application. It was divided into two modules. One of them is a web application for the manager, and the second is a REST API containing the logic for managing goods. The application also includes validation of data entered by the manager through the browser.

The module for managing the product catalog is connected to the PostgreSQL database to store a list of all products using Spring Data. The manager module is also connected to a database to store usernames, passwords, and roles for appropriate data access. An authentication procedure has also been introduced between the modules to prevent access to data by unauthorized persons.

All methods for working with databases in both modules are covered with tests to verify the correct operation of the application.
