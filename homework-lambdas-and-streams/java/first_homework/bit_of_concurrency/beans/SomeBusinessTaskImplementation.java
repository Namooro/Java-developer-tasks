package first_homework.bit_of_concurrency.beans;

import java.time.LocalDateTime;
import java.util.Random;

public class SomeBusinessTaskImplementation implements SomeBusinessTask {
    @Override
    public void someLogic() {
        System.out.println("Time now is: " + LocalDateTime.now());
    }

    @Override
    public void someOtherLogic() {
        System.out.println("Entirely different logic:" + new Random().nextInt());
    }
}