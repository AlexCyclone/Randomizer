package icu.cyclone;

import icu.cyclone.command.CommandExecutor;
import icu.cyclone.exception.RandomizerEndOfRangeException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
    private Set<Integer> values;
    private int maxValuesCount;

    public Randomizer() {
        init();
    }

    private void init() {
        min = CliUtils.readInt(MIN_RANGE, MAX_RANGE, MESSAGE_MIN_VALUE);
        max = CliUtils.readInt(min, MAX_RANGE, MESSAGE_MAX_VALUE);
        maxValuesCount = max - min + 1;
        values = new HashSet<>(maxValuesCount, 1);
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
        if (values.size() >= maxValuesCount) {
            throw new RandomizerEndOfRangeException();
        }

        Random random = new Random();
        Integer value = null;

        while (value == null) {
            value = min + random.nextInt(maxValuesCount);
            if (values.contains(value)) {
                value = null;
            } else {
                values.add(value);
            }
        }
        return value;
    }
}
