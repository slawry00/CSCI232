/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2out;

/**
 *
 * @author spencer
 */
public class Pair 
{
    private int key;
    private String value;
    
    public Pair(int key, String value)
    {
        this.key = key;
        this.value = value;
    }
    public int GetKey()
    {
        return this.key;
    }
        public String GetValue()
    {
        return this.value;
    }
    @Override
    public String toString()
    {
        return "("+key+","+value+")";
    }
}
