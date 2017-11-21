package ch.epam.accumulator.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class NumberFilter implements IntPredicate {

    private static final IntPredicate VALID_NUMBER = (n) -> n > -1;
    private final List<Integer> invalid;
    private NumberFilter() {
        this.invalid = new ArrayList<>();
    }
    public static NumberFilter of() {
        return new NumberFilter();
    }

    public List<Integer> getInvalid() {
        return invalid;
    }

    @Override
    public boolean test(int value) {
        boolean result = VALID_NUMBER.test(value);
        if (!result) {
            invalid.add(value);
        }
        return result;
    }

    public boolean isValid() {
        return invalid.isEmpty();
    }
}
