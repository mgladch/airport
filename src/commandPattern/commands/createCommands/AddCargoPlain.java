package commandPattern.commands.createCommands;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class AddCargoPlain extends Command {
    public AddCargoPlain(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        String name = parameters[1];
        String model = parameters[2];
        int length = Integer.parseInt(parameters[3]);
        int staff = Integer.parseInt(parameters[4]);
        int consumption = Integer.parseInt(parameters[5]);
        int capacity = Integer.parseInt(parameters[6]);
        Main.logger.info("AddCargoPlain command");
        Main.logger.debug("Parameters: " + length + " " + staff + " " + consumption + " " + capacity);
        Airplane cargoPlain = new CargoPlaine(name,model,length,staff,consumption,capacity);
        return airplanes.add(cargoPlain);
    }
}
