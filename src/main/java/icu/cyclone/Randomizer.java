package icu.cyclone;

import icu.cyclone.command.CommandExecutor;
import icu.cyclone.exception.RandomizerEndOfRangeException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public class Randomizer {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 500;
    private static final String MESSAGE_MIN_VALUE = "Input min value:";
    private static final String MESSAGE_MAX_VALUE = "Input max value:";

    private int min;
    private int max;
    private boolean inactive;
    private List<Integer> values;

    public Randomizer() {
        init();
    }

    private void init() {
        min = CliUtils.readInt(MIN_RANGE, MAX_RANGE, MESSAGE_MIN_VALUE);
        max = CliUtils.readInt(min, MAX_RANGE, MESSAGE_MAX_VALUE);
        fillValues();
    }

    private void fillValues() {
        values = IntStream.range(min, max + 1)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void runCLI() {
        while (!inactive) {
            Operation operation = CliUtils.askOperation();
            CommandExecutor.execute(operation, this);
        }
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public int generateNext() {
        if (values.isEmpty()) {
            throw new RandomizerEndOfRangeException();
        }

        Random random = new Random();
        int index = random.nextInt(values.size());

        int value = values.get(index);
        values.remove(index);
        return value;
    }
}
