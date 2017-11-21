package ch.epam.accumulator.separator;

import java.util.Arrays;
import java.util.List;

public class CustomSeparatorStrategy implements SeparatorStrategy {

    private final String value;

    CustomSeparatorStrategy(String value) {
        this.value = value;
    }

    @Override
    public List<String> separate() {
        String delimiter = value.substring(2,3);
        String payload = value.substring(3, value.length());
        return Arrays.asList(payload.replaceAll(System.lineSeparator(), delimiter).split(delimiter));
    }
}
