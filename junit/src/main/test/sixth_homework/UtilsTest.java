package sixth_homework;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class UtilsTest {
    private String firstWord;
    private String secondWord;
    private String testNormalize;
    private static Logger logger;

    @Before
    public void before() {
        firstWord = "first";
        secondWord = "second";
        testNormalize = "\ufb03 schön";
        logger = Logger.getGlobal();
    }

    @Test
    public void concatenateWordsTest() {
        assertEquals(firstWord + secondWord, Utils.concatenateWords(firstWord, secondWord));
    }

    @Test(timeout = 1000)
    public void testComputeFactorial() {
        try {
            int randomNum = Math.abs(ThreadLocalRandom.current().nextInt());
            Utils.computeFactorial(randomNum);
        } catch (Exception thrown) {
            assertTrue(thrown instanceof InterruptedException);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testComputeFactorialException() {
        long num = Utils.computeFactorial(-5);
    }

    @Test
    @Ignore
    public void testNormalizeWord() {
        assertEquals("ﬃ schön", Utils.normalizeWords(testNormalize));
    }

    @AfterClass
    public static void after() {
        logger.log(Level.INFO, "all test completed");
    }
}
