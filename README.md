# kotlin-lotto-precourse

## Feature List

- User Input
  - purchase amount
    - 1,000 KRW / 1 ticket
    - divisible by 1,000
- Ticket
  - consists of 6 unique random numbers
  - in range fron 1 to 45
  - sorted in ascending order
- User Input
  - winning numbers
    - comma-separated
    - consists of 6 unique numbers
  - a bonus number
- prize ranks
  - match 6 / 2_000_000_000 KRW
  - match 5 + bonus number / 30_000_000 KRW
  - match 5 / 1_500_000 kRW
  - match 4 / 50_000 KRW
  - match 3 / 5_000 KRW
- Output
  - print match result
    - winnings
    - profit rate
- Exception
  - for invalid input data, 'IllegalArgumentException' and re-prompt from the step
  - error message must start with "[ERROR]"