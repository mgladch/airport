package tests;

import airplanes.Airplane;
import airplanes.CargoPlaine;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoPlaineTest {
    CargoPlaine cargoPlaine;

    @BeforeEach
    void setUp() {
        cargoPlaine = new CargoPlaine("AN", "123", 1, 1, 1, 1);
    }

    @AfterEach
    void tearDown() {
        Airplane.curId = 1;
    }

    @Test
    void setCapacity1() {
        cargoPlaine.setCapacity(100);
        Assert.assertEquals(cargoPlaine.getCapacity(), 100);
    }

    @Test
    void setCapacity2() {
        cargoPlaine.setCapacity(-10);
        Assert.assertEquals(cargoPlaine.getCapacity(), -1);
    }
}