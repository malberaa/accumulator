package ch.epam.accumulator.separator;

import ch.epam.accumulator.exceptions.InvalidNumberException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumberSeparatorTest {

    private NumberSeparator separator = NumberSeparator.of();

    @Test
    public void apply_validNumber() throws Exception {
        assertEquals(Arrays.asList("1", "2"), separator.apply("1,2"));
    }

    @Test(expected = InvalidNumberException.class)
    public void apply_delimiterLast() throws Exception {
        separator.apply("1,\n");
    }

    @Test(expected = InvalidNumberException.class)
    public void apply_delimiterFirst() throws Exception {
        separator.apply("\n,1");
    }


}