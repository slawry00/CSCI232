/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracklab;

import java.util.ArrayList;

/**
 * CSCI232
 * @author Spencer Lawry
 * 11/26/18
 */
public class MagicSquare 
{
    private int size;
    private int[] pos_nums;
    private int[] squares;
    private int m_num = 0;
    int found;
    
    public MagicSquare(int size)
    {
        this.size = size;
        this.squares = new int[(int)Math.pow(size, 2)];
        this.pos_nums = new int[squares.length];
        this.found = 0;
        
        for (int i = 0; i < squares.length; i++)
        {
            this.pos_nums[i] = i + 1;
            m_num += squares.length - i;
        }
        m_num = m_num/size;
    }
    public void solve()
    {
       solve(0);
    }
    public void solve(int ind) // = O(n^n) yikes...
    {
      for (int i = 0; i < squares.length; i++)
      {
         if (found == 1)
         {
            return; // fast track to return
         }
         if (pos_nums[i] != -1)
         {
            squares[ind] = pos_nums[i];
            //System.out.println("Added a num: " + pos_nums[i]);
            pos_nums[i] = -1;
            /*System.out.println("pos_nums is now: ");
            for (int n = 0; n < pos_nums.length; n++)
            {
                System.out.print(pos_nums[n] + " ");
            }
            System.out.println();
            print_solution();*/
            if (check_cols() && check_rows() && check_diags())
            {
               if (squares[(squares.length)-1] != 0 && check_diags_exact())
               {
                    //System.out.println(check_diags_exact());
                     System.out.println("The solution is:");
                     print_solution();
                     //System.out.println("exact_d is :" + check_diags_exact());
                     found = 1;
                     return;
               }
               if ((ind+1)%size == 0)
               {
                  if (check_rows_exact())
                  {
                     solve(ind+1);
                  }
               }
               /*else if ((ind+1)/size == size - 2)
               {
                  if (check_col_sum())
                  {
                     solve(ind+1);
                  }
               }*/
               else if ((ind+1)/size == size - 1)
               {
                  if (check_cols_exact((ind+1)%size))
                  {
                     solve(ind+1);
                  }
               }
               else
               {
                  solve(ind+1);
               }
            }
            //System.out.println("i is: " + i);
            pos_nums[i] = squares[ind];
            //System.out.println("Removed a num: " + squares[ind]);
            squares[ind] = 0;
            /*print_solution();
            System.out.println("pos_nums is now: ");
            for (int n = 0; n < pos_nums.length; n++)
            {
                System.out.print(pos_nums[n] + " ");
            }
            System.out.println();*/
         }
      }
    }
    public Boolean check_cols()
    {
        int run_sum = 0;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                run_sum += squares[i+(size*j)]; //add next in col
            }
            if (run_sum > m_num)
            {
                //System.out.println("FAIL COLS: ");
                //print_solution();
                return false;
            }
            run_sum = 0;
        }
        return true;
    }
    public Boolean check_cols_exact(int col)
    {
        int run_sum = 0;
        for (int i = 0; i < size; i++)
        {
            run_sum += squares[col+(size*i)]; //add next in col
            if (run_sum != m_num)
            {
               return false;
            }
            run_sum = 0;
        }
        return true;
    }
    /*public Boolean check_col_sum()
    {
        int run_sum = 0;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                run_sum += squares[i+(size*j)]; //add next in col
            }
            if (run_sum != m_num && run_sum != 0)
            {
               return false;
            }
            run_sum = 0;
        }
        return true;
    }*/
    
    public Boolean check_rows()
    {
        int run_sum = 0;
        for (int i = 0; i < size; i++)
        {      
            for (int j = 0; j < size; j++)
            {
                run_sum += squares[j+(size*i)]; // add next in row
            }
            if (run_sum > m_num)
            {
                //System.out.println("FAIL ROWS: ");
                //print_solution();
                return false;
            }
            run_sum = 0;
        }
        return true;
    }
    public Boolean check_rows_exact()
    {
        int run_sum = 0;
        for (int i = 0; i < size; i++)
        {      
            for (int j = 0; j < size; j++)
            {
                run_sum += squares[j+(size*i)]; // add next in row
            }
            if (run_sum != m_num && run_sum != 0)
            {
               return false;
            }
            run_sum = 0;
        }
        return true;
    }
    public Boolean check_diags()
    {
        int diag_sum1 = 0; // left to right
        int diag_sum2 = 0; // right to left
        
        for (int i = 0; i < size; i++)
        {
            diag_sum1 += squares[i+(size*i)];
            diag_sum2 += squares[(size-1)*(1+i)];
            if (diag_sum1 > m_num || diag_sum2 > m_num)
            {
                //System.out.println("FAIL DIAGS: ");
                //print_solution();
                return false;
            }
        }
        return true;
    }
    public Boolean check_diags_exact()
    {
      int diag_sum1 = 0; // left to right
      int diag_sum2 = 0; // right to left
        
         for (int i = 0; i < size; i++)
         {
            diag_sum1 += squares[i+(size*i)];
            diag_sum2 += squares[(size-1)*(1+i)];
            /*System.out.print("sum1: ");
            System.out.println(diag_sum1);
            System.out.print("sum2: ");
            System.out.println(diag_sum2);*/
         }
         if (diag_sum1 != m_num || diag_sum2 != m_num)
         {
            //System.out.println("FAIL DIAGS: ");
            //print_solution();
            //System.out.println("d_sum1 = " + diag_sum1);
            //System.out.println("d_sum2 = " + diag_sum2);
            return false;
         }
        return true;
    }
    void print_solution()
    {
        for (int i = 0; i < squares.length; i++)
        {
            if (i%size == 0 && i != 0)
            {
                System.out.println();
            }     
            System.out.print(squares[i] + " ");
        }
        System.out.println();
    }
}
