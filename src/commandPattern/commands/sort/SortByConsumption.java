package commandPattern.commands.sort;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class SortByConsumption extends Command {

    public SortByConsumption(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("SortByConsumption command");
        airplanes.sort((o1, o2) -> (o1.consumption <= o2.consumption) ? 1 : -1);
        return true;
    }
}
