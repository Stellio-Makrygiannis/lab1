package CarModel;

import javax.swing.*;
import java.awt.*;

public class CarModel {
    public final CarSet carSet = new CarSet();
    public final CarSetAnimator carSetAnimator = new CarSetAnimator(carSet);

    public final Point VolvoWorkshop = new Point(300, 50);


}
