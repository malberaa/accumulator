package ch.epam.accumulator.separator;

import ch.epam.accumulator.exceptions.InvalidNumber;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class NumberSeparator implements Function<String, List<String>> {

    private static final Predicate<String> INVALID_STRING = (s) -> s.startsWith(System.lineSeparator()) || s.endsWith(System.lineSeparator());
    private NumberSeparator(){}

    public static NumberSeparator of() {
        return new NumberSeparator();
    }

    @Override
    public List<String> apply(String s) {
        if (INVALID_STRING.test(s)) {
            throw new InvalidNumber();
        } else {
            return separateNumbers(s);
        }
    }

    List<String> separateNumbers(String s) {
        return SeparatorStrategy.of(s).separate();
    }

}
