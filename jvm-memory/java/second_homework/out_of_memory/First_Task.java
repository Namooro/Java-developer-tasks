package second_homework.out_of_memory;

import java.util.ArrayList;
import java.util.List;

public class First_Task {
    public static void main(String... args) {

        //throws an outOfMemoryError: Java heap space exception
        List<Integer> crashedList = new ArrayList<>();
       /* while (true)
            crashedList.add(1);*/

        //throws an outOfMemoryError: Metaspace
        //-XX:MetaspaceSize=1M -XX:MaxMetaspaceSize=10M
        ClassLoader classLoader = First_Task.class.getClassLoader();
        ArrayList strangeList = new ArrayList();
        try {
            while (true) {
                Class aClass = classLoader.loadClass("second_homework.out_of_memory.First_Task");
                try {
                    strangeList.add(aClass.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                //  System.out.println("aClass.getName() = " + aClass.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //StackOverFlowError with recursion
        recursion();
        //one way to throw StackOverFlowError without recursion
        throw new StackOverflowError();
    }

    public static void recursion() {
        recursion();
    }
}
