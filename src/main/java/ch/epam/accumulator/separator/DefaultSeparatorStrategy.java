package ch.epam.accumulator.separator;

import java.util.Arrays;
import java.util.List;

public class DefaultSeparatorStrategy implements SeparatorStrategy {

    private static final String DEFAULT_DELIMITER = ",";
    private final String value;
    DefaultSeparatorStrategy(String value) {
        this.value = value;
    }

    @Override
    public List<String> separate() {
        return Arrays.asList(value.replaceAll(System.lineSeparator(), DEFAULT_DELIMITER).split(DEFAULT_DELIMITER));
    }
}
