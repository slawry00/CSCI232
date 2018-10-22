/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w58z387
 */
import java.util.*;
public class Vertex 
{
    private ArrayList arr;
    private String name;
    private Boolean visited = false;
    private int dist = 0;
    private Vertex path = this; //defaults to itself
    
    public Vertex(String name, ArrayList<Integer> arr)
    {
        this.arr = arr;
        this.name = name;
    }
    public String toString()
    {
        return name;
    }
    public void Visit()
    {
        this.visited = true;
        //System.out.println(this);
    }
    public Boolean CheckVisited()
    {
        return visited;
    }
    public ArrayList GetArr()
    {
        return this.arr;
    }
    public int GetDist()
    {
       return this.dist;
    }
    public void SetDist(int new_dist)
    {
       this.dist = new_dist;
    }
    public Vertex GetPath()
    {
       return this.path;
    }
    public void SetPath(Vertex v)
    {
       this.path = v;
    }
    public void PrintPath() //prints the cheapest path for this Vertex
    {
       System.out.print("Shortest path to " + this + ": ");
       PrintPath_helper(this);
       System.out.println();
    }
    private void PrintPath_helper(Vertex v) // need a function to recurse with
    {
       //System.out.println("v's path: " + v.path + " this: " + this + " v: " + v);
       if (v.path != v) //we know we've reached the origin if the vertex's
       {                   //path is itself. 
          //System.out.println();
          PrintPath_helper(v.path);
       }
       System.out.print(v+" ");
    }
}
