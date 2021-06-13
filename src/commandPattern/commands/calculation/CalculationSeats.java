package commandPattern.commands.calculation;

import airplanes.Airplane;
import airplanes.PassangerPlaine;
import commandPattern.commands.Command;
import start.Main;

import java.util.List;

public class CalculationSeats extends Command {

    public CalculationSeats(List<Airplane> airplanes) {
        super(airplanes);
    }

    @Override
    public boolean execute(String[] parameters) throws Exception {
        Main.logger.info("CalculationSeats command");
        int sum=0;
        for ( Airplane pl : airplanes) {
            if(pl instanceof PassangerPlaine)
                sum += ((PassangerPlaine) pl).getNumSeats();
        }
        System.out.println("Загальна місткість літаків: "+sum);
        return true;
    }
}
