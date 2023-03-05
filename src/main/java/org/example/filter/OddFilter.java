package org.example.filter;

/**
 * Class for filter odd numbers
 */
public class OddFilter extends Filter{
    /**
     * Initialize filter with predicate for odd numbers
     */
    public OddFilter() {
        predicate = i -> i % 2 == 1;
    }
}
