package lab1;

/**
 * Lab 1
 * Coffee Class
 * @author Spencer Lawry
 */
public class Coffee implements Comparable
{
    private double Price;
    private String Color;
    private String Company;
    
    public Coffee(double price, String color, String company)
    {
        this.Price = price;
        this.Color = color;
        this.Company = company;
    }
    public String toString()
    {
        return "Price: "+Price+"\nColor "+Color+"\nCompany: "+Company+"\n";
    }
    public int compareTo(Object coffee)
    {
        return 1; //needs to be finished
    }
}
