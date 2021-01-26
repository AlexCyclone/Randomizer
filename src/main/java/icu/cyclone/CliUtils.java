package icu.cyclone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public class CliUtils {
    private static final String MESSAGE_INCORRECT_INTEGER_FORMAT = "Input correct integer number";
    private static final String MESSAGE_TRY_AGAIN = "Try again";
    private static final String MESSAGE_FORMAT_VALUE_BETWEEN = "The value must be between %d and %d (inclusive)";
    private static final String MESSAGE_INPUT_COMMAND = "Input command:";
    private static final String MESSAGE_INCORRECT_INPUT_COMMAND = "Incorrect input. Try again ([help] for available command)";

    public static void printMessage(Object message) {
        System.out.println(message);
    }

    public static String readString() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException ignored) {
        }
        return "";
    }

    public static Integer readInt() {
        String string = readString();
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException ignored) {
        }
        return null;
    }

    public static int readInt(int minValue, int maxValue, String startMessage) {
        printMessage(startMessage);
        while (true) {
            Integer input = readInt();
            if (input == null) {
                printMessage(MESSAGE_INCORRECT_INTEGER_FORMAT);
                printMessage(MESSAGE_TRY_AGAIN);
            } else if (input < minValue || input > maxValue) {
                printMessage(String.format(MESSAGE_FORMAT_VALUE_BETWEEN, minValue, maxValue));
                printMessage(MESSAGE_TRY_AGAIN);
            } else {
                return input;
            }
        }
    }

    public static Operation askOperation() {
        Operation operation = null;
        while (operation == null) {
            printMessage(MESSAGE_INPUT_COMMAND);
            String string = readString();
            try {
                operation = Operation.valueOf(string.toUpperCase());
            } catch (IllegalArgumentException ignore) {
                printMessage(MESSAGE_INCORRECT_INPUT_COMMAND);
            }
        }
        return operation;
    }
}
