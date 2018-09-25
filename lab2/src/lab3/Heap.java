/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 * Spencer Lawry
 * @author w58z387
 *  9/24/2018
 */
public class Heap 
{
    int heap_array[];
    int min;
    int size;
    
    
    public Heap()
    {
        this.heap_array = new int[25];
    }
    public void Add(int num)
    {
        int i = 0;
        while (heap_array[i] != 0)
        {
            i++;
        }        
        heap_array[i] = num;
        size++;
        //now we need to fix the heap property
        int parent_i = 0; //initilize it to junk so the compiler
                          // will stop complaining. (doesn't matter)
        if (i != 0)
        {
            parent_i = FindParent(i);
        }
        while (i != 0 && heap_array[i] < heap_array[parent_i])
        {
            int temp = heap_array[parent_i];
            heap_array[parent_i] = heap_array[i];
            heap_array[i] = temp;
            i = parent_i;
            if (i != 0)
            {
                parent_i = FindParent(i);
            }
        }
    }
    private int FindParent(int i)
    {   
        int parent_i;
        Boolean is_even = i%2 == 0;
        if (is_even)
        {
            parent_i = (i-2)/2;
        }
        else
        {
            parent_i = (i-1)/2;
        }
        return parent_i;
    }

    public void DeleteMin()
    {
        if (size == 0 || size == 1)
        {
            heap_array[0] = 0;
        }
        else
        {
            heap_array[0] = heap_array[size-1]; //root = last element added
            heap_array[size-1] = 0; //remove last element
            size--;
            int i = 0;
            //int child_i = 0; //initialize to 0 for compiler
            //int sibling_i = 0; //initialize to 0 for compiler
            //if ((i*2)+1 < heap_array.length)
            int child_i = FindLeftChild(i);   
            int sibling_i = child_i +1;
            
            while (sibling_i < 25 && heap_array[child_i] !=0 &&
                  ((heap_array[i] > heap_array[child_i]) || 
                   ((heap_array[i] > heap_array[sibling_i]) &&
                    heap_array[sibling_i] != 0)))
            {
                int temp = heap_array[i]; //save parent value
                if (heap_array[child_i] < heap_array[sibling_i] ||
                    heap_array[sibling_i] == 0)
                {
                    heap_array[i] = heap_array[child_i];
                    heap_array[child_i] = temp;
                    i = child_i;
                    child_i = FindLeftChild(i);
                    sibling_i = child_i + 1;
                }
                else
                {
                    heap_array[i] = heap_array[sibling_i];
                    heap_array[sibling_i] = temp;
                    i = sibling_i;
                    child_i = FindLeftChild(i);
                    sibling_i = child_i + 1;
                }
            }
        }

    }
    private int FindLeftChild(int i)
    {   
        return i*2 + 1;
    }
    public void PrintHeap()
    {
        for (int i = 0; heap_array[i] != 0; i++)
        {
            System.out.print(heap_array[i] + " ");
        }
        System.out.println();
    }
}
