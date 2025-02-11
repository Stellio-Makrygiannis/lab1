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
        assertEquals(2, saab.getNrDoors());
        assertEquals(4, volvo.getNrDoors());
    }

    @Test
    public void testEnginePower() {
        assertEquals(125.0, saab.getEnginePower());
        assertEquals(100.0, volvo.getEnginePower());
    }

    @Test
    public void testColor() {
        assertEquals(Color.red, saab.getColor());
        assertEquals(Color.black, volvo.getColor());
    }
}