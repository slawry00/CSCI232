/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlelab;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * 12/1/2018
 * CSCI 232
 * @author Spencer Lawry
 */
public class DrawPanel extends JPanel
{
    BufferedImage grid;
    Graphics2D gc;
    Boolean penup = false;
    Color pen_col = Color.BLACK;
    int pen_size = 1;
    int draw_speed = 3; //normal speed
    
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
            gc.setStroke(new BasicStroke(pen_size));
            gc.setColor(pen_col);
        }
        g2.drawImage(grid, null, 0, 0);
    }
    public void drawLine(int start_x, int start_y, int end_x, int end_y)
    {
        try
        {
            Thread.sleep(draw_speed*100);
        }
        catch(InterruptedException E){}
        if (!penup)
        {
            gc.drawLine(start_x, start_y, end_x, end_y);
            repaint();
        }
    }
    public void set_penup(Boolean boo)
    {
        this.penup = boo;
    }
    public void setColor(Color col)
    {
        this.pen_col = col;
        gc.setColor(pen_col);
    }
    public void setSize(int size)
    {
        this.pen_size = size;
        gc.setStroke(new BasicStroke(pen_size));
    }
    public void setSpeed(int speed)
    {
        this.draw_speed = speed;
    }
    public void clearImage()
    {
        grid = null;
        repaint();
    }
   
}
