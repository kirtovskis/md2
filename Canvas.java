package ld5;

/*
 * File: Canvas.java
 * Author: Java, Java, Java
 * Description: This subclass of JPanel performs all
 *  the drawing functions for the RecursivePatterns applet.
 *  Whenever the user selects a pattern, the applet invokes
 *  the setPattern() method and then calls its repaint()
 *  method. Since the Canvas is contained within the applet,
 *  it too will be repainted, by its paintComponent() method,
 *  which draws the currently selected pattern.
 */

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    public static final int WIDTH=500, HEIGHT=400;
    private int level = 0;                              // Current level
    
  
   char[] anArray = new char[10];

			int k = level;
			   int getPos = (int)Math.pow(10,k);


    /**
     *  Canvas() constructor sets its size
     */
    public Canvas() {
        setSize(WIDTH, HEIGHT);
    }

    /**
     *  setPattern() is invoked by the applet to set the
     *   current drawing pattern and level
     *  @param pat -- the pattern to be drawn
     *  @param lev -- the number of levels of recursion
     */
    public void setPattern( int lev, String upToNCharacters) {
        level = lev;
        k = lev;
        for (int i = 0; i<10; i++) {
        	anArray[i] = upToNCharacters.charAt(i);
        }
        
    }
    
    /**
     *  paintComponent() is invoked automatically whenever the Canvas
     *   needs to be painted -- e.g., when its containing applet is painted
     *  @param g -- the Canvas graphics object.
     */
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());      // Redraw the panel's background
        g.drawRect(0, 0, WIDTH, HEIGHT);
        g.setColor(getForeground());
        int scale = 100;
        if (k > 0) {
        if (getHeight() > getWidth()) {scale = getHeight()/4;} else {scale = getWidth()/4;}
        	drawPicture(g, level, anArray); 
        }
    } // paintComponent()
    
    private void drawPicture(Graphics g, int level, char[] anArray) {
    	k = level;
    	int getPos = (int)Math.pow(10,k);
    	 int vRef = 30; 
         int vGap = 15;	
         int hRef = 30; 
         int hGap = 15;
			//System.out.println("reiz cik " + getPos + " un k = " + k);
			
			 int length = 21;
			   //System.out.println("Length : " + length);
			for(int j = 0; j < length; j++)
			{
			   for(int i = 0;i < length;i++)
			   	{
				   g.drawString(anArray[Math.abs((int)((Math.sin(Math.toRadians(i+1+j*length))*getPos)%10))]+"  ",hRef,vRef);
				   hRef += hGap;
			   	} 
			   hRef = 30;
			   vRef += vGap;
			}  
    } // drawGasket()

} // Canvas
