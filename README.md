# pi
### Simple implementation of Pi calculation

### Calculates Pi by the infinite series:
 ```
 4 * Pi = 1 - 1/3 + 1/5 - 1/7 + ...
 ```
 The code algorithm is implemented in iterative style.  While it is possible to implement this algorithm in a recursove style, 
 since Java does not implement tail-call recursion optimisation, the code would hit a Stack Overflow exception before getting useful results.
 
### Build using Maven:

```
mvn package
```

### Usage: 

```
java -jar ./target/pi-1.0-SNAPSHOT.jar n
```
where n = number or elements to use to approximate Pi.
