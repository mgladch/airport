package commandPattern.commands.search;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class SearchAirplaneByConsumption extends Command {
    int minConsumption;
    int maxConsumption;

    public SearchAirplaneByConsumption(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        minConsumption = Integer.parseInt(parameters[1]);
        maxConsumption = Integer.parseInt(parameters[2]);
        Main.logger.info("SearchAirplainByStaff command");
        Main.logger.debug("Parameters: " + minConsumption + " " + maxConsumption);
        for (Airplane airplane: airplanes) {
            if(airplane.consumption >= minConsumption && airplane.consumption <= maxConsumption)
                System.out.println(airplane);
        }
        return true;
    }
}
