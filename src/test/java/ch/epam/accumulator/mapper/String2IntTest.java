package ch.epam.accumulator.mapper;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

import static org.junit.Assert.*;

public class String2IntTest {

    private ToIntFunction<String> function = String2Int.of();

    @Test
    public void apply_invalidString() throws Exception {
        assertEquals(0, function.applyAsInt(""));
    }

    @Test
    public void apply_bigNumber() throws Exception {
        assertEquals(0, function.applyAsInt("1001"));
    }

    @Test
    public void apply_validNumber() throws Exception {
        assertEquals(123, function.applyAsInt("123"));
    }

}