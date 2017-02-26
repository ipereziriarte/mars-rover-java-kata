package com.blokura.data;

import com.blokura.model.Rover;

public interface OutPut {

    /**
     * Export the result of running the commands on the rover to whatever output we want
     *
     * @param rover the rover to consume
     */
    void export(Rover rover);
}
