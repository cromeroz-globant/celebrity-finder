# Find the Celebrity

In a team of _N_ people, a **_celebrity_** is known by everyone, but he/she doesn't know anybody.

## Solution

This was implemented by using TDD and Java 8 features such as `Optional` and `Stream` to determine
the conditions for a person to be considered a celebrity.

The test cases consider:

* An empty group of people
* A group with just one person
* A group of two people (one is the celebrity)
* A group of two people (they know each other)
* A group of two people (they don't know each other)
* A group of four people (with a celebrity)
* A group of four people ("celebrity" knows one person)

## Build and Run

The code uses:

* Maven
* Java 11 (to be able to use `java.util.List.of()` in tests)
* JUnit 5
* AssertJ

To execute the tests, run

```shell
mvn clean verify
```