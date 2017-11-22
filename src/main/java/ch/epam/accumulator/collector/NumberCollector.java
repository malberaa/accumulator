package ch.epam.accumulator.collector;

import ch.epam.accumulator.exceptions.NegativeNumberException;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;


public class NumberCollector implements Collector<BigInteger, BigInteger, Integer>{

    private static final Supplier<BigInteger> SUPPLIER = () -> BigInteger.ZERO;
    public static NumberCollector of() {
        return new NumberCollector();
    }
    private final NumberAccumulator accumulator;
    private NumberCollector() {
        this.accumulator = NumberAccumulator.of();
    }

    @Override
    public Supplier<BigInteger> supplier() {
        return SUPPLIER;
    }

    @Override
    public BiConsumer<BigInteger, BigInteger> accumulator() {
        return accumulator;
    }

    @Override
    public BinaryOperator<BigInteger> combiner() {
        return BigInteger::add;
    }

    @Override
    public Function<BigInteger, Integer> finisher() {
        return (n) -> {
            if (accumulator.isValid()) {
                return accumulator.getSum().intValue();
            }
            throw new NegativeNumberException(accumulator.getInvalid());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
