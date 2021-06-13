package commandPattern.commands;

import airplanes.Airplane;

import java.util.List;

public abstract class Command {
    protected List<Airplane> airplanes;

    public Command(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public abstract boolean execute(String[] parameters) throws Exception;

}
