package ch.epam.accumulator.exceptions;

import ch.epam.accumulator.filter.NumberFilter;

public class NegativeNumber extends RuntimeException {

    public NegativeNumber(NumberFilter filter) {
        super(String.format("Negatives not allowed: %s", filter.getInvalid()));
    }
}
