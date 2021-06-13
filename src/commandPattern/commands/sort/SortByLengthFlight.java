package commandPattern.commands.sort;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class SortByLengthFlight extends Command {

    public SortByLengthFlight(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("SortByLengthFlight command");
        airplanes.sort((o1, o2) -> (o1.lengthFlight <= o2.lengthFlight) ? 1 : -1);
        return true;
    }
}
