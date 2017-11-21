package ch.epam.accumulator.mapper;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class String2Int implements ToIntFunction<String> {

    private static final Predicate<String> INVALID_STRING = ""::equals;
    private static final Predicate<Integer> INVALID_NUMBER = (n) -> n > 1000;
    private String2Int (){}
    public static String2Int of() {
        return new String2Int();
    }

    @Override
    public int applyAsInt(String value) {
        if (INVALID_STRING.test(value)) {
            return 0;
        } else {
            int result = Integer.parseInt(value);
            return INVALID_NUMBER.test(result) ? 0 : result;
        }
    }
}
