package lab1;

/**
 * @author Spencer Lawry
 * Lab 1
 * Node Class
 */
public class Node<E>
{
    private E data;
    private Node left;
    private Node right;

    public Node(E data)
    {
        this.data = data;
    }
    
    public void SetData(E data)
    {
        this.data = data;
    }
    public E GetData()
    {
        return data;
    }
    public void SetLeft(Node left)
    {
        this.left = left;
    }
    public Node GetLeft()
    {
        return left;
    }
    public void SetRight(Node right)
    {
        this.right = right;
    }
    public Node GetRight()
    {
        return right;
    }
}
