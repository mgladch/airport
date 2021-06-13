package start;

import airplanes.Airplane;
import commandPattern.programMenu.CreateMenu;
import commandPattern.programMenu.WorkMenu;
import org.apache.log4j.Logger;


import java.util.List;

public class Main {
    public static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) throws Exception{
        List<Airplane> airplanes;
        logger.info("Starting");
        airplanes =  CreateMenu.createAirplaneList();
        WorkMenu workMenu = new WorkMenu(airplanes);
        workMenu.openMenu();
        logger.info("Exit");
    }
}
