package com.pluralsight.calcengine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            processFile(reader);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: " + args[0]);
        }
        catch (IOException ex) {
            System.out.println("Error reading file - " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error processing file - " + ex.getMessage());
        }
    }

    private static void processFile(BufferedReader reader) throws IOException {
        String inputLine = null;
        while((inputLine = reader.readLine()) != null)
            try {
                performOperation(inputLine);
            }
        catch (InvalidStatementException ex) {
                System.out.println("Error invalid statement - " + ex.getMessage() + "\nError on input line: " + inputLine);
                writeInvalidStatementExceptionToLog(ex, inputLine);

        }
    }

    private static void performOperation(String inputLine) throws InvalidStatementException {
        try {
            String[] parts = inputLine.split(" ");
            if (parts.length != 3)
                throw new InvalidStatementException("Statement must have 3 parts...");
            MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
            int leftVal = valueFromWord(parts[1]);
            int rightVal = valueFromWord(parts[2]);

            int result = execute(operation, leftVal, rightVal);

            System.out.println(inputLine + " = " + result);
        }
        catch (InvalidStatementException ex) {
            throw ex;
        }
        catch (Exception ex) {
            throw new InvalidStatementException("Error processing statement", ex);
        }
    }

    static int execute(MathOperation operation, int leftVal, int rightVal) {
        int result = 0;
        switch (operation) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                if (rightVal == 0) {
                    throw new IllegalArgumentException("Zero not permitted for rightVal argument during division.");
                }
                result = leftVal / rightVal;
                break;
        }
        return result;
    }

    static int valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        int value = -1;
        for(int index = 0; index < numberWords.length; index++) {
            if(word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if(value == -1)
            value = Integer.parseInt(word);

        return value;
    }

    static void writeInvalidStatementExceptionToLog(InvalidStatementException ex, String inputLine) {
        System.err.println("\n");
        System.err.println("*********************************");
        System.err.println("Information written to log system");
        System.err.println("*********************************");

        System.err.println("Error invalid statement - " + ex.getMessage() + "\nError on input line: " + inputLine);
        if (ex.getCause() != null) {
            System.err.println(" caused by " + ex.getCause());
        }
        ex.printStackTrace(System.err);

    }

}
