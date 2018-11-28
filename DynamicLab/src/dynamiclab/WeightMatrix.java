/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiclab;
import java.io.PrintWriter;
import java.util.*;
import static java.lang.Math.abs;
/**
 *
 * @author Spencer Lawry
 */
public class WeightMatrix 
{
   private int[] w_mat; // holds the array of student weights
   private int max_w; // maximum student weight allowed
   private int num_w; // number of students
   private int tot_w; //total weight of all students
   private int rest; // weight of remaining students for solve()
   //private int count = 0;
   
   private ArrayList<Integer> c_left; //holds current left/right
   private ArrayList<Integer> c_right;

   private int diff; // holds the value for smallest diff between left/right
   private ArrayList<Integer> d_left; //holds current "best" left/right
   private ArrayList<Integer> d_right;
   
   private int lookup[][];
   
   public WeightMatrix(int children, int max)
   {
      this.num_w = children;
      this.max_w = max;
      this.w_mat = new int[children];
      this.c_left = new ArrayList();
      this.c_right = new ArrayList(); 
      this.tot_w = 0;
      this.diff = max; // worst diff is the range(max, min)

   }
   public void readWeights(Scanner in)
   {
      for (int i = 0; i < num_w; i++)
      {
         w_mat[i] = in.nextInt();
         c_right.add(w_mat[i]);
         tot_w += w_mat[i];
      } 
      this.lookup = new int[tot_w + 1][num_w]; // seems like a hash table would
      // be better here because this uses a LOT of memory...
   }
   public void solve()
   {
      for (int i = 0; i < num_w; i++) //solving for all possible i
      {
         c_right.remove((Integer)w_mat[i]);
         c_left.add((Integer)w_mat[i]);
         solve(w_mat[i], i); // and all (2,3,4, ..) pairings of i
         c_left.remove((Integer)w_mat[i]); // return back to original
         c_right.add((Integer)w_mat[i]); 
      }
   }
   public void solve(int left, int ind)
   {
      //count++;
      lookup[left][ind] = 1; // save that we've done this solve(left,ind) before
      rest = tot_w - left; // the remaining weight
      if (abs(left - rest) < diff) //if it's a new best
      {
         diff = abs(left - rest);
         d_left = (ArrayList) c_left.clone();
         d_right = (ArrayList) c_right.clone();
         // update diff and d_left, d_right
      }
      int i = 1;
      while (ind + i < num_w)
      {
         if (lookup[left + w_mat[ind+i]][ind+i] == 0) // if we haven't done it
         {
            c_right.remove((Integer)w_mat[ind+i]);
            c_left.add((Integer)w_mat[ind+i]);
            solve(left + w_mat[ind+i], ind+i); // do combinations w/ 1 more ele
            c_left.remove((Integer)w_mat[ind+i]); // return back to original
            c_right.add((Integer)w_mat[ind+i]); 
         }
         i++;
      }
   }
   public void printSolution(PrintWriter out)
   {
      out.print("Team 1: ");
      for (int i = 0; i < d_left.size(); i++)
      {
         out.print(d_left.get(i) + " ");
      }
      out.println();
      out.print("Team 2: ");
      for (int i = 0; i < d_right.size(); i++)
      {
         out.print(d_right.get(i) + " ");
      }
      out.println();
      out.println("The weight difference is " + diff);
      //System.out.println("count is: " + count);
   }
}
