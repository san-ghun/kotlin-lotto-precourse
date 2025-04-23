# kotlin-lotto-precourse

> [!NOTE]
> 
> Learning Objectives
> - Group related functions into classes so that objects collaborate to perform a larger feature.
> - Write unit tests for each class and function to ensure they work as intended.
> - Incorporate as much of the [Feedback on Pre-course Week 1](https://docs.google.com/document/d/1MXczCggC5-mYRzbgcAIDVec4xaTMojIh3vHLGwhTMgQ/edit?usp=sharing) as possible.

## Requirements summary

| Category               | Checkpoint                                                                                        |
|------------------------|---------------------------------------------------------------------------------------------------|
| **Object-Oriented**    | Class level role separation (e.g.,`LottoTicket`, `LottoNumber`, `LottoResult`, `LottoMachine`)    |
| **Feature List**       | Write in `README.md` and use it as a commit standard                                              |
| **Unit Test**          | Write tests for each core class (purchase amount, lotto ticket issuance, winner comparison, etc.) |
| **Output Format**      | **Must** match the output example                                                                 |
| **Exception handling** | Allow only `IllegalArgumentException`, `IllegalStateException` + re-prompt logic is required      |
| **Commit Message**     | Apply [AngularJS commit message rule](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) |
| **Minimum E2E Test**   | `./gradlew clean test` and then check `BUILD SUCCESSFUL`                                          |


## Feature List

### 1. Input Handling
    - [ ] Purchase Amount Input
      - [ ] Prompt user for the purchase amount
      - [ ] Verify it is a positive number divisible by 1000
      - [ ] Throw exception for invalid input (negative, zero, non-numeric, less than 1000)
    - [ ] Winning Numbers Input
      - [ ] Prompt user for 6 comma-separated numbers
      - [ ] Verify all numbers are in range 1-45 and not duplicated
      - [ ] Throw exception for invalid format (empty, blank, more, less)
      - [ ] Throw exception for invalid input (negative, zero, non-numeric)
    - [ ] Bonus Number Input
      - [ ] Prompt user for 1 number
      - [ ] Verify the number is in range 1-45 and not duplicated from the winning numbers
      - [ ] Throw exception for invalid input (negative, zero, non-numeric)

### 2. Lotto Issuance
    - [ ] Calculate the number of tickets based on the amount entered
    - [ ] Generate list of 6 random numbers as many as the number of tickets and create tickets
      - [ ] Each ticket consists of 6 numbers in the range of 1 to 45 that are not duplicated
    - [ ] Sort the generated numbers in ascending order

### 3. Winning Calculation
    - [ ] Compare each ticket with the winning number
      - [ ] Calculate the number of matching numbers
      - [ ] Do the bonus number check whether it matches or not
    - [ ] Calculate Rank
      - [ ] 6 matches: 1st
      - [ ] 5 + bonus: 2nd
      - [ ] 5: 3rd
      - [ ] 4: 4th
      - [ ] 3: 5th
    - [ ] Calculate winning statistics (number by rank)

### 4. Calculate the rate of return
    - [ ] Calculate the total winning amount
    - [ ] Calculate the rate of return compared to the total purchase amount

### 5. Output Handling
    - [ ] Print the number of purchased tickets and list of number
    - [ ] Print winning statistics
      - [ ] Follow the Example Execution in requirement document
    - [ ] Print the rate of return
      - [ ] Print it to the first decimal place. Example: `Total return rate is 62.5%.`

### 6. Exception Handling
    - [ ] If the input value is incorrect, throw `IllegalArgumentException` or `IllegalStateException`
    - [ ] Error messages **SHOULD** always start with `[ERROR]`
    - [ ] Re-prompt is required when incorrect input is entered

### 7. Structure and Testing
    - [ ] `Lotto` class uses **ONLY** `numbers` as a field, and **MUST** include validation of the class with test code
    - [ ] Separate `InputView` and `OutputView` classes or objects to separate UI and logic
    - [ ] Write unit tests for each main class and core logic
    - [ ] Write unit tests for exception situations
