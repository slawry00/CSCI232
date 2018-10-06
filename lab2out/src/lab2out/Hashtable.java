/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2out;

/**
 * CSCI 232
 * 10/5/2018 
 * @author Spencer Lawry
 */
public class Hashtable 
{
   private Pair[] hash_array;
   private int size;
   
   public Hashtable()
   {
       this.hash_array = new Pair[5];
       this.size = 0;
   }
   
   public void Molt()
   {
       Pair[] temp = this.hash_array;
       this.hash_array = new Pair[temp.length * 2]; //new array of Pairs
       size = 0; //reset size so we can re-add the elements
       for (int i = 0; i < temp.length; i++)
       {
           if (temp[i] != null && !(temp[i].GetValue().equals("deleted")))
           {
               Add(temp[i]);
           }
       }         
   }
   public void Add(Pair elem)
   {
       int hash = elem.GetKey()%(hash_array.length);
       int safety_net = hash; //to make sure it doesn't go in circles
       while (hash_array[hash] != null)
       {
           hash++;
           if (hash == safety_net)
           {
               System.out.println("Your array is full dummy");
               return; // no space in the array
           }
           else if (hash >= hash_array.length)
           {
               hash = (hash)%(hash_array.length); // need to circle back
           }
       }

        hash_array[hash] = elem;
        this.size++;
        if ((double) size /hash_array.length >= 0.8)
        {
            Molt();
        }
   }
   public String Search(int key)
   {
       int hash = (key)%(hash_array.length);
       int safety_net = hash;
       while (hash_array[hash] != null)
       {
           if (hash_array[hash].GetKey() == key)
           {
               return hash_array[hash].GetValue();
           }
           hash++;
           if (hash >= hash_array.length)
           {
               hash = (hash)%(hash_array.length); // need to circle back
           }
           if (hash == safety_net) //array is full and didn't find key
           {
               System.out.println("You didn't find it and your " +
                                  "array is full dummy");
               return null; 
           }
       }
       return null; //didn't find it
   }
   public void Delete(int key) //same as search function except it deletes
   {
       int hash = (key)%(hash_array.length);
       int safety_net = hash;
       while (hash_array[hash] != null)
       {
           if (hash_array[hash].GetKey() == key)
           {
               hash_array[hash] = new Pair(-1, "deleted"); //flag it as deleted
           }
           hash++;
           if (hash >= hash_array.length)
           {
               hash = (hash)%(hash_array.length); // need to circle back
           }
           if (hash == safety_net) //array is full and didn't find key
           {
               System.out.println("You didn't find it and your " +
                                  "array is full dummy");
               return;
           }
       }
   }
   
   @Override
   public String toString()
   {
       String str = "";
       for (int i = 0; i < hash_array.length; i++)
       {
           str += i+ ": " + hash_array[i] + "\n";
       }
       return str;
   }
}
