package jom.com.softserve.s5.task5;

import java.util.Set;
import java.util.function.Predicate;

public class MyUtils {
    public static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> set) {
        return set.stream().reduce(Predicate::and).orElse(n -> true);
    }
}