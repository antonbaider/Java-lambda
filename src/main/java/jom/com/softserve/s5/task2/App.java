package jom.com.softserve.s5.task2;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    public static Consumer<double[]> cons = array ->
            Arrays.setAll(array, i -> array[i] > 2 ? array[i] * 0.8 : array[i] * 0.9);

    public static double[] getChanged(double[] initialArray, Consumer<double[]> cons) {
        double[] newArray = initialArray.clone();
        cons.accept(newArray);
        return newArray;
    }
}