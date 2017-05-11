Compiler implemented in Java and ANTLR4 as a final project in compilers course on Palacky University.

## Status

* [x] Implement visitors
* [x] Walk AST
* [ ] Generate assembler

## Usage

JDK and Maven required

* Generate classes:
    ```
    mvn clean generate-sources
    ```
    
* Run main classes - currently outputs AST of Heroc source file to stdout:
    ```
    mvn clean compile exec:java
    ```