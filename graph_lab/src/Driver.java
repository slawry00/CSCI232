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
        ArrayList mat = new ArrayList<ArrayList<Integer>>();
        String v;
        String[] v_arr;
        ArrayList v_int = new ArrayList<Integer>();

        while (file_scanner.hasNextLine())
        {
            v = file_scanner.nextLine();
            v_arr = v.split("");
            //System.out.println(v_arr);
            for (int i = 0; i < v_arr.length; i++)
            {
                v_int.add(Integer.parseInt(v_arr[i])); //convert str[] -> Int[]
            }
            //System.out.println(v_int);
            mat.add(v_int); // make mat an array of integer arrays
            v_int = new ArrayList(); //reset v_int
        }    
        //System.out.println(mat);
        breadth_first(mat); 
    }
    public static void breadth_first(ArrayList<ArrayList<Integer>> mat)
    {
        ArrayList verts = new ArrayList<Vertex>();
        Vertex v;
        Vertex u;
        int adj_weight;
        ArrayDeque q = new ArrayDeque<Vertex>();
        for (int i = 0; i < mat.size(); i++)
        {
            v = new Vertex("v"+(i), mat.get(i));
            verts.add(v);
        }
        //System.out.println(verts);
        v = (Vertex) verts.get(0);
        q.add(v);
        //System.out.println(q);
        while (!q.isEmpty())
        {
            //System.out.println(q);
            v = (Vertex) q.pop();
            v.Visit();
            for (int i = 0; i < v.GetArr().size(); i++)
            {
                adj_weight = (int) v.GetArr().get(i); // 0 if not adj
                if (adj_weight != 0)
                {
                    u = (Vertex) verts.get(i);
                    //System.out.println(u);
                    if (!u.CheckVisited() && !q.contains(u))
                    {
                        q.add(u);
                    }
                }
            }
        }
    }
}
