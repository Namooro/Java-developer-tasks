package first_homework.custom_functional_interface;

import java.util.Arrays;
import java.util.Collections;

public class Fourth_Task {
    public static void main(String[] args) {

        ThreeFunction<Integer, Integer, Integer> weirdCalc = (x, y, z) -> x * y + z;
        System.out.println(weirdCalc.result(5, 6, 2));

        ThreeFunction<Integer, Integer, Integer> biggestNumber = (x, y, z) ->
                Collections.max(Arrays.asList(x, y, z));
        System.out.println(biggestNumber.result(10, 50, 1000));
    }
}

@FunctionalInterface
interface ThreeFunction<T, R, U> {
    Integer result(Integer T, Integer R, Integer U);
}
