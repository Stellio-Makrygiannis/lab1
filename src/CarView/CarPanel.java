package CarView;

import CarModel.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class CarPanel extends JPanel {
    BufferedImage volvoImage;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;

    private final CarSet carSet;
    private final Point volvoWorkshopPoint;

    // Initializes the panel and reads the images
    public CarPanel(int x, int y, CarSet carSet, Point volvoWorkshopPoint) {
        this.carSet = carSet;
        this.volvoWorkshopPoint = volvoWorkshopPoint;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("CarModel.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(CarPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saab95Image = ImageIO.read(CarPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(CarPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage = ImageIO.read(CarPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        for (Car car : carSet.filterCars(_ -> true)) {
            BufferedImage image = switch (car) {
                case Volvo240 _ -> volvoImage;
                case Saab95 _ -> saab95Image;
                case Scania _ -> scaniaImage;
                default -> throw new IllegalStateException("We can't draw this car.");
            };

            g.drawImage(image, (int)car.getCurrentPosition()[0], (int)car.getCurrentPosition()[1], null);
        }

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }
}
