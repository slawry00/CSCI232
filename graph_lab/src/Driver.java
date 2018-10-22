/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 10/8/2018
 * @author Spencer Lawry
 * CSCI232
 */
import java.io.*;
import java.util.*;

public class Driver 
{


   public static void main(String[] args) throws IOException 
    {
        InputStream in_file = null;
        try
        {
           in_file = new FileInputStream(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException E)
        {
            System.err.println("You must provide an input file in format: " +
                               "java executable_file input_file");
            System.exit(-1);
        }
        Scanner file_scanner = new Scanner(in_file);
        Scanner line_scanner;
        ArrayList mat = new ArrayList<ArrayList<Integer>>();
        String line;
        ArrayList arr = new ArrayList<Integer>();

        while (file_scanner.hasNextLine())
        {
            line = file_scanner.nextLine();
            line_scanner = new Scanner(line);
            while (line_scanner.hasNextInt())
            {
               arr.add(line_scanner.nextInt());
            }
            mat.add(arr); // make mat an array of integer arrays
            arr = new ArrayList<Integer>(); //reset v_int
        }    
        Graph my_graph = new Graph(mat);
        //BREADTH FIRST TEST ------------------------
        //my_graph.breadth_first(0);
        
        //DEPTH FIRST TEST --------------------------
        //my_graph.depth_first(4); 
        
        //DIJKASTRA TEST ----------------------------
        /*ArrayList vert_arr = my_graph.dijkstra(4);
        for (int i = 0; i < vert_arr.size(); i++)
        {
           Vertex my_vert = (Vertex) vert_arr.get(i);
           my_vert.PrintPath();
        }*/
        
        //PRIM TEST ---------------------------------
        //my_graph.prim(0);
    }
}
