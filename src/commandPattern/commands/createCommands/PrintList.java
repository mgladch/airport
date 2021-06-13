package commandPattern.commands.createCommands;

import airplanes.Airplane;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class PrintList extends Command {

    public PrintList(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("PrintList command");
        if(airplanes.isEmpty()) {
            System.out.println("Список літаків порожній");
            return true;
        }
        for (Airplane airplane: airplanes) {
            System.out.println(airplane);
        }
        return true;
    }
}
