package icu.cyclone.command;

import icu.cyclone.CliUtils;
import icu.cyclone.Randomizer;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public class ExitCommand implements Command {
    private static final String MESSAGE_EXIT_QUESTION = "Are you sure that you want to quit the app? (Y/N)";
    private static final String APPROVE_STRING = "Y";
    private static final String MESSAGE_BYE = "Application is inactive.";

    public void execute(Randomizer randomizer) {
        CliUtils.printMessage(MESSAGE_EXIT_QUESTION);
        if (APPROVE_STRING.equalsIgnoreCase(CliUtils.readString())) {
            randomizer.setInactive(true);
            CliUtils.printMessage(MESSAGE_BYE);
        }
    }
}
