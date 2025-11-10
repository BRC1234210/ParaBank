# 🏦 ParaBank Test Automation Framework

![Java](https://img.shields.io/badge/Java-22-orange?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.37.0-green?style=for-the-badge&logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-7.30.0-brightgreen?style=for-the-badge&logo=cucumber)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red?style=for-the-badge)
![Maven](https://img.shields.io/badge/Maven-3.9.0+-blue?style=for-the-badge&logo=apache-maven)

**End-to-End Web Automation Framework for the ParaBank Demo Banking Application**

[🌐 ParaBank Demo Site](https://parabank.parasoft.com/parabank/index.htm) • [🐞 Report an Issue](https://github.com/bariscansiz/ParaBank/issues)

---

## 📋 About The Project

This is a complete **test automation framework** built for validating the functionality of the [ParaBank Demo Application](https://parabank.parasoft.com/parabank/index.htm).  
Developed in **Java** using **Selenium WebDriver**, **Cucumber (BDD)**, and **TestNG**, the project implements a modular and reusable structure following the **Page Object Model (POM)** design pattern.

🧩 *Amaç:* Web arayüzündeki işlemleri (Login, Registration, Transfer, Request Loan vb.) otomatik olarak test etmek, hataları hızlı tespit etmek ve testleri sürekli hale getirmektir.

---

## ✨ Key Features

- ✅ BDD-style scenarios written in **Gherkin** language
- ✅ **Page Object Model (POM)** structure for maintainability
- ✅ **Cucumber + TestNG** integration for test execution
- ✅ **Log4j2** logging and detailed HTML reports
- ✅ Configurable environments via `configuration.properties`
- ✅ **Screenshot capture** on test failure
- ✅ **Parallel & tagged test execution** support

---

## 🛠️ Tech Stack

| Technology | Version | Purpose |
|:-----------|:--------|:--------|
| **Java** | 22 | Programming language |
| **Selenium WebDriver** | 4.37.0 | Browser automation |
| **Cucumber (BDD)** | 7.30.0 | Behavior-Driven Development |
| **TestNG** | 7.11.0 | Test runner & grouping |
| **Maven** | 3.9.0+ | Build and dependency management |
| **Log4j2** | 3.0.0-beta2 | Logging framework |
| **Extent Reports** | 5.1.2 | HTML reporting |
| **Allure** | 2.30.0 | Advanced reporting (optional) |

---

## 🧩 Project Structure

ParaBank/
│
├── 📄 pom.xml # Maven dependencies & plugins
├── 📄 README.md # Project documentation
│
└── src/
├── test/java/
│ ├── hooks/ # Before/After scenario setup
│ ├── pages/ # Page Object Model classes
│ ├── stepDefinitions/ # Step implementations
│ ├── runner/ # TestNG + Cucumber runner classes
│ └── utility/ # BaseDriver, ConfigReader, helpers
│
└── test/resources/
├── features/ # Gherkin feature files
├── configuration.properties # Environment & credentials
├── log4j2.xml # Logging configuration
└── extent-config.xml # Extent report style

scss
Kodu kopyala

---

## 🧱 Design Pattern: Page Object Model (POM)

This framework follows the **Page Object Model**, where each web page has its own class that stores locators and actions.

```java
@FindBy(id = "amount")
private WebElement loanAmount;

@FindBy(id = "downPayment")
private WebElement downPayment;

@FindBy(xpath = "//input[@value='Apply Now']")
private WebElement applyButton;

public void fillLoanDetails(String amount, String payment) {
    sendKeysToElement(loanAmount, amount);
    sendKeysToElement(downPayment, payment);
}

public void clickApplyButton() {
    clickElement(applyButton);
}
🎯 Avantaj: Kod okunabilirliği ve bakım kolaylığı artar.
Herhangi bir sayfa değişikliğinde sadece ilgili “page” dosyası güncellenir.

🧠 Example Test Scenario (Feature)
gherkin
Kodu kopyala
@Smoke
Scenario: User successfully applies for a loan
  When The user clicks on the "Request Loan" link
  Then The user enters values in the "Loan Amount" and "Down Payment" fields
  Then The user selects an account number
  Then The user clicks the "Apply" button
  Then The user verifies the message "Credit transaction request received."
  Then The user confirms the message "Your credit transaction has been approved."
🧾 Step Definition Example
java
Kodu kopyala
@Then("The user clicks the {string} button")
public void theUserClicksTheButton(String buttonName) {
    requestLoanPage.clickApplyButton();
    LOGGER.info("Clicked the {} button", buttonName);
}
📘 Each Gherkin step is mapped to a Java method that performs the actual action.

🧩 Configuration File (configuration.properties)
properties
Kodu kopyala
browser=chrome
url=https://parabank.parasoft.com/parabank/index.htm
username=testUser
password=Admin123
💡 Tüm test ayarları tek dosyada toplanmıştır. Browser, URL veya kullanıcı bilgileri buradan kontrol edilir.

🚀 Running the Tests
▶️ From IntelliJ IDEA
Open any Runner file (e.g., LoginRunner.java)

Right-click → Run

💻 From Command Line
bash
Kodu kopyala
mvn clean test -Dcucumber.options="--tags @Smoke"
🧠 You can use @Smoke, @Regression, or @Accounts to control which tests run.

📊 Reporting
After execution, reports are generated automatically under the target/ folder.

Report Type	Location	Description
Cucumber HTML	target/cucumber-report.html	Step-by-step scenario log
Extent Report	target/extent-report.html	Detailed HTML report
Allure Report	target/allure-results	Advanced interactive report

🪵 Logging
Log4j2 is used for structured logging.
Example output:

pgsql
Kodu kopyala
INFO  Hooks - The driver has been created.
INFO  US_607_RequestLoanSteps - Clicked Apply button.
INFO  Hooks - Scenario Passed: User successfully applies for a loan
📘 Logs help track progress and quickly identify failed steps.

🧾 Tags and Filters
Tag	Purpose
@Smoke	Critical path testing
@Regression	Full suite testing
@Accounts	Registration / account scenarios

Use in CLI:

bash
Kodu kopyala
mvn test -Dcucumber.filter.tags="@Smoke or @Regression"
🧠 Error Handling & Screenshots
Automatically captures screenshots on failure

Logs all failed steps in HTML reports

Supports retry mechanisms for flaky tests

🧩 Future Improvements
🚀 Parallel browser execution (TestNG DataProvider)

☁️ Jenkins CI/CD integration

📡 REST API testing via RestAssured

🌍 Cross-browser support (Edge, Firefox, Safari)

💾 Cloud execution (BrowserStack / SauceLabs)

