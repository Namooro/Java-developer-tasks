package task4;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * MemoryLeakTest.
 */
public class MemoryLeakTest {

    /**
     * Memory leaks:
     * 1) unclosed connection
     * 2) huge collections
     * 3) duplicate strings
     */
    @Ignore
    @Test(expected = OutOfMemoryError.class)
    public void testOutOfMemory()
            throws IOException {

        List<String> stringPool = new LinkedList<>();
        File file = new File(getClass().getClassLoader().getResource("file-for-memory-leak.txt").getFile());

        while (true) {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                stringPool.add(line);
            }
        }
    }
}
