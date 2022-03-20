**Note:** Details about the API used in the project will be updated soon in the documentation along with the Java Doc.

**Documentation is in Progress**

# Project Title

Cucumber Framework

## Description

This project is the custom build framework that can be easily used for any Test Automation.

The framework was created to help the community get started with automation for their automation learning journey.

Please contact me in case you have framework issues. My contact details are below.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them.

```
Java JDK 1.8 or above
Eclipse IDE
Cucumber Eclipse Plugin
```

### Installing

A step by step series of examples that tell you how to get a development env running.

Windows:

```
Go to the GitHub repository and clone the project
Import the project in Eclipse as Maven project
Once the build is complete, perform the Update project in the Maven options
```

## Updating the Feature files

In order to use the framework to your need the Feature files and the Implementation files needs to be changed.

### Feature File

```
Location: src/test/resources/Feature
Add the Feature files to the mentioned location and update the test scenarios according to the requirements
```

### Step Definition

```
Location: src/main/java/com/selenium/stepDefinition
The feature file has been glued into the Java code in this specific package
```

### Step Definition

```
Location: src/main/java/com/selenium/implementation
The actual Java code to perform the web operations is written here and the method is called in the step Definition
```

## Running the tests

Update the Metadata File with the list of Feature files to Execute.

Run the Mainclass.class under the com.selenium.runnerClass package.

Once the test is completed the Report will be generated in Reports Folder.

## Authors

* **Kalicharan Swaminathan** - *Initial work* - [Cucumber Framework](https://github.com/charan96-code/com.selenium.cucumberFramework)

See also the list of [contributors](https://github.com/charan96-code/com.selenium.cucumberFramework/graphs/contributors) who participated in this project.

## Contact

LinkedIn: [kalicharan-swaminathan](https://www.linkedin.com/in/kalicharan-swaminathan)
