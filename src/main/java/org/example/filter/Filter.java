package org.example.filter;

import java.util.List;
import java.util.function.Predicate;

/**
 * Parent class for filters.
 */
public class Filter {
    /**
     * Ahoj
     */
    protected Predicate<Integer> predicate;
    public Filter() {
        predicate = i -> i == i;
    }
    public List<Integer> filter(List<Integer> input) {
        return input.stream().filter(i -> predicate.test(i)).toList();
    }
}
