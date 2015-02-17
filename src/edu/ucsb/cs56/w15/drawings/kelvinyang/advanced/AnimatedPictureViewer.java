package edu.ucsb.cs56.w15.drawings.kelvinyang.advanced;
import javax.swing.JFrame;
import java.awt.event.*;

/** A viewer class to see a picture I drew with 
 *  additional animation
 *  
 * @author P. Conrad
 * @author Kelvin Yang
 * @version for UCSB CS56, W15, 02/12/2015
 */

public class AnimatedPictureViewer extends JFrame
{
    Thread animate;
    AnimatedPictureComponent component;
    static final double FAN_X = 200;
    static final double FAN_Y = 50;
    static final double FAN_HEIGHT = 350;
    

    /** constructs a JFrame with an animated picture inside
     */
    public AnimatedPictureViewer()
    {
        // Set the size of canvas
        setSize(640,480);
        
        // Set the title of drawing
        setTitle("Kelvin Yang's Animated Drawing");
        
        //Allows window to close normally
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Instantiate your drawing as a "component"
        component = new AnimatedPictureComponent(FAN_X, FAN_Y, FAN_HEIGHT, 25);
        
        // Always add your component to the frame and then make the window visible
        add(component);
        setVisible(true);
        
        //Mouse listener for drawing to react to mouse events
        getContentPane().addMouseListener( new MouseAdapter()
        {
            Animation a = new Animation(); //Create animation
            Thread t = new Thread(a); //Create thread and add animation
            boolean started = false;
            
            public void mouseEntered(MouseEvent e) //Mouse enter event
            {
                if(started)
                    a.running = true; //Start animation
                else
                {
                    t.start(); //start thread
                    started = true;
                }
            }
            
            public void mouseExited(MouseEvent e)
            {
                a.running = false; //Stop animation
            }
        });
    }
    
    public static void main(String[] args)
    {
        AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }

    class Animation implements Runnable
    {
        public boolean running = false; //Animates when true
        
        public void run()
        {
            running = true;
            while(true)
            {
                if(running) //Draw next frame
                    component.repaint();
                try { //Delay between frames
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
