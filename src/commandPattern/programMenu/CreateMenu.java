package commandPattern.programMenu;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import airplanes.PassangerPlaine;
import commandPattern.commands.Command;
import commandPattern.commands.createCommands.AddCargoPlain;
import commandPattern.commands.createCommands.AddPassangerPlain;
import commandPattern.commands.createCommands.DeleteAirplane;
import commandPattern.commands.createCommands.PrintList;
import start.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateMenu extends  Menu{
    Map<String, Command> commandMap;
    private List<Airplane> airplanes;

    public CreateMenu(List<Airplane> airplanes) {
        this.airplanes = airplanes;
        commandMap = new HashMap<>();
        commandMap.put("PrintList", new PrintList(airplanes));
        commandMap.put("AddCargo", new AddCargoPlain(airplanes));
        commandMap.put("AddPassanger", new AddPassangerPlain(airplanes));
        commandMap.put("DeleteAirplane" , new DeleteAirplane(airplanes));
    }

    public static List<Airplane> createAirplaneList() throws Exception{
        List<Airplane> airplanes = new ArrayList<>();
        int key;
        System.out.println("Виберыть спосіб заповнення списку:\n" +
                "1 - З консолі\n" +
                "2 - З файлу");
        key = Integer.parseInt(reader.readLine());
        switch (key) {
            case 1: {
                Main.logger.info("Creating from console");
                CreateMenu createMenu = new CreateMenu(airplanes);
                createMenu.fillListConsole();
                break;
            }
            case 2: {
                String path;
                System.out.println("Введіть шлях до файлу");
                path = reader.readLine();
                Main.logger.info("Creating from file");
                Main.logger.debug("parameters: " + path);
                fillListFile(airplanes, path);
                break;
            }
            default:{
                Main.logger.fatal("Uncorrect choose");
                System.out.println("Неправильний вибір");
                return null;
            }
        }
        return airplanes;
    }

    public void fillListConsole() throws Exception {
        Command command;
        String patameters[];
        while (true){
            printSeparator();
            System.out.println("Меню заповнення:\n" +
                    "PrintList - Видрукувати список літаків\n" +
                    "AddCargo name model lenghtFlight staff consumption capacity - Додати вантажний літак\n" +
                    "AddPassanger name model lenghtFlight staff consumption numSeats - Додати пасажирський літак\n" +
                    "DeleteAirplane id - Видалити літак\n" +
                    "Exit - Вихід");
            printSeparator();
            patameters = reader.readLine().split(" ");
            if(patameters[0].equals("Exit"))
                return;
            command = commandMap.get(patameters[0]);
            if(command == null){
                System.out.println("Неправильна команда");
                continue;
            }
            invoker.setCommand(command);
            invoker.invoke(patameters);
        }
    }

    public static void fillListFile(List<Airplane> airplanes, String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Airplane airplane;
        while (reader.ready()) {
            String parameters[] = reader.readLine().split(" ");
            String name = parameters[1];
            String model = parameters[2];
            int lenght = Integer.parseInt(parameters[3]);
            int staff = Integer.parseInt(parameters[4]);
            int consuption = Integer.parseInt(parameters[5]);
            int extra = Integer.parseInt(parameters[6]);
            switch (parameters[0]) {
                case "Cargo": {
                    airplane = new CargoPlaine(name, model, lenght, staff, consuption, extra);
                    airplanes.add(airplane);
                    break;
                }
                case "Passanger": {
                    airplane = new PassangerPlaine(name, model, lenght, staff, consuption, extra);
                    airplanes.add(airplane);
                    break;
                }
                default: {
                    throw new RuntimeException("Невизначений тип");
                }
            }
        }
    }

}
