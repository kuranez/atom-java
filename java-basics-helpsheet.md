# Java Helpsheet

## Klasse (Template)

```java
public class Class {

    //Eigenschaften - strings, int

    //Konstruktor - Klassenkonstruktur public ...
        //Dann Variablen (String var1, int var2)
        //Klammern nicht vergessen! {}

    //Methoden

    //Getter und Setter
}
``` 


## Klasse (ExampleClass)

```Java
public class ExampleClass {

    // Eigenschaften
    private String name;
    private int number_a;
    private int number_b;

    // Konstruktor
    public ExampleClass(String name, int numberA, int numberB) {
        this.name = name;
        this.number_a = numberA;
        this.number_b = numberB;
    }

    // Methode
    public double calculateMultiply(int n1, int n2) {
        return (n1 * n2);
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getNumberA() {
        return number_a;
    }

    public int getNumberB() {
        return number_b;
    }
}

```

### Quick examples — create an instance and call the method.

#### 1. From a main method (static context):

```java
public class Main {
    public static void main(String[] args) {
        ExampleClass ex = new ExampleClass("Foo", 3); // uses your constructor
        double result = ex.calculateMultiply(ex.getNumberA(), ex.getNumberB());
        System.out.println(result);
    }
}
```

#### 2. From another instance method:

```java
ExampleClass ex = new ExampleClass("Foo", 3);
double result = ex.calculateMultiply(ex.getNumberA(), ex.getNumberB());
```

#### 3. From inside ExampleClass (direct field access):

```java
public void someMethod() {
    double result = calculateMultiply(number_a, number_b);
}
```