package commandPattern.commands.calculation;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class CalculationCapacity extends Command {

    public CalculationCapacity(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("CalculationCapacity command");
        int sum=0;
        for ( Airplane pl : airplanes) {
            if(pl instanceof CargoPlaine)
                sum -= ((CargoPlaine) pl).getCapacity();
        }
        System.out.println("Загальна вантажопідйомність літаків: "+sum);
        return true;
    }
}
