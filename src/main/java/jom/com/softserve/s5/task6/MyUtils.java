import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {

    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().filter(predicate).mapToInt(Integer::intValue).max().orElse(0);
    }
}

class User {

    public final List<Integer> values = new ArrayList<>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> filterFunction, Predicate<Integer> predicate) {
        return filterFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}