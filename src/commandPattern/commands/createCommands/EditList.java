package commandPattern.commands.createCommands;

import airplanes.Airplane;
import commandPattern.programMenu.CreateMenu;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class EditList extends Command {
    public EditList(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("Edit command");
        CreateMenu createMenu = new CreateMenu(airplanes);
        createMenu.fillListConsole();
        return true;
    }
}
