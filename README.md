---
# Entrata Automation Test (using Java Selenium Maven Testng)
---

## Overview

For Entrata Automation Test we have used POM framework in selenium using
Java as scripting language. Maven is used for dependency management.
TestNG is used to maintain test cases.

## Table Of Contents

-   Pre-requisites

-   Designing Automation Framework

-   Test Script Details

-   Test Execution

-   Steps to run Test Script

## Pre-requisites

-   Eclipse IDE

-   Java Development Kit (JDK)

-   Maven

-   ChromeDriver (for Chrome browser)

-   Testng

## Designing Automation Framework

Created project structure to implement Page Object Model framework details below.
###	Page class- 
  * Homepage, WatchDemoPage, SummitPage, RegistrationPage
  *	Has  web element initialization and action methods for Business Logic.
###	Base class –
  *	Considered as Parent Class extended by all other classes.
  *	Contains WebDriver initialization and reusable method as per need.  
###	Test class-
  *	In this calling method using testng annotations to validate respective testcase functionality.
###	Test data handling-
  *	Test data passed using @dataProvider annotation. 
###	Config property file-
  *	Url and Browser value used for execution are configured here.
###	Utility file-
  *	Common utility properties for E.g-Page Timeout,Wait time are set here.
###	pom.xml-
  *	Maven Dependencies used are mentioned below – 
selenium-java, testing, maven-surefire-plugin mentioned in the file.
###	testng.xml-
*	Created test suite to execute automated test scripts mentioned all the test classes here.
###	Testng Report-
*	Generated Testng HTML report post execution.

## Test Script Detail

| S.no    | Test Script Name | Test Method Name | Functional Flow |
| -------- | ------- |-------- | ------- |
| 1 | ValidateUI_HomePageTest | homenPageTitleTest() | Verifies the title of the homepage and checks if the Sign In button is displayed. Close browser instance. |
| 2 | ValidateUI_EnterField_WatchDemo |	enterFieldsWatchDemo() | Clicks the Watch Demo button, enters user information, and verifies the presence of the submit button. |
| 3 | Verify_Navigation_UI_SummitPage | summitPageValidation() | Navigates to the Summit page using window handles and validates the presence of Assert and Overview links. |
| 4 | Validate_FieldError_FirstName_Email_RegistrationPage | errorRegistrationValidation() | Navigates to the Registration page, checks for the First Name error message, and then validates the Email error message with an invalid input. |
| 5 | ValidateDropdownValues_Resources | errorRegistrationValidatiom | Navigates to the Registration page, checks for the First Name error message, and then validates. |

## Steps to run Test Script

- git  clone <https://github.com/ShivamSendhiya/Entrata_AutomationTest.git> 
- open cmd
- cd Entrata_AutomationTest
- mvn clean test
- mvn verify

- Shivamsendhiya@gmail.com
- 7083553178
