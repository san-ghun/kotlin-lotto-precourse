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

1. Input Handling
    - [ ] Take user input of purchase amount
      - [ ] Verify if it is divisible by 1000
      - [ ] Exception handling for negative, 0, and non-number inputs
    - [ ] Take user input of 6 winning numbers, comma-separated
      - [ ] Verify if there are 6 numbers in the range of 1 to 45, not duplicated
      - [ ] Exception handling for negative, 0, and non-number inputs
    - [ ] Take user input of a bonus number
      - [ ] Verify if the number is in the range of 1 to 45, not duplicated with winning numbers
      - [ ] Exception handling for negative, 0, and non-number inputs
    - [ ] If incorrect, the message `[ERROR]` is displayed and the user is prompted to re-enter the information
2. Lotto Issuance
    - [ ] Calculate the number of tickets based on the amount entered
    - [ ] Generate list of 6 random numbers as many as the number of tickets and create tickets
      - [ ] Each ticket consists of 6 numbers in the range of 1 to 45 that are not duplicated
    - [ ] Sort the generated numbers in ascending order
3. Winning Calculation
    - [ ] Compare each ticket with the winning number
      - [ ] Calculate the number of matching numbers
      - [ ] Bonus number Check if it matches or not
    - [ ] Calculate Rank
      - [ ] 6 matches: 1st
      - [ ] 5 + bonus: 2nd
      - [ ] 5: 3rd
      - [ ] 4: 4th
      - [ ] 3: 5th
    - [ ] Calculate winning statistics (number by rank)
    - [ ] Calculate the rate of return
4. Output Handling
    - [ ] Print the number of purchased tickets and list of number
    - [ ] Print winning statistics
    - [ ] Print the rate of return
    - [ ] Print error message starting with `[ERROR]`
5. Structure and Testing
    - [ ] `Lotto` class uses only `numbers` as a field, and must include validation of the class with test code
    - [ ] Separate `InputView` and `OutputView` classes or objects to separate UI and logic
    - [ ] Write unit tests for each main class and core logic
    - [ ] Write unit tests for exception situations