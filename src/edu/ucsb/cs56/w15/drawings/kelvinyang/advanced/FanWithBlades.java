package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
    A Fan, with blades
    
    @author Kelvin Yang 
    @version for CS56, W15, UCSB, 02/05/2015
*/
public class FanWithBlades extends Fan implements Shape
{
    /**
     * Constructor for FanWithBlades
     * @param x x coordinate of top left of fan
     * @param y y coordinate of top left of fan
     * @param height the height of the fan
     */
    public FanWithBlades(double x, double y, double height)
    {
        //Draw the rest of the fan using super
        super(x, y, height);
        FanBlades fb = new FanBlades(x, y, height);

        //Get the rest of the fan
        GeneralPath wholeFan = this.get();

        //Add the blades of the fan
        wholeFan.append(fb, false);
    }
}
