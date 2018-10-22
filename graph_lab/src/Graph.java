/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Spencer Lawry
 */
import java.util.*;
public class Graph 
{
   private ArrayList mat;
   private ArrayList verts = new ArrayList<Vertex>();
   
   public Graph(ArrayList<ArrayList<Integer>> mat)
   {
      this.mat = mat;
      Vertex v;
        for (int i = 0; i < mat.size(); i++)
        {
            v = new Vertex("v"+(i), mat.get(i));
            verts.add(v);
        }
   }
   public void breadth_first(int begin)
   {
       Vertex v;
       Vertex u;
       int adj_weight;
       ArrayDeque q = new ArrayDeque<Vertex>();
       
       v = (Vertex) verts.get(begin);
       q.add(v);
       while (!q.isEmpty())
       {
           v = (Vertex) q.pop();
           v.Visit();
           System.out.print(v + ", ");
           for (int i = 0; i < v.GetArr().size(); i++)
           {
               adj_weight = (int) v.GetArr().get(i); // 0 if not adj
               if (adj_weight != 0)
               {
                   u = (Vertex) verts.get(i);
                   if (!u.CheckVisited() && !q.contains(u))
                   { //if it is not visited, and not in the q, add it
                       q.add(u);
                   }
               }
           }
       }
       System.out.println();
   }
   public void depth_first(int begin)
   {
      Vertex v = (Vertex) verts.get(begin);
      depth_helper(v);
      System.out.println();
   }
   private void depth_helper(Vertex v)
   {
      int adj_weight;
      Vertex u;

      v.Visit();
      System.out.print(v + ", ");
      for (int i = 0; i < v.GetArr().size(); i++) //check all other verts
      {
         adj_weight = (int) v.GetArr().get(i);
         if (adj_weight != 0) //if it is adjacent
         {
            u = (Vertex) verts.get(i);
            if (!u.CheckVisited()) //if it hasn't been visited
            {
               depth_helper(u); //go deeper
            }
         }
      }
      
   }
   public ArrayList<Vertex> dijkstra(int begin)
   {
      Vertex v; // holds the vertex we're currently visiting
      v = (Vertex) verts.get(begin);
      return dijkstra_helper(v);
   }
   private ArrayList<Vertex> dijkstra_helper(Vertex v)
   {
      int adj_weight;
      Vertex u; // holds the current adjacent Vertex being compared
      Vertex cheapest_v = null; //initialize it to flag value
      v.Visit();
      for (int i = 0; i < v.GetArr().size(); i++) //check all other verts
      {
         adj_weight = (int) v.GetArr().get(i);
         if (adj_weight != 0) //if it is adjacent
         {
            u = (Vertex) verts.get(i);
            if (u.GetDist() > (v.GetDist() + adj_weight) ||
                (u.GetDist() == 0 && !u.CheckVisited()))
            { //update adjacent member's dist & path
               u.SetDist(v.GetDist() + adj_weight);
               u.SetPath(v);
            }
         }
      }
      
      cheapest_v = find_cheapest_v();
      if (cheapest_v != null) // if there exists a cheapest unknown vertex
         {
           dijkstra_helper(cheapest_v); //move to the cheapest unknown v
         }
      return verts;
   }
   private Vertex find_cheapest_v()
   {
      Vertex u;
      int cheapest = -1; // initalize it to a flag value 
      Vertex cheapest_v = null; // also a flag
      for (int i = 0; i < verts.size(); i++)
      {
         u = (Vertex) verts.get(i);
         if (!u.CheckVisited() && u.GetDist() > 0)
         { //find an unknown reachable member
           if (cheapest == -1)
           { // if it is the first unknown reachable member to be found
              cheapest = u.GetDist();
              cheapest_v = u;
           }
           else if (u.GetDist() < cheapest)
           { // if it is cheaper than the previous cheapest
             cheapest = u.GetDist(); //update cheapest to cheaper weight
             cheapest_v = u; // update the corresponding vertex
           }
         }
      }
      return cheapest_v;
   }
   public void prim(int begin)
   {
      Vertex v; // holds the vertex we're currently visiting
      v = (Vertex) verts.get(begin);
      System.out.println("Minimum Spanning Tree Edges: ");
      prim_helper(v, 0);
   }
   private void prim_helper(Vertex v, int total_weight)
   {
      int adj_weight;
      Vertex u; // holds the current adjacent Vertex being compared
      Vertex cheapest_v = null; //initialize it to flag value
      v.Visit();
      for (int i = 0; i < v.GetArr().size(); i++) //check all other verts
      {
         adj_weight = (int) v.GetArr().get(i);
         if (adj_weight != 0) //if it is adjacent
         {
            u = (Vertex) verts.get(i);
            if (u.GetDist() > (adj_weight) ||
                (u.GetDist() == 0 && !u.CheckVisited()))
            { //update adjacent member's dist & path
               u.SetDist(adj_weight);
               u.SetPath(v);
            }
         }
      }
      cheapest_v = find_cheapest_v();
      if (cheapest_v != null) // if there exists a cheapest unknown vertex
         {
           System.out.println("(" + cheapest_v.GetPath() + "," + 
                                    cheapest_v + ")"); //edge in spanning tree
           prim_helper(cheapest_v, total_weight + cheapest_v.GetDist()); 
            //move to the cheapest unknown v & pass the current weight
         }
      else
      {
         System.out.println("Total Weight: " + total_weight);
      }
   }
}
