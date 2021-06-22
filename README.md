# javafp
[![Java CI with Gradle](https://github.com/Tyagi-Gaurav/javafp/actions/workflows/gradle.yml/badge.svg)](https://github.com/Tyagi-Gaurav/javafp/actions/workflows/gradle.yml)

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