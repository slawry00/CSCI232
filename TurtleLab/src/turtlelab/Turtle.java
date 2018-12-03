/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlelab;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 12/1/2018
 * CSCI 232
 * @author Spencer Lawry
 */
public class Turtle extends JFrame
{
    private static final int FRAME_SIZE = 900;
    private DrawPanel my_pan;
    private int x;
    private int y;
    private double heading; // in radians

    public Turtle()
    {
        my_pan = new DrawPanel();
        this.add(my_pan);
        super.setSize(FRAME_SIZE, FRAME_SIZE);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        this.home();

    }
    public void fd(int distance)
    {   
        //System.out.println("x = " + x);
        //System.out.println("y = " + y);
        int dist_y = (int) (distance*Math.sin(heading)); 
        //System.out.println("Dist_y = " + dist_y);
        int dist_x = (int) (distance*Math.cos(heading));
        //System.out.println("Dist_x = " + dist_x);
        my_pan.drawLine(x, y, x+dist_x, y+dist_y); 
        x = x + dist_x;
        y = y + dist_y;
        //System.out.println("x = " + x);
        //System.out.println("y = " + y);
    }
    public void right(int degs)
    {
        double deg_rad = (degs/180.0)*Math.PI;
        this.heading = heading + deg_rad;
    }
    public void left(int degs)
    {
        double deg_rad = (degs/180.0)*Math.PI;
        this.heading = heading - deg_rad;
    }
    public void penUp()
    {
        my_pan.set_penup(true);
    }
    public void penDown()
    {
        my_pan.set_penup(false);
    }
    public void home()
    {
        this.x = FRAME_SIZE/2;
        this.y = FRAME_SIZE/2;
        this.heading = 0;
    }
    public void goTo(int go_x, int go_y)
    {
        my_pan.drawLine(x, y, FRAME_SIZE/2 + go_x, FRAME_SIZE/2 - go_y);
        x = FRAME_SIZE/2 + go_x;
        y = FRAME_SIZE/2 - go_y;
    }
    public int xcor()
    {
        return x - FRAME_SIZE/2; // +x is to the right for both
    }
    public int ycor()
    {
        return FRAME_SIZE/2 - y; // +y is up to user (down for JFrame)
    }
    public void setHeading(int degs)
    {
        this.heading = (degs/180.0)*Math.PI;
    }
    public void speed(int speed)
    {
        if(speed <= 5 && speed >= 1)
        {
            my_pan.setSpeed(6-speed);
        }
        
    }
    public void penSize(int size)
    {
        my_pan.setSize(size);
    }
    public void clear()
    {
        my_pan.clearImage();
    }
    public void penColor(int r, int g, int b)
    {
        my_pan.setColor(new Color(r, g, b));
    }


}
