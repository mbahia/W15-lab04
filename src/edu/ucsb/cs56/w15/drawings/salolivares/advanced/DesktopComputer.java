package edu.ucsb.cs56.w15.drawings.salolivares.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Sal Olivares
   @version for CS56, Winter 2015, UCSB
   
*/
public class DesktopComputer extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of Desktop
       @param y y coord of lower left corner of Desktop
       @param width width of the Desktop
       @param height of Desktop
     */
    public DesktopComputer(double x, double y, double width, double height)
    {
        double firstStoryHeight = .75 * height;
        double roofHeight = height - firstStoryHeight;
        double firstStoryUpperLeftY = y + roofHeight;
        
        // Component Positions
        double firstCdDiskLowerLeftX;
        double secondCdDiskLowerLeftX;
        double powerButtonLowerLeftX;

        double firstCdDiskLowerLeftY; 
        double secondCdDiskLowerLeftY;
        double powerButtonLowerLeftY;
        
        // Component Heights
        double firstCdDiskHeight = .10 * height;
        double secondCdDiskHeight = firstCdDiskHeight;
        double powerButtonHeight = .10 * height;
       
        // Component Widths
        double firstCdDiskWidth = .80 * width;
        double secondCdDiskWidth = firstCdDiskWidth;
        double powerButtonWidth = .10 * width;
        
        // Make computer tower, cd trays and power button
        
        Rectangle2D.Double DesktopTower = new Rectangle2D.Double(x, y, width, height);
        Rectangle2D.Double CDTrayOne = new Rectangle2D.Double(firstCdDiskLowerLeftX,firstCdDiskLowerLeftY,firstCdDiskWidth,firstCdDiskHeight);
        Rectangle2D.Double CDTrayTwo = new Rectangle2D.Double(secondCdDiskLowerLeftX,secondCdDiskLowerLeftY,secondCdDiskWidth,secondCdDiskHeight);
                          
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftRoof = 
            new Line2D.Double (x, y + roofHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightRoof =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + roofHeight);

        // put the whole house together
       
        GeneralPath wholeHouse = this.get();
        //wholeHouse.append(firstStory, false);
        //wholeHouse.append(leftRoof, false);
        //wholeHouse.append(rightRoof, false); 
        
    }

}
