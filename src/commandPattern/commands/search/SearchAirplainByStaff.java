package commandPattern.commands.search;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class SearchAirplainByStaff extends Command {
    int minNumStaff;
    int maxNumStaff;

    public SearchAirplainByStaff(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        minNumStaff = Integer.parseInt(parameters[1]);
        maxNumStaff = Integer.parseInt(parameters[2]);
        Main.logger.info("SearchAirplainByStaff command");
        Main.logger.debug("Parameters: " + minNumStaff + " " + maxNumStaff);
        for (Airplane airplane: airplanes) {
            if(airplane.staff >= minNumStaff && airplane.staff <= maxNumStaff)
                System.out.println(airplane);
        }
        return true;
    }
}
