package src.multimodule;

import multimodel.SimpleService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTests {
    @Test
    public void output() {
        assertEquals("exampleString", new SimpleService().getStringFromDataBase());
    }
}
