package ch.epam.accumulator.mapper;

import org.junit.Test;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

import static org.junit.Assert.*;

public class String2IntTest {

    private Function<String, BigInteger> function = String2Int.of();

    @Test
    public void apply_invalidString() throws Exception {
        assertEquals(0, function.apply("").intValue());
    }

    @Test
    public void apply_bigNumber() throws Exception {
        assertEquals(0, function.apply("1001").intValue());
    }

    @Test
    public void apply_validNumber() throws Exception {
        assertEquals(123, function.apply("123").intValue());
    }

}