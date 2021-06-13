package commandPattern.commands.createCommands;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class DeleteAirplane extends Command {

    public DeleteAirplane(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        int i;
        int id = Integer.parseInt(parameters[1]);
        Main.logger.info("DeleteAirplane command");
        Main.logger.debug("Parameters: " + id);
        for (i = 0; i < airplanes.size() ; i++) {
            if(airplanes.get(i).id == id)
                break;
        }
        if(i == airplanes.size())
            throw new RuntimeException("Неправильний ід");
        airplanes.remove(i);
        return true;
    }
}
