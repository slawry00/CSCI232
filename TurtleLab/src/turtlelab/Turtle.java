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
    private DrawPanel my_pan;
    private int x = 0;
    private int y = 0;
    private double heading = 0;

    public Turtle()
    {
        my_pan = new DrawPanel();
        this.add(my_pan);
        super.setSize(600, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);

    }
    public void fd(int distance)
    {   
        //int dist_x = (int) (distance*Math.sin(heading)); 
        //int dist_y = (int) (distance*Math.cos(heading));
        my_pan.drawLine(x, y, 200, 200); // doesn't work

    }

}
