package lab1;

/**
 * Lab 1
 * Coffee Class
 * @author Spencer Lawry
 */
public class Coffee implements Comparable
{
    private double price;
    private String color;
    private String company;
    
    public Coffee(double price, String color, String company)
    {
        this.price = price;
        this.color = color;
        this.company = company;
    }
    @Override
    public String toString()
    {
        return "Price: "+price+" Color: "+color+" Company: "+company+"\n";
    }
    @Override
    public int compareTo(Object coff)
    {
        Coffee other_coff = (Coffee)coff;
        if (price < other_coff.price)
        {
            return -1;
        }
        else if (price == other_coff.price)
        {
            if (company.compareTo(other_coff.company ) < 0)
            {
                return -1;
            }
            else if (company.compareTo(other_coff.company) == 0)
            {
                if (color.compareTo(other_coff.color ) < 0)
                {
                    return -1;
                }
                else if (color.compareTo(other_coff.color ) == 0)
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
            else
            {
                return 1;
            }
        }
        else
        {
            return 1;
        }
    }
        
        
        
}

