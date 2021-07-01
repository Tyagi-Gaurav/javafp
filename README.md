# javafp
[![Gradle CI](https://github.com/Tyagi-Gaurav/javafp/actions/workflows/gradle.yml/badge.svg)](https://github.com/Tyagi-Gaurav/javafp/actions/workflows/gradle.yml)
[![Sonar](https://github.com/Tyagi-Gaurav/javafp/actions/workflows/sonar.yml/badge.svg)](https://github.com/Tyagi-Gaurav/javafp/actions/workflows/sonar.yml)

## Types
### Tuple
Set of two different types

### Triple
Set of three different types

## List Operations

| Operation     | Description     |  
| :-------------      | :----------:      | 
| Head  | Returns the first element of the list   |
| Tail  | Everything after the first element of the list   |
| Init  | Everything but the last element of the list   |
| Reverse  | Self descriptive   |
| Take While  | Return the first `x` elements of a list  |
| Drop While  | Return the elements of list after skipping the first `x` elements  |
| Sum  | Compute the sum of all the elements of the list  |
| Zip  | Zips together elements of two lists  |
| Zip3  | Zips together elements of three lists  |
| Foldl | Left Fold (Folds up the list from left side. The function is applied from the starting value) |

## Exceptions

### Try Catch With no return Value
* Use this block when you like to execute a routine without expecting any 
return value.
  ```
  TryCatchWithoutResult(() -> {
            // Do Something here
            // throw new RuntimeException();
        }).onException(() -> // Handle Exception)
          .withFinally(() -> // Handle Finally)
          .run();
  ```

### Try Catch With return Value
* Use this block when you like to execute a routine and also return a result.
  ```
  TryCatchWithResult(() -> {
            // Do Something and Return result
        }).onExceptionReturn(() -> //Do Something and Return)
          .withFinally(() -> // Handle Finally)
          .run();
  ```