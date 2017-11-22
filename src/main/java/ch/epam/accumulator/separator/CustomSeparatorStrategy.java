package ch.epam.accumulator.separator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomSeparatorStrategy implements SeparatorStrategy {

    private static final String MULTIPLE_DELIMITER_SEPARATOR = "|";
    private static final Predicate<String> MULTIPLE_DELIMITER = (s) -> s.contains(MULTIPLE_DELIMITER_SEPARATOR);
    private final String value;

    CustomSeparatorStrategy(String value) {
        this.value = value;
    }

    @Override
    public List<String> separate() {
        String payload = getPayload();
        List<String> delimiters = getDelimiters();
        payload = payload.replaceAll(System.lineSeparator(), delimiters.get(0));
        return delimiters.size() > 1 ?
                numbersFromMultiple(delimiters, payload) :
                numbersFromSingle(delimiters.get(0), Collections.singletonList(payload));
    }

    private List<String> numbersFromMultiple(List<String> delimiters, String payload) {
        List<String> result = Collections.singletonList(payload);
        for (String delimiter: delimiters) {
            result = numbersFromSingle(delimiter, result);
        }
        return result;
    }

    List<String> numbersFromSingle(String delimiter, List<String> rawNumbers) {
        return rawNumbers
                .stream()
                .map(s -> s.split(delimiter))
                .flatMap(Arrays::stream)
                .filter(s -> !"".equals(s))
                .collect(Collectors.toList());
    }


    String getPayload() {
        return value.substring(value.indexOf(System.lineSeparator()) + 1, value.length());
    }

    List<String> getDelimiters() {
        String raw = getDelimiterRaw();
        if (MULTIPLE_DELIMITER.test(raw)) {
            return Arrays.asList(raw.split(MULTIPLE_DELIMITER_SEPARATOR));
        } else {
            return Collections.singletonList(raw);
        }
    }

    String getDelimiterRaw() {
        String result = value.replaceFirst(SeparatorStrategy.CUSTOM_DELIMITER_PREFIX, "");
        result = result.substring(0, result.indexOf(System.lineSeparator()));
        return result;
    }
}
