## Installation

Clone this repository.

To install all dependencies, run

```console
$ mvn clean install
```

Change the home page URL in /cucumber-java-selenium-webdriver-example/src/test/java/com/automatedtest/sample/homepage/HomePage.java
Change the chrome path in /cucumber-java-selenium-webdriver-example/src/test/java/com/automatedtest/sample/infrastructure/driver/Setup.java

## Running tests

```console
$ mvn test
```

After execution the html reports will be placed in /cucumber-java-selenium-webdriver-example/target/home-page-html
