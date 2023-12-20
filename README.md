# JOM. Functional Interfaces. Lambda
## Task 4

Suppose, we have the **Person** class with fields **name** and **goShopping**.

The **goShopping** field defines if **Person** will do shopping based on product **name** and **discount** that come as parameters. You should define the next default behavior for goShopping:

```
return true if product name = "product1"  and discount > 10, otherwise return false.
```
Define the type for **goShopping** field and name it **DecisionMethod** and define a method decide in it.

Also, we have the class **Shop** with method **sale()**. This method informs users about a discount product and a percentage of discount by using their **goShopping** values (which are stored in clients field). The method should **return** the **_count of users_** that will go shopping.
