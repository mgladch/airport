package tests;

import airplanes.Airplane;
import airplanes.PassangerPlaine;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassangerPlaineTest {
    PassangerPlaine plaine;

    @BeforeEach
    void setUp() {
        plaine = new PassangerPlaine("AN", "123",1,1,1,1);
    }

    @AfterEach
    void tearDown() {
        Airplane.curId = 1;
    }

    @Test
    void setNumSeats1() {
        plaine.setNumSeats(100);
        Assert.assertEquals(plaine.getNumSeats(),100);
    }

    @Test
    void setNumSeats2() {
        plaine.setNumSeats(-10);
        Assert.assertEquals(plaine.getNumSeats(),-1);
    }
}