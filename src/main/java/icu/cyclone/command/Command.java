package icu.cyclone.command;

import icu.cyclone.Randomizer;

/**
 * @author Aleksey Babanin
 * @since 2021/01/26
 */
public interface Command {
    void execute(Randomizer randomizer);
}
