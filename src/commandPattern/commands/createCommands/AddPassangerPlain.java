package commandPattern.commands.createCommands;

import airplanes.Airplane;
import airplanes.PassangerPlaine;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class AddPassangerPlain extends Command {

    public AddPassangerPlain(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        String name = parameters[1];
        String model = parameters[2];
        int lenght = Integer.parseInt(parameters[3]);
        int staff = Integer.parseInt(parameters[4]);
        int consuption = Integer.parseInt(parameters[5]);
        int numSeats = Integer.parseInt(parameters[6]);
        Main.logger.info("AddPassangerPlain command");
        Main.logger.debug("Parameters: " + lenght + " " + staff + " " + consuption + " " + numSeats);
        Airplane passagerAirplane = new PassangerPlaine(name,model,lenght,staff,consuption,numSeats);
        return airplanes.add(passagerAirplane);
    }
}
