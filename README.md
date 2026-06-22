# UI Automation Framework

This project is a UI test automation framework built with:

- Java
- Selenium WebDriver
- Cucumber (BDD)
- JUnit
- Maven
- Allure Reports

---

## 🚀 How to run tests

Run all tests:

```bash
mvn clean test
```

### 📊 Allure report

After test execution:
```bash
allure serve target/allure-results
```

### ⚙️ What this project does
```bash
Opens web application
Automates registration and login flows
Uses random test data (email, password)
Validates UI behavior
Generates test report with Allure
```
### 🧪 Test approach
```bash
BDD style (Gherkin scenarios)
Page Object Model
Shared test context between steps
Explicit waits for stability
```
### 📌 Notes
```bash

Make sure ChromeDriver is installed/configured
Tests are independent (no order dependency)
Each test uses fresh data where needed
```

### 📊 Reporting issue check
```bash
If Allure report is empty:

Run mvn clean test
Check target/allure-results folder exists
```