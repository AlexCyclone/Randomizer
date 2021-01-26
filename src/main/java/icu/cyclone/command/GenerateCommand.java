package icu.cyclone.command;

import icu.cyclone.CliUtils;
import icu.cyclone.Randomizer;
import icu.cyclone.exception.RandomizerEndOfRangeException;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public class GenerateCommand implements Command {
    private static final String ERROR_MESSAGE = "The list of possible values is exhausted";

    public void execute(Randomizer randomizer) {
        try {
            CliUtils.printMessage(randomizer.generateNext());
        } catch (RandomizerEndOfRangeException ignored) {
            CliUtils.printMessage(ERROR_MESSAGE);
        }
    }
}
