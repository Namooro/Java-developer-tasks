package second_homework.out_of_memory;

import java.util.ArrayList;
import java.util.List;

public class First_Task {
    public static void main(String... args) {
        //throws an outOfMemoryError: Java heap space exception
        List<Integer> crashedList = new ArrayList<>();
        while (true)
            crashedList.add(1);



    }
}
