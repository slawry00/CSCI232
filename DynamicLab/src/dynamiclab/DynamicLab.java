/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiclab;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;
/**
 * Dynamic Programming
 * 11/23/18
 * @author Spencer Lawry
 */
public class DynamicLab 
{

   public static void main(String [] args)
   {
      int weightMax;
      int numberChildren;
      WeightMatrix weights;
      Scanner in = null;
      PrintWriter out = null;
      try
      {
         in = new Scanner (new File ("balanced.in"));
         out = new PrintWriter (new File ("balanced.out")); 
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Required file: balanced.in not found");
         System.exit(-1);
      }

      while (in.hasNext())
      {
         numberChildren = in.nextInt();
         weightMax = in.nextInt();
         weights = new WeightMatrix(numberChildren, weightMax);
         weights.readWeights(in);
         weights.solve();
         weights.printSolution(out);

         if (in.hasNext())
         {
            out.println();
         }

      }
      out.close();
   }

   
}