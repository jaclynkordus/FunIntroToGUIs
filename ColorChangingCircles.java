/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author jaclynkordus
 */
public class ColorChangingCircles extends Circle {

    public ColorChangingCircles(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

    public void setFill() {
        double red = Math.random();
        double green = Math.random();
        double blue = Math.random();
        Paint myColor = new Color(red, green, blue, 1);
        super.setFill(myColor);
    }
}
