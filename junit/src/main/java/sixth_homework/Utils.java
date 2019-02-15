package sixth_homework;

import java.text.Normalizer;

public class Utils {
    static String concatenateWords(String first, String second) {
        return first.concat(second);
    }

    static long computeFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num must be non-negative");
        }
        long factorial = 1;
        for (int i = 1; i < num; ++i) {
            factorial *= i;
        }
        return factorial;
    }

    static String normalizeWords(String word) {
        return Normalizer.normalize(word, Normalizer.Form.NFD);
    }
}
