package ch.epam.accumulator;

import ch.epam.accumulator.exceptions.NegativeNumber;
import ch.epam.accumulator.mapper.String2Int;
import ch.epam.accumulator.separator.NumberSeparator;
import ch.epam.accumulator.filter.NumberFilter;

class Accumulator {

    public int add(String numbers) {
        NumberFilter filter = NumberFilter.of();
        int sum = NumberSeparator.of().apply(numbers).stream().mapToInt(String2Int.of()).filter(filter).sum();
        if (filter.isValid()) {
            return sum;
        } else {
            throw new NegativeNumber(filter);
        }
    }


}
