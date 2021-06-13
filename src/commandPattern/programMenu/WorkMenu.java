package commandPattern.programMenu;

import airplanes.Airplane;
import commandPattern.commands.Command;
import commandPattern.commands.search.SearchAirplainByStaff;
import commandPattern.commands.search.SearchAirplaneByConsumption;
import commandPattern.commands.calculation.CalculationCapacity;
import commandPattern.commands.calculation.CalculationSeats;
import commandPattern.commands.createCommands.EditList;
import commandPattern.commands.createCommands.PrintList;
import commandPattern.commands.sort.SortByConsumption;
import commandPattern.commands.sort.SortByLengthFlight;
import commandPattern.commands.sort.SortByStaff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkMenu extends Menu{
    List<Airplane> airplanes;
    Map<String, Command> commandMap;

    public WorkMenu(List<Airplane> airplanes) {
        this.airplanes = airplanes;
        commandMap = new HashMap<>();
        commandMap.put("PrintList", new PrintList(airplanes));
        commandMap.put("SortByConsumption", new SortByConsumption(airplanes));
        commandMap.put("SortByLengthFlight", new SortByLengthFlight(airplanes));
        commandMap.put("SortByStaff", new SortByStaff(airplanes));
        commandMap.put("CalculationCapacity", new CalculationCapacity(airplanes));
        commandMap.put("CalculationSeats", new CalculationSeats(airplanes));
        commandMap.put("SearchAirplaneByStaff", new SearchAirplainByStaff(airplanes));
        commandMap.put("SearchAirplaneByConsumption", new SearchAirplaneByConsumption(airplanes));
        commandMap.put("EditList", new EditList(airplanes));
    }

    public void openMenu() throws Exception {
        String patameters[];
        Command command;
        while (true){
            printSeparator();
            System.out.println("Головне меню: \n" +
                    "PrintList - Видрукувати список літаків\n" +
                    "SortByConsumption - Сортування за спожитком пального\n" +
                    "SortByLengthFlight - Сортування за дальністю польоту\n" +
                    "SortByStaff - Сортування за кількістю обслуговуючого персоналу\n" +
                    "CalculationCapacity - Підрахунок вантажопідйомності всіх літаків\n" +
                    "CalculationSeats - Підрахунок всіх пасажирських місць у всіх літаках\n" +
                    "SearchAirplaneByStaff - Пошук по кількості працивників(введіть інтервал)\n" +
                    "SearchAirplaneByConsumption - Пошук по спожитку пального(введіть інтервал)\n" +
                    "EditList - Редагування списку літаків\n" +
                    "Exit - Вихід з програми");
            printSeparator();
            patameters = reader.readLine().split(" ");
            if(patameters[0].toUpperCase().equals("EXIT"))
                return;
            command = commandMap.get(patameters[0]);
            if(command == null){
                System.out.println("Непраильна команда");
                continue;
            }
            invoker.setCommand(command);
            invoker.invoke(patameters);
        }
    }
}
