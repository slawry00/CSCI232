/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlelab;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 12/1/2018
 * CSCI 232
 * @author Spencer Lawry
 */
public class DrawPanel extends JPanel
{
    BufferedImage grid;
    Graphics2D gc;
   
    public DrawPanel()
    {
    }
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;
        if (grid == null)
        {
           int w = this.getWidth();
           int h = this.getHeight();
           grid = (BufferedImage)(this.createImage(w,h));
           gc = grid.createGraphics();
        }
        g2.drawImage(grid, 0, 0, null);
    }
    public void drawLine(int start_x, int start_y, int end_x, int end_y)
    {
        Runnable do_stuff = new Runnable()
        {
            public void run()
            {
                gc.drawLine(start_x, start_y, end_x, end_y);
            }
        };     
        SwingUtilities.invokeLater(do_stuff);
    }
   
}
