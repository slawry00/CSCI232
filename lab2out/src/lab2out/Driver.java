/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2out;
import java.io.*;
import java.util.*;

/**
 *
 * @author spencer
 */
public class Driver 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        /*
        Pair pair1 = new Pair(12, "cat");
        Pair pair2 = new Pair(7, "dog");
        Pair pair3 = new Pair(109, "fish");
        Pair pair4 = new Pair(23, "bear"); //should Molt() after this
        Pair pair5 = new Pair(43, "turtle");
        Pair pair6 = new Pair(1092, "wolf");   
        Pair pair7 = new Pair(531, "snake");  
        Pair pair8 = new Pair(236, "snail");  
        Hashtable ht = new Hashtable();
        ht.Add(pair1);
        ht.Add(pair2);
        ht.Add(pair3);
        //ht.Delete(7);
        //ht.Delete(12);
        ht.Add(pair4);
        ht.Add(pair5);
        ht.Add(pair6);
        ht.Add(pair7);
        ht.Delete(531);
        ht.Add(pair8);
        System.out.println(ht);
        //System.out.println(ht.Search(43));*/
        Hashtable ht = new Hashtable();
        try
        {
            InputStream in_file = new FileInputStream(args[0]);
            Scanner file_scanner = new Scanner(in_file);
            Scanner line_scanner;
            Pair new_pair;
            int pair_int;
            String pair_str;
            //int i = 0;
            
            while (file_scanner.hasNextLine())
            {
                line_scanner = new Scanner(file_scanner.nextLine());
                if (line_scanner.hasNext())
                {
                    pair_int = line_scanner.nextInt();
                    pair_str = line_scanner.next();
                    while (line_scanner.hasNext())
                    {
                        pair_str += " " + line_scanner.next();
                    }
                    new_pair = new Pair(pair_int, pair_str);
                    ht.Add(new_pair);
                   /*if (i == 14) //to check at certain points
                    {
                        System.out.println(ht);
                    }
                    i++;*/
                }
            }
            in_file.close();
            
        }
        catch(ArrayIndexOutOfBoundsException E)
        {
            System.err.println("You must provide an input file in format: " +
                               "java executable_file input_file");
        }
        System.out.println(ht);
    }
    
}
