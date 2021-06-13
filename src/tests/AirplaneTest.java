package tests;

import airplanes.Airplane;
import org.junit.Assert;

//import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {
    Airplane airplane;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        airplane = new Airplane("AN", "122", 1,1,1);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Airplane.curId = 1;
    }

    @org.junit.jupiter.api.Test
    void setConsumption1() {
        airplane.setConsumption(100);
        Assert.assertEquals(airplane.getConsumption(),100);
    }

    @org.junit.jupiter.api.Test
    void setConsumption2() {
        airplane.setConsumption(-10);
        Assert.assertEquals(airplane.getConsumption(),-1);
    }

    @org.junit.jupiter.api.Test
    void setLengthFlight1() {
        airplane.setLengthFlight(100);
        Assert.assertEquals(airplane.getLengthFlight(), 100);
    }

    @org.junit.jupiter.api.Test
    void setLengthFlight2() {
        airplane.setLengthFlight(-10);
        Assert.assertEquals(airplane.getLengthFlight(), -1);
    }

    @org.junit.jupiter.api.Test
    void setStaff1() {
        airplane.setStaff(100);
        Assert.assertEquals(airplane.getStaff(), 100);
    }

    @org.junit.jupiter.api.Test
    void setStaff2() {
        airplane.setStaff(-10);
        Assert.assertEquals(airplane.getStaff(), -1);
    }
}