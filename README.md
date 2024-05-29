# Atm Implementation

# Objective

## Problem Statement

- Write compiling code for "Cash Withdrawal" function, from an ATM which based on user specified amount,
  dispenses bank-notes.

Ensure that the code takes care of the following:

- Minimum number of bank-notes are used while dispensing the amount
- Availability of various denominations in the ATM machine is maintained
- Code should be flexible to take care of any bank denomination as long as it is multiple of 10
- Code should support parallel Cash Withdrawals i.e. two or more customer's should be able to withdraw money
- Takes care of exceptional situations
- Write appropriate unit test cases too
- State any assumptions made
- Write the compiling code using choice of your IDE (Eclipse, IntelliJ)
- Provide Unit Test Cases using JUNIT (if you are not conversant with JUNIT, just list down unit test cases)

## NFRs

- Make any necessary assumption, and clearly state the assumptions made.
- Do not seek any help online or through any other source.

## Evaluation Criteria

- **Code Completeness/ Correctness**
- **Code Structure**: Modularity, usage of 00Ps principles and design patterns, size of classes, and functions, n-path
  complexity of functions.
- **Code Quality**: class/function/variable naming conventions, package/class structure, log messages - please do not
  provide comments unless necessary
- **Choice of data structures**
- **Efficiency of code** (leverage multi-threading wherever it makes sense)
- **Code test Cases and follow TDD** (if know)

# Solution

# ATM Project Application

## Overview

The ATM Project Application simulates an ATM system where multiple users can withdraw cash simultaneously.
The application ensures proper handling of cash denominations.

## Features

- Simulates ATM cash withdrawal operations.
- Manages cash denominations within the ATM.
- Ensures thread safety for concurrent transactions.
- Logs transaction details and errors using Log4j.

## Components

### Main Class

- **AtmProjectApplication**: The entry point of the application. It initializes the ATM and starts multiple user threads
  to perform withdrawal operations.

### Services

- **ATMUser**: Represents an ATM user performing a withdrawal operation.
- **Withdrawal**: Handles the withdrawal operations, and proper management of cash denominations.

### Repository

- **Atm**: Singleton class representing the ATM with cash denominations. Provides methods to access and update the cash
  denominations.

### DTO

- **WithdrawalTranscation**: Represents a withdrawal transaction with details about the denomination and the number of
  notes dispensed.

## How to Run

1. **Clone the repository**:
   ```sh
   git clone https://github.com/Vanshikaaswani/ATM-Implementation.git
   ```

2. **Build the project**
   ```sh
   mvn clean install
   ```

3. **Run the application**
   ```sh
   mvn exec:java
   ```

## Logging

The application uses Log4j for logging transaction details and errors. Logs are printed to the console.

## Unit Tests

Unit tests are written using JUnit to ensure the correctness of the withdrawal operations.

## Assumptions

1. ATM can have any number of denominations, but all denominations should be multiple of 10.
2. User can withdraw any available amount in multiple of 10.

## Future scope

1. UI: We can develop user-friendly GUI to withdraw the cash.
2. Enhanced Security: Implement user authentication and integration can be efficient.
3. Database: Implementation of database can be done to store ATM details.