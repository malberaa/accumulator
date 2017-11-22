package ch.epam.accumulator;

import ch.epam.accumulator.collector.NumberCollector;
import ch.epam.accumulator.mapper.String2Int;
import ch.epam.accumulator.separator.NumberSeparator;

class Accumulator {

    public int add(String numbers) {
        return NumberSeparator
                .of()
                .apply(numbers)
                .stream()
                .map(String2Int.of())
                .collect(NumberCollector.of());
    }


}
