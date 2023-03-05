package org.example;

import org.example.filter.Filter;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Integer> input = Utils.readInput(args[0]);
            Filter filter = Utils.assignFilter(input.size());
            List<Integer> result = filter.filter(input);
            if (args.length > 1) {
                Utils.writeToFile(args[1], result);
            } else {
                result.forEach(i -> System.out.println(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
        } catch (RuntimeException e) {
            System.out.println("Any numbers on input.");
        }
    }
}