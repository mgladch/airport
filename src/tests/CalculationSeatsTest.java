package tests;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import airplanes.PassangerPlaine;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import commandPattern.commands.calculation.CalculationCapacity;
import commandPattern.commands.calculation.CalculationSeats;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculationSeatsTest {
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
        CalculationSeats calculationSeats = new CalculationSeats(airplanes);
        ByteOutputStream outputStream = new ByteOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        calculationSeats.execute("".split(""));
        String sum = outputStream.toString().split(" ")[3];
        Assert.assertEquals(sum, "140\r\n");
    }
}