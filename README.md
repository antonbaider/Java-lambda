# JOM. Functional Interfaces. Lambda
## Task 2

Create the **static** field **cons** of type **Consumer** and assign it the **_lambda expression_** that takes an array of **doubles** as a parameter and changes it using the next rule: all values that are **_greater than 2_** should be **_multiplied by 0.8_**, and **_other values_** should be **_multiplied by 0.9_**.

Also implement a **static** method **getChanged(...)** that takes an array of doubles as a first parameter and **Consumer** implementation as a second. The method should **return** an array changed by the second parameter.

The getChanged(...) method should not change initial array. 
