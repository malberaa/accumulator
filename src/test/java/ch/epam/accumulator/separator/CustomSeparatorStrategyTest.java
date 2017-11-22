package ch.epam.accumulator.separator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class CustomSeparatorStrategyTest {

    private static final String DELIMITERS = "//%%|##\n";
    private static final String PAYLOAD = "1##2%%3";
    private CustomSeparatorStrategy separator = new CustomSeparatorStrategy(DELIMITERS + PAYLOAD);

    @Test
    public void separate() throws Exception {
        assertEquals(Arrays.asList("1", "2", "3"), separator.separate());
    }

    @Test
    public void numbersFromSingle() throws Exception {
        String delimiter = ";";
        String payload = "1;2;3";
        assertEquals(Arrays.asList("1", "2", "3"), separator.numbersFromSingle(delimiter, Collections.singletonList(payload)));
    }

    @Test
    public void getPayload() throws Exception {
        assertEquals(PAYLOAD, separator.getPayload());
    }

    @Test
    public void getDelimiters() throws Exception {
        assertEquals(Arrays.asList("##", "%%"), separator.getDelimiters());
    }

    @Test
    public void getDelimiterRaw() throws Exception {
        assertEquals(DELIMITERS, separator.getDelimiterRaw());
    }

}