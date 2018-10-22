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
       //System.out.println(q);
       while (!q.isEmpty())
       {
           //System.out.println(q);
           v = (Vertex) q.pop();
           v.Visit();
           System.out.print(v + ", ");
           for (int i = 0; i < v.GetArr().size(); i++)
           {
               adj_weight = (int) v.GetArr().get(i); // 0 if not adj
               if (adj_weight != 0)
               {
                   u = (Vertex) verts.get(i);
                   //System.out.println(u);
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
   }
   public void depth_helper(Vertex v)
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
      System.out.println();
   }
   public ArrayList<Vertex> dijkstra(int begin)
   {
      Vertex v; // holds the vertex we're currently visiting
      v = (Vertex) verts.get(begin);
      return dijkstra_helper(v);
   }
   public ArrayList<Vertex> dijkstra_helper(Vertex v)
   {
      int adj_weight;
      int cheapest = -1; // initalize it to a flag value 
      Vertex cheapest_v = v; //initialize it to itself (flag as well)
      Vertex u; // holds the current adjacent Vertex being compared

      v.Visit();
      //System.out.println("v: " + v);
      for (int i = 0; i < v.GetArr().size(); i++) //check all other verts
      {
         adj_weight = (int) v.GetArr().get(i);
         if (adj_weight != 0) //if it is adjacent
         {
            u = (Vertex) verts.get(i);
            //System.out.println("u: " + u);

            if (u.GetDist() > (v.GetDist() + adj_weight) ||
                (u.GetDist() == 0 && !u.CheckVisited())) 
            { //update adjacent member's dist & path
               u.SetDist(v.GetDist() + adj_weight);
               //System.out.println(u + ": " + u.GetDist() + " new path: " + v);
               u.SetPath(v);
            }
         }
      }
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

      if (cheapest_v != v) // using flag to see if there isnt an unknown
         {                    // cheapest vertex (aka cheapest_v never updated)
           //System.out.println("Cheapest_v: " + cheapest_v);
           //System.out.println("moving to cheapest vertex");
           dijkstra_helper(cheapest_v); //recurse into the cheapest v
         }
      return verts;
   }
}
