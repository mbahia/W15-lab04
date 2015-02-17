package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

import java.awt.Shape;
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
/**
    A component that draws an animated picture by Kelvin Yang

    @author Kelvin Yang
    @version CS56, Winter 2015, UCSB
*/

public class AnimatedPictureComponent extends JComponent
{
    private Shape fan;
    private Shape blades;
    private double speed;
    
    /** Constructs an AnimatedPictureComponent with specific properties.
     *  This animated picture depicts a fan with rotating blades
     * @param x x coordinate of top left of fan
     * @param y y coordinate of top left of fan
     * @param height the height of the fan
     * @param speed the speed at which the fan blades rotate
     */
    public AnimatedPictureComponent(double x, double y, double height, double speed)
    {
        fan = new Fan(x, y, height);
        blades = new FanBlades(x, y, height);
        this.speed = 1000.0 / speed;
    }
    
    /** The paintComponent method is orverriden to display
     *  out animation. Each time this method is called, the
     *  position of the fan blades are updated
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        Stroke orig = g2.getStroke();
        g2.setStroke(thick);
        g2.draw(fan);
        g2.draw(blades);
        blades = ShapeTransforms.rotatedCopyOf(blades, Math.PI / speed);
    }
}
