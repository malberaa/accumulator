package ch.epam.accumulator;

import ch.epam.accumulator.exceptions.InvalidNumberException;
import ch.epam.accumulator.exceptions.NegativeNumberException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccumulatorTest {

    private Accumulator accumulator = new Accumulator();

    @Test
    public void add_1a() throws Exception {
        assertEquals(0, accumulator.add(""));
    }

    @Test
    public void add_1b() throws Exception {
        assertEquals(6, accumulator.add("1,2,3"));
    }

    @Test
    public void add_2() throws Exception {
        assertEquals(10, accumulator.add("1,2,3,4"));
    }

    @Test
    public void add_3a() throws Exception {
        assertEquals(6, accumulator.add("1\n2,3"));
    }

    @Test(expected = InvalidNumberException.class)
    public void add_3b() throws Exception {
        assertEquals(6, accumulator.add("1,\n"));
    }

    @Test
    public void add_4a() throws Exception {
        assertEquals(3, accumulator.add("//;\n1;2"));
    }

    @Test
    public void add_4b() throws Exception {
        assertEquals(10, accumulator.add("1,2,3,4"));
        assertEquals(3, accumulator.add("//;\n1;2"));
    }


    @Test(expected = NegativeNumberException.class)
    public void add_5a() throws Exception {
        assertEquals(10, accumulator.add("-1,2,-3,4"));
    }

    @Test
    public void add_6() throws Exception {
        assertEquals(7, accumulator.add("1001,1,2,4"));
    }

    @Test
    public void add_7() throws Exception {
        assertEquals(6, accumulator.add("//%%%\n1%%%2%%%3"));
    }

    @Test
    public void add_8() throws Exception {
        assertEquals(6, accumulator.add("//,|;\n1,2;3"));
        assertEquals(6, accumulator.add("//;;;|,,\n1,,2;;;3"));
    }
}