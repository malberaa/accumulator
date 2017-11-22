package ch.epam.accumulator.separator;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DefaultSeparatorStrategyTest {

    private static final String PAYLOAD = "1,2,3";
    private SeparatorStrategy separator = SeparatorStrategy.of(PAYLOAD);

    @Test
    public void separate() throws Exception {
        assertEquals(Arrays.asList("1","2","3"), separator.separate());
    }

}