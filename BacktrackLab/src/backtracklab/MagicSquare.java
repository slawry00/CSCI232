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
    private ArrayList<Integer> pos_nums;
    private int[] squares;
    private int m_num = 0;
    
    public MagicSquare(int size)
    {
        this.size = size;
        this.squares = new int[(int)Math.pow(size, 2)];
        this.pos_nums = new ArrayList();
        
        for (int i = 0; i < squares.length; i++)
        {
            this.pos_nums.add(i + 1);
            m_num += squares.length - i;
        }
        m_num = m_num/size;
    }
    public void solve()
    {
        solve(0);
    }
    public void solve(int ind)
    {
        
        for (int i = 0; i < pos_nums.size(); i++)
        {
            squares[ind] = pos_nums.get(i);
            //System.out.println("Added a num: " + pos_nums.get(i));
            pos_nums.remove(i);
            /*System.out.println("pos_nums is now: ");
            for (int n = 0; n < pos_nums.size(); n++)
            {
                System.out.print(pos_nums.get(n) + " ");
            }
            System.out.println();
            print_solution();*/
            if (check_cols() && check_rows() && check_diags())
            {
                if (squares[(squares.length)-1] != 0)
                {
                    System.out.println("The solution is:");
                    print_solution();
                    break;
                }
                solve(ind+1);
                pos_nums.add(squares[ind+1]);
                squares[ind+1] = 0;
            }
            else
            {
                //System.out.println("i is: " + i);
                pos_nums.add(squares[ind]);
                //System.out.println("Removed a num: " + squares[ind]);
                squares[ind] = 0;
                /*print_solution();
                System.out.println("pos_nums is now: ");
                for (int n = 0; n < pos_nums.size(); n++)
                {
                    System.out.print(pos_nums.get(n) + " ");
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
    public Boolean check_diags()
    {
        int run_sum = 0;
        for (int i = 0; i < size; i++)
        {
            run_sum += squares[i+(size*i)];
            if (run_sum > m_num)
            {
                //System.out.println("FAIL DIAGS: ");
                //print_solution();
                return false;
            }
            run_sum = 0;
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
