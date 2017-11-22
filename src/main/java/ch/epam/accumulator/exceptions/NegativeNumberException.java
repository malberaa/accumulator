package ch.epam.accumulator.exceptions;

import java.math.BigInteger;
import java.util.List;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException(List<BigInteger> numbers) {
        super(String.format("Negatives not allowed: %s", numbers));
    }
}
