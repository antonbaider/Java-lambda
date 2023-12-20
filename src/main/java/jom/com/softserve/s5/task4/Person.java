package jom.com.softserve.s5.task4;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = (productName, discount) -> ("product1".equals(productName) && discount > 10);
}

@FunctionalInterface
interface DecisionMethod {
    boolean decide(String product, int discount);
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int count = 0;

        for (DecisionMethod client : clients) {
            if (client.decide(product, percent)) count++;
        }
        return count;
    }
}