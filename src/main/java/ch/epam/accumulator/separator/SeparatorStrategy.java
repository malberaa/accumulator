package ch.epam.accumulator.separator;

import java.util.List;
import java.util.function.Predicate;

public interface SeparatorStrategy {

    List<String> separate();

    Predicate<String> CUSTOM_DELIMITER = (s) -> s.startsWith("//");

    static SeparatorStrategy of(String value) {
        return CUSTOM_DELIMITER.test(value) ? new CustomSeparatorStrategy(value) : new DefaultSeparatorStrategy(value);
    }
}
