package ch.epam.accumulator.separator;

import java.util.List;
import java.util.function.Predicate;

public interface SeparatorStrategy {

    List<String> separate();

    String CUSTOM_DELIMITER_PREFIX = "//";
    Predicate<String> CUSTOM_DELIMITER_CHECK = (s) -> s.startsWith(CUSTOM_DELIMITER_PREFIX);

    static SeparatorStrategy of(String value) {
        return CUSTOM_DELIMITER_CHECK.test(value) ? new CustomSeparatorStrategy(value) : new DefaultSeparatorStrategy(value);
    }
}
