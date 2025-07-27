//Angler Sprite Engine (JAVA)

package Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**Original Comment(2016):: ME and the Internet
 *
 * @author Pantelis Kondylas
 **/

public class Source {

    public static void main(String[] args) {
        new Source();
    }

    int fps = 60;
    int winWidth=1280, winHeight=720;
    JFrame frame;
    boolean isRunning = true;
    
    Graphics graphics;                //frame graphics
    Graphics graphicsOfBuffer;       //graphics of image Buffer
    BufferedImage buffer;           //Completed Image BUFFER

    //Rectangle Position Changing through Update;
    int x=100, y=100;
    
    public Source(){
        run();
        System.exit(-1);
    }

    void init() {
        frame = new JFrame("Game Window");
        frame.setSize(winWidth, winHeight);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Terminates everything after closing the window
        frame.setVisible(true);                                  //if NO setDefaultClose.. then continue running
                                                                //in the background with the window Closed
                                                                
                                                                
        //Creating a buffer "Image" so that we show END RESULT rather creating
        //the hole image while drawing it...
        buffer = new BufferedImage(winWidth, winHeight, BufferedImage.TYPE_INT_RGB);
        graphicsOfBuffer = buffer.getGraphics();
        //Could be on top - in Draw,but not that efficient calling it every frame      
        graphics = frame.getGraphics();
        
    }                                  

    void run() {
        init();

        while (isRunning) {
            long time = System.currentTimeMillis();

            update();
            draw();
            time = (1000 / fps) - (System.currentTimeMillis() - time);
            if (time > 0) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e){
                	e.printStackTrace();						
                  }
            }
        }
    }

    void update() {
        x++;
        y++;
    }

    void draw() {        
        
        graphicsOfBuffer.setColor(Color.black);
        graphicsOfBuffer.fillRect(0, 0, winWidth, winHeight);
               
        graphicsOfBuffer.setColor(Color.magenta);            // if x,y,50,50 then movable :)
        graphicsOfBuffer.fillRect(600, 300, 50, 50);        // by the time we are Updating!!
        
        graphics.drawImage(buffer, 0, 0, frame);
    }
}
