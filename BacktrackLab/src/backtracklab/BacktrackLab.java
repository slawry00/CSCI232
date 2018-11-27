/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracklab;

/**
 * CSCI232
 * @author Spencer Lawry
 * 11/26/18
 */
public class BacktrackLab 
{
    public static void main(String[] args) 
    {
        MagicSquare my_square = new MagicSquare(3);
        my_square.solve();
        //my_square.print_solution();
    } 
}
