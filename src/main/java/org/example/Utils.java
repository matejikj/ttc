package org.example;

import org.example.filter.EvenFilter;
import org.example.filter.Filter;
import org.example.filter.OddFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Integer> readFromConsole(String argument) {
        int n = Integer.parseInt(argument);
        LinkedList<Integer> result = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        String line;
        while(input.hasNextLine() && !( line = input.nextLine() ).equals( "" ))
        {
            String[] tokens = line.split(" ");
            result.add(Integer.parseInt(tokens[0]));
        }
        input.close();
        return result;
    }

    public static List<Integer> readFromFile(String input) throws FileNotFoundException {
        try {
            Scanner scanner = new Scanner(new File(input));
            LinkedList<Integer> result = new LinkedList<>();
            while(scanner.hasNextInt())
            {
                result.add(scanner.nextInt());
            }
            return result;
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    public static List<Integer> readInput(String input) throws FileNotFoundException {
        if (Utils.isInteger(input)) {
            return readFromConsole(input);
        }
        else {
            return readFromFile(input);
        }
    }

    public static Filter assignFilter(int length) {
        if (length % 2 == 0) {
            return new EvenFilter();
        } else {
            return new OddFilter();
        }
    }

    public static void writeToFile(String name, List<Integer> result) {
        try {
            FileWriter myWriter = new FileWriter(name);
            result.forEach(i -> {
                try {
                    myWriter.write(i.toString());
                    myWriter.write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
