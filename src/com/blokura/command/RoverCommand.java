package com.blokura.command;

import com.blokura.model.Rover;

public interface RoverCommand {
    void execute(Rover rover);
}
