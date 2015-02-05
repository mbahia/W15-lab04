package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

public class FanWithBlades extends Fan implements Shape
{
    public FanWithBlades(double x, double y, double height)
    {
        super(x, y, height);
        double fbx, fby;
        double width = 2 * height / 3;
        
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
        
        GeneralPath wholeFan = this.get();
        
        wholeFan.append(fanBlade1, false);
        wholeFan.append(fanBlade2, false);
        wholeFan.append(fanBlade3, false);
        wholeFan.append(fanBlade4, false);
    }
}