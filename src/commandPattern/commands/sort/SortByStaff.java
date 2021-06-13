package commandPattern.commands.sort;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class SortByStaff extends Command {


    public SortByStaff(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("SortByStaff command");
        airplanes.sort((o1, o2) -> (o1.staff <= o2.staff) ? 1 : -1);
        return true;
    }
}
