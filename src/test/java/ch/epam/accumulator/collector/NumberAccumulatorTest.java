package ch.epam.accumulator.collector;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class NumberAccumulatorTest {

    private NumberAccumulator accumulator = NumberAccumulator.of();

    @Test
    public void accept_validNumber() throws Exception {
        accumulator.accept(BigInteger.ZERO, BigInteger.ONE);
        assertTrue(accumulator.isValid());
        assertEquals(BigInteger.ONE, accumulator.getSum());
    }

    @Test
    public void accept_invalidNumber() throws Exception {
        BigInteger negative = new BigInteger("-1");
        accumulator.accept(BigInteger.ZERO, negative);
        assertFalse(accumulator.isValid());
        assertEquals(negative, accumulator.getInvalid().get(0));
    }

}