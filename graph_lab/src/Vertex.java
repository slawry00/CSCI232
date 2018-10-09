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
        System.out.println(this);
    }
    public Boolean CheckVisited()
    {
        return visited;
    }
    public ArrayList GetArr()
    {
        return this.arr;
    }
}
