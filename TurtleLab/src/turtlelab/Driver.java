/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtlelab;

import java.util.concurrent.TimeUnit;

/**
 * 12/1/2018
 * CSCI 232
 * @author Spencer Lawry
 */
public class Driver 
{
    public static void main(String[] args) 
    {
        Turtle my_turt = new Turtle();
        // Give it a second headstart
        try
        {
            Thread.sleep(200);
        }
        catch(InterruptedException E){}
        my_turt.penColor(255, 255, 0);
        my_turt.penSize(5);
        
        int sides = 8;       
        int length = 55;
        
        // GO
        for(int i = 0; i< sides; i++)
        {     
            my_turt.fd(length);
            my_turt.left(360/sides); 
        }
        my_turt.penUp();
        my_turt.goTo(-30, -25);
        my_turt.penDown();
        my_turt.penColor(0, 0, 255);
        my_turt.fd(125);
        
        //AGAIN BUT SLOWER IN RED
        try 
        {
            Thread.sleep(200); // to let it finish before resetting
        }
        catch(InterruptedException E){}
        my_turt.home();
        my_turt.speed(1);
        my_turt.penColor(255, 0, 0); 
        my_turt.clear(); 

        for(int i = 0; i< sides; i++)
        {     
            my_turt.fd(length);
            my_turt.left(360/sides); 
        }
        my_turt.penUp();
        my_turt.goTo(-30, -25);
        my_turt.penDown();
        my_turt.penColor(0, 0, 255);
        my_turt.fd(125);
    }
   
}
