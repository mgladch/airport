package tests;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import airplanes.PassangerPlaine;
import commandPattern.commands.createCommands.AddCargoPlain;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddCargoPlainTest {
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
    void execute() throws Exception{
        AddCargoPlain addCargoPlain = new AddCargoPlain(airplanes);
        addCargoPlain.execute("COM AN 125 10 10 10 10".split(" "));
        Assert.assertNotNull(airplanes.get(4));
    }
}