import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;

public class CarGetters {
    private Saab95 saab;

    @Before
    public void init() {
        saab = new Saab95();
    }

    @Test
    public void testDoorAmount() {
        assertEquals(saab.getNrDoors(), 2);
    }
}