# pi
### Simple implementation of Pi calculation

### Calculates Pi by the infinite series:
 ```
 4 * Pi = 1 - 1/3 + 1/5 - 1/7 + ...
 ```
 For simplicity of implementation, I have converted this to the equivalent formulation:
 
 ```
 Pi = 4 - 4/3 + 4/5 - 4/7 + ...
 ```
 The code algorithm is implemented in iterative style.  While it is possible to implement this algorithm in a recursove style, 
 since Java 8 compiler does not implement tail-call recursion optimisation, the code hits a Stack Overflow exception for n = 100 on my machine.
 
 By comparison, the Scala compiler does perform this optimisation, and a tail recursive solution would have the same performance characteristics as 
 the iterative java version.
 
### Build using Maven:

```
mvn package
```

### Usage: 

```
java -jar ./target/pi-1.0-SNAPSHOT.jar n
```
where n = number or elements to use to approximate Pi.
