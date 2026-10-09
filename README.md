# E-Commerce Web Automation Framework (Selenium-Java)

### 📌 Project Overview
An enterprise-standard automation testing framework engineered with **Selenium WebDriver**, **Java**, and **TestNG**, implementing the **Page Object Model (POM)** architectural design pattern to optimize script reusability and maintainability.

### 🛠️ Framework Features
- **Page Object Model:** Separated page web elements and action scripts from actual execution assertions to avoid maintenance debt.
- **Dynamic Element Handling:** Utilized Custom XPath/CSS Selectors alongside Explicit Wait wrappers to reliably interact with asynchronous UI loaders.
- **TestNG Integration:** Managed batch test distributions, group allocations, and assertion executions.

### 💻 Tech Stack
- **Language:** Java (JDK 11+)
- **Automation Core:** Selenium WebDriver
- **Build Engine:** Maven
- **Test Runner:** TestNG

### 🏁 Setup & Execution Instructions
To run this suite locally, clone this project and execute the Maven command:
```bash
git clone https://github.com
cd ecommerce-selenium-framework
mvn clean test
```
