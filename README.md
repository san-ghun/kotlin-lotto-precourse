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
- [ ] Calculate number of tickets based on purchase amount
- [ ] Generate lotto tickets:
  - [ ] Each ticket contains 6 unique random numbers between 1-45
  - [ ] Numbers are sorted in ascending order
- [ ] Display all generated tickets

### 3. Winning Calculation
- [ ] Compare each ticket against the winning number
  - [ ] Count matching numbers
  - [ ] Check if the bonus number matches
- [ ] Determine rank based on match:
  - [ ] 6 matches: 1st (2,000,000,000 won)
  - [ ] 5 + bonus: 2nd (30,000,000 won)
  - [ ] 5 matches: 3rd (1,500,000 won) 
  - [ ] 4 matches: 4th (50,000 won)
  - [ ] 3 matches: 5th (5,000 won)
- [ ] Count number of tickets in each rank

### 4. Return Rate
- [ ] Calculate total winnings
- [ ] Calculate and display the rate of return (to one decimal place)

### 5. Output Handling
- [ ] Print: 
  - [ ] Number of purchased tickets and their numbers
  - [ ] Winning statistics (follow example format in requirements)
  - [ ] Return rate (e.g. `Total return rate is 62.5%.`)

### 6. Exception Handling
- [ ] Throw `IllegalArgumentException` or `IllegalStateException` for invalid inputs
- [ ] All error messages start with `[ERROR]`
- [ ] Re-prompt is the user on invalid input

### 7. Structure and Testing
- [ ] `Lotto` class: 
  - [ ] Contains **ONLY** `numbers` field
  - [ ] **MUST** include validation with test code
- [ ] Separate `InputView` and `OutputView` for I/O handling
- [ ] Write unit tests for:
  - [ ] Core logic (ticket generation, match checking, ranking, etc.)
  - [ ] Exception cases and input validation
