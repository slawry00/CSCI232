package lab1;

/**
 * @author Spencer Lawry
 * Lab 1
 * Node Class
 */
public class Node<E>
{
    private E data;
    private Node<E> left;
    private Node<E> right;
    private Node<E> parent;

    public Node(E data) 
    {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        
    }
    
    public void SetData(E data)
    {
        this.data = data;
    }
    public E GetData()
    {
        return data;
    }
    public void SetLeft(Node<E> left)
    {
        this.left = left;
    }
    public Node GetLeft()
    {
        return left;
    }
    public void SetRight(Node<E> right)
    {
        this.right = right;
    }
    public Node GetRight()
    {
        return right;
    }

    public Node GetParent()
    {
        return parent;
    }
    public void SetParent(Node<E> parent)
    {
       this.parent = parent;
    }
    
    public String toString()
    {
        if (left == null && right == null)
        {
            return "Data: " + data + "left tree: null\n" + 
                   "right tree: null\n";
        }
        else if (left == null)
        {
            return "Data: " + data + "left tree: null\n" + 
                   "right tree: " + right.toString()+ "\n";
        }
        else if (right == null)
        {
            return "Data: " + data + "left tree: " + left.toString() + 
                   "right tree: null\n";
        }
        else 
        {
            return "Data: " + data + "left tree: " + left.toString()  +
                   "right tree: " + right.toString();
        }
    }
    public String PreOrder()
    {
        if (left == null && right == null)
        {
            return data.toString();
        }
        else if (left == null)
        {
            return data.toString() + right.PreOrder();
        }
        else if (right == null)
        {
            return data.toString() + left.PreOrder();
        }
        else 
        {
            return data.toString() + left.PreOrder()  +
                   right.PreOrder();
        }
    }
    public String InOrder()
    {
        if (left == null && right == null)
        {
            return data.toString();
        }
        else if (left == null)
        {
            return data.toString() + right.InOrder();
        }
        else if (right == null)
        {
            return left.InOrder() + data.toString();
        }
        else 
        {
            return left.InOrder() + data.toString() + 
                   right.InOrder();
        }
    }
    public String PostOrder()
    {
        if (left == null && right == null)
        {
            return data.toString();
        }
        else if (left == null)
        {
            return right.PostOrder() + data.toString();
        }
        else if (right == null)
        {
            return left.PostOrder() + data.toString();
        }
        else 
        {
            return left.PostOrder() + right.PostOrder() + 
                   data.toString();
        }
    }
}
