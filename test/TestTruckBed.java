import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class TestTruckBed {
    private Scania truck;

    @Before
    public void init() {
        truck = new Scania();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testTruckBedPositionAboveSeventyFails() {
        truck.changeTruckBedPosition(70.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTruckBedPositionBelowZeroFails() {
        truck.changeTruckBedPosition(-0.1);
    }


}