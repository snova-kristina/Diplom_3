# Diplom_3 : Selenium  Project
This is a Project with tests for web application https://stellarburgers.nomoreparties.site/

## Tools Used
1. IntelliJ IDEA community Edition
2. Maven 3.9.0
3. JDK 11
4. Selenium 4.8.1
5. JUnit 4.13.2
6. WebDriverManager

##Tests
To run the application tests just type the following command:
`mvn clean test`
You can run tests both in Яндекс.Браузер and in Google Chrome browser. For running tests in Google Chrome use the following command:
`mvn verify -Dbrowser=chrome`
For running tests in Яндекс.Браузер use the following command:
`mvn verify -Dbrowser=yandex`
