# Tomasz Przybysz - Fruits Basket

The App accepts fruit names as command line arguments. As specified by the exercise description accepted fruit names are:
_Apple_, _Banana_, _Melon_ and _Lime_. Adding any other other fruit to the basket will cause `IllegalArgumentException`.

If no arguments are passed basket remains empty and a total cost £0.00 is calculated.

Content of the basket as well as calculated total cost is printed to the system console.

## Assumptions
- prices are defined in pennies and `int` type capacity is sufficient to store them
- `int` capacity is sufficient as well for the total cost of a basket in pennies
- fruit names are case sensitive

## Test
To run tests execute command `./gradlew test`

## Build
To build the app execute command `./gradlew build`

## Run
To run the app, after building it:
- go to folder `<project-root>/build/distributions/`
- unzip `fruit-basket.zip`
- go to subfolder `fruit-basket/bin`
- run `./fruit-basket <fruit-name-1> <fruit-name-2> ... <fruit-name-n>`

Alternatively app can be run under IDE via `FruitBasketApp` class.

## Versions
Java 8 (build 1.8.0_31-b13).
Gradle 3.5 (wrapper included).