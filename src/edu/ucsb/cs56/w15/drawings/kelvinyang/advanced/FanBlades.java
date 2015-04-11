package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.CubicCurve2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
    The blades of a fan
    
    @author Kelvin Yang 
    @version for CS56, W15, UCSB, 02/12/2015
*/
public class FanBlades extends GeneralPathWrapper implements Shape
{
    /**
     * Constructor for FanBlades
     * Used for animation since only the blades of a fan should rotate
     * @param x x coordinate of top left of fan
     * @param y y coordinate of top left of fan
     * @param height the height of the fan
     */
    public FanBlades(double x, double y, double height)
    {
        // "fan blade x" & "fan blade y"
        double fbx, fby;
        double width = 2 * height / 3;
        
        // Create each blade of the fan (Total 4)
        fbx = x + width * 0.5;
        fby = y + width * 0.375;
        CubicCurve2D fanBlade1 = new CubicCurve2D.Double(fbx, fby, fbx - width * 0.75, fby - width * 0.125, fbx + width * 0.75, fby - width * 0.625, fbx, fby);
        fbx = x + width * 0.625;
        fby = y + width * 0.5;
        CubicCurve2D fanBlade2 = new CubicCurve2D.Double(fbx, fby, fbx + width * 0.125, fby - width * 0.75, fbx + width * 0.625, fby + width * 0.75, fbx, fby);
        fbx = x + width * 0.5;
        fby = y + width * 0.625;
        CubicCurve2D fanBlade3 = new CubicCurve2D.Double(fbx, fby, fbx + width * 0.75, fby + width * 0.125, fbx - width * 0.75, fby + width * 0.625, fbx, fby);
        fbx = x + width * 0.375;
        fby = y + width * 0.5;
        CubicCurve2D fanBlade4 = new CubicCurve2D.Double(fbx, fby, fbx - width * 0.125, fby + width * 0.75, fbx - width * 0.625, fby - width * 0.75, fbx, fby);
        
        //Get the rest of the fan
        GeneralPath wholeFan = this.get();
        
        //Add each blade to the fan
        wholeFan.append(fanBlade1, false);
        wholeFan.append(fanBlade2, false);
        wholeFan.append(fanBlade3, false);
        wholeFan.append(fanBlade4, false);
    }
}
