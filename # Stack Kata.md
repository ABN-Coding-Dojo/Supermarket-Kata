# Stack Kata

A stack is a linear data structure that follows the principle of Last In First Out (LIFO). This means the last element inserted inside the stack is removed first.

You can think of the stack data structure as the pile of plates on top of another or a deck of cards where you can only push to the top or take from the top.

In programming terms, putting an item on top of the stack is called **push** and removing an item is called **pop**.

## Test Driven Development approach (TDD)

#### Red, Green, Refactor
  - Add a test
  - Run all tests and see if the new one fails - Red
  - Write the minimum amount of code to pass the failing test - 
  - Run tests - Green
  - Refactor code - Blue 
  - Repeat

#### TDD Golden Rule
Do not write any production code until you have a failing test that requires it

#### Arrange, Act, Assert
- Arrange : Setup everything needed for the testing code Data initialization / mocks
- Act : Invoke the code under test / behavior
- Assert : Specify the pass criteria for the test

## Steps:
- A newly created stack should be empty
- Popping an empty stack should throw an Underflow exception
- After push, stack should NOT be empty
- After push and pop, stack should be empty
- After two pushes and one pop, stack should not be empty
- After pushing X to stack, pop should return X
- After pushing X, then Y to stack, pop should return Y, then X
