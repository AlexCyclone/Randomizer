package icu.cyclone.command;

import icu.cyclone.Operation;
import icu.cyclone.Randomizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public class CommandExecutor {
    private static final Map<Operation, Command> COMMAND_MAP = new HashMap<>(3, 1);

    static {
        COMMAND_MAP.put(Operation.GENERATE, new GenerateCommand());
        COMMAND_MAP.put(Operation.HELP, new HelpCommand());
        COMMAND_MAP.put(Operation.EXIT, new ExitCommand());
    }

    public static final void execute(Operation operation, Randomizer randomizer) {
        COMMAND_MAP.get(operation).execute(randomizer);
    }
}
