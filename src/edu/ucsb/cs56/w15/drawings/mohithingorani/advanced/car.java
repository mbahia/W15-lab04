// creating a simple car
//
package edu.ucsb.cs56.w15.drawings.mohithingorani.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Car (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Mohith Hingorani 
   @version for CS56, W15, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class CoffeeCup
     */
    public Car(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* car
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 400.0; 
        
	double groundClearence =  height * 0.8;
	double backbumper = width  * 0.1;
	double roofHeight = height * 0.3;
	double backRoof =   width  * 0.2;
	double frontRoof =  width  * 0.5;
	double frontBumper = width * 0.9;
	double hoodHeight = height * 0.6;
	
	double frontWheel = width * 0.7;
	double backWheel =  width * 0.3;
	
	double WheelSize = width * 0.05;
        double hoodSize  = width * 0.6; 
	double frontWheelbase = width * 0.8 ;
	double backWheelbase = width * 0.2;
	
	Line2D.Double lowerBack = new Line2D.Double ( x + backWheelbase , y + groundClearence, x + backBumper , y + groundClearence ) ;		
        Line2D.Double backSide = new Line2D.Double ( x + backBumper  ,y + groundClearence , x + BackBumper, y + hoodHeight );	 
        Line2D.Double backShield  = new Line2D.Double ( x + BackBumper, y + hoodHeight , x + backRoof , y + roofHeight );

        Line2D.Double topRoof     = new Line2D.Double ( x + frontRoof, y + hoodHeight , x + backRoof , y + roofHeight );

        Line2D.Double frontShield = new Line2D.Double ( x + frontRoof, y + hoodHeight , x + hoodSize , y + hoodHeight );
        Line2D.Double hood        =  new Line2D.Double( x+ hoodSize, y + hoodHeight , x + frontBumper , y + hoodheight);
	Line2D.Double frontSide = new Line2D.Double ( x + frontBumper , y + hoodHeight , x + frontBumper , y + groundClearence) ;
	Line2D.Double lowerFront = new Line2D.Double ( x + frontBumper , y +groundClearence , x + frontWheelbase  , y + groundClearence);
  
	
        
	GeneralPath wholeCar = new GeneralPath ();
        wholeCar.append(to, false);
        wholeCup.append(leftSide, false);
        wholeCup.append(rightSide, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeCup, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s));
        
    }

}
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                

