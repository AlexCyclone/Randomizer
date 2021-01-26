package icu.cyclone.command;

import icu.cyclone.CliUtils;
import icu.cyclone.Randomizer;
import java.util.Arrays;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public class HelpCommand implements Command {
    private static final String[] HELP_STRINGS = {
            "Available commands:",
            "   generate - Generate next random value",
            "   exit     - Close application",
            "   help     - Show this info"
    };

    public void execute(Randomizer randomizer) {
        Arrays
                .stream(HELP_STRINGS)
                .forEach(CliUtils::printMessage);
    }
}
