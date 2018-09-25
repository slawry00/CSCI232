/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

/**
 * 9/24/2018
 * @author Spencer Lawry
 * CSCI232
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Heap my_heap = new Heap();
        my_heap.Add(12);
        my_heap.Add(45);
        my_heap.Add(21);
        my_heap.Add(5);
        my_heap.Add(21);
        my_heap.Add(10);
        my_heap.Add(3);
        my_heap.Add(55);
        my_heap.Add(15);
        my_heap.PrintHeap();
        my_heap.DeleteMin();
        my_heap.DeleteMin();
        my_heap.PrintHeap();
        my_heap.Add(32);
        my_heap.Add(6);
        my_heap.PrintHeap();
        my_heap.DeleteMin();
        my_heap.DeleteMin();
        my_heap.DeleteMin();
        my_heap.PrintHeap();
    }
    
}
