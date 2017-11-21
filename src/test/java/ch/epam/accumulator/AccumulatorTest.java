package ch.epam.accumulator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccumulatorTest {

    @Test
    public void add() throws Exception {
        Accumulator accumulator = new Accumulator();
        assertEquals(0, accumulator.add(""));
        assertEquals(6, accumulator.add("1,2,3"));
        assertEquals(3, accumulator.add("1,2,1001"));
//        assertEquals(6, accumulator.add("-1,2,-3"));
        assertEquals(6, accumulator.add("1\n2,3"));
        assertEquals(3, accumulator.add("//;\n1;2"));
    }

}