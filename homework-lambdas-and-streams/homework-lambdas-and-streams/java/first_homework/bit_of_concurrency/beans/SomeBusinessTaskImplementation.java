package first_homework.bit_of_concurrency.beans;

import java.time.LocalDateTime;

public class SomeBusinessTaskImplementation implements SomeBusinessTask {
    @Override
    public void someLogic() {
        System.out.println("Time now is: " + LocalDateTime.now());
    }
}