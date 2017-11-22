package ch.epam.accumulator.collector;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntPredicate;

public class NumberAccumulator implements BiConsumer<BigInteger, BigInteger> {

    private static final IntPredicate VALID_NUMBER = (n) -> n > -1;
    static NumberAccumulator of() {
        return new NumberAccumulator();
    }
    private final List<BigInteger> invalid;
    private NumberAccumulator() {
        this.invalid = new ArrayList<>();
    }
    private BigInteger sum = BigInteger.ZERO;

    @Override
    public void accept(BigInteger l, BigInteger r) {
        if (VALID_NUMBER.test(r.intValue())) {
            sum = sum.add(r);
        } else {
            invalid.add(r);
        }
    }

    public boolean isValid() {
        return invalid.isEmpty();
    }

    public BigInteger getSum() {
        return sum;
    }

    public List<BigInteger> getInvalid() {
        return invalid;
    }
}
