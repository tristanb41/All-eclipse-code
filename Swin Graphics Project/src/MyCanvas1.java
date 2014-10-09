import java.awt.*;

import javax.swing.JFrame;
public class MyCanvas1 extends Canvas
	{

	public static void main(String[] args)
		{
		MyCanvas1 canvas = new MyCanvas1();
        JFrame frame = new JFrame();
        frame.setSize(1000, 7500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas).setBackground(Color.white);
        frame.setLocationRelativeTo(null);  
        frame.setResizable(false);
        frame.setVisible(true);
		}
        
        
        
        public void paint(Graphics graphics) 
    		{
    		//X
    		graphics.setColor(Color.DARK_GRAY);
	        graphics.drawLine(350, 350, 0, 0);
	        
	        graphics.setColor(Color.DARK_GRAY);
	        graphics.drawLine(350, 0, 0, 350);   
	        
	        //Rectangle
	        
	        graphics.setColor(Color.CYAN);
	        graphics.fillRect(10, 500, 800, 100);
	        
	        //Square 
	        graphics.setColor(Color.red);
	        graphics.draw3DRect(10, 90, 900, 900, true);
	        
	       // outlined square
	        
	        
	        graphics.setColor(Color.blue);
	        graphics.draw3DRect(800, 800, 150, 150, true);
	        graphics.setColor(Color.yellow);
	        graphics.fillRect(801, 801, 149, 149);
	        
	        
	        // smiley face
	        
	        graphics.setColor(Color.yellow);
	        graphics.fillOval(140, 130, 100, 100);
	        
	        graphics.setColor(Color.black);
	        graphics.draw3DRect(165, 155, 5, 5, true);
	        
	        graphics.setColor(Color.black);
	        graphics.draw3DRect(205, 155, 5, 5, true);
	        
	        graphics.setColor(Color.red);
	        graphics.fillOval(170, 185, 40, 20);
	      

		}

	}
