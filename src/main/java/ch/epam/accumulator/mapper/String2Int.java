package ch.epam.accumulator.mapper;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.Predicate;

public class String2Int implements Function<String, BigInteger> {

    private static final Predicate<String> INVALID_STRING = ""::equals;
    private static final Predicate<BigInteger> INVALID_NUMBER = (n) -> n.intValue() > 1000;
    public static String2Int of() {
        return new String2Int();
    }
    private String2Int (){}

    @Override
    public BigInteger apply(String value) {
        if (INVALID_STRING.test(value)) {
            return BigInteger.ZERO;
        } else {
            BigInteger result = new BigInteger(value);
            return INVALID_NUMBER.test(result) ? BigInteger.ZERO : result;
        }
    }
}
