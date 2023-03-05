package org.example.filter;

/**
 * Class for filter even numbers
 */
public class EvenFilter extends Filter{
    /**
     * Initialize filter with predicate for even numbers
     */
    public EvenFilter() {
        predicate = i -> i % 2 == 0;
    }
}
