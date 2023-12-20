# JOM. Functional Interfaces. Lambda
## Task 3

Suppose, we have the next class **Person**:
```
class Person{  
    String name;  
    String surname;  
    Person(String name, String surname){ 
        this.name = name;  
        this.surname = surname;  
    }  
}
```
Add to **App** class **static** field **greetingOperator** of type **BinaryOperator**. 

The **greetingOperator** should create a new string as a result by the rule:  
***"Hello " + parameter1 + " " + parameter2 + "!!!"***

Create a **static** method **createGreetings(...)** that takes two parameters: **List<Person>** and **BinaryOperator** and generates **List<String>** as a result. We should be able to pass **greetingOperator** as a parameter here.

Please, use the **second parameter** in creating the result.
