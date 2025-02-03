import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

public class TestCarGetters {
    private Saab95 saab;
    private Volvo240 volvo;

    @Before
    public void init() {
        saab = new Saab95();
        volvo = new Volvo240();
    }

    @Test
    public void testDoorAmount() {
        assertEquals(saab.getNrDoors(), 2);
        assertEquals(volvo.getNrDoors(), 4);
        assertEquals(scania.getNrDoors(), 2);
    }

    @Test
    public void testEnginePower() {
        assertEquals(saab.getEnginePower(), 125.0);
        assertEquals(volvo.getEnginePower(), 100.0);
    }

    @Test
    public void testColor() {
        assertEquals(saab.getColor(), Color.red);
        assertEquals(volvo.getColor(), Color.black);
    }
}