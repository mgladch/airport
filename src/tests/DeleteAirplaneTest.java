package tests;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import airplanes.PassangerPlaine;
import commandPattern.commands.createCommands.DeleteAirplane;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteAirplaneTest {
    ArrayList<Airplane> airplanes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Airplane airplane = new PassangerPlaine("AM","123",2500,5,400,80);
        airplanes.add(airplane);
        airplane = new CargoPlaine("AN","123",150,4,600,100);
        airplanes.add(airplane);
        airplane = new PassangerPlaine("AM","124",3000,6,500,60);
        airplanes.add(airplane);
        airplane = new CargoPlaine("AN","124",2450,3,800,150);
        airplanes.add(airplane);
    }

    @AfterEach
    void tearDown() {
        Airplane.curId = 1;
    }

    @Test
    void execute() throws Exception {
        DeleteAirplane deleteAirplane = new DeleteAirplane(airplanes);
        deleteAirplane.execute("COM 4".split(" "));
        Assert.assertEquals(airplanes.size(), 3);
    }
}