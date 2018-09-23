package lab1;

/**
 * @author Spencer Lawry
 * 9/10/2018
 * CSCI 232
 */
public class Driver 
{

    public static void main(String[] args) 
    {
        Node node1 = new Node(new Coffee(70, "black", "yummy"));
        Node node2 = new Node(new Coffee(40, "black", "yummy"));
        Node node3 = new Node(new Coffee(30, "black", "yummy"));
        Node node4 = new Node(new Coffee(60, "black", "yummy"));
        Node node5 = new Node(new Coffee(65, "black", "yummy"));
        Node node6 = new Node(new Coffee(50, "black", "yummy"));
        Node node7 = new Node(new Coffee(55, "black", "yummy"));
        Node node8 = new Node(new Coffee(45, "black", "yummy"));
        Node node9 = new Node(new Coffee(43, "black", "yummy"));
        Node node10 = new Node(new Coffee(47, "black", "yummy"));
        Node node11 = new Node(new Coffee(46, "black", "yummy"));
        TreeManager tree1 = new TreeManager(node1);
        tree1.Add(node2);
        tree1.Add(node3);
        tree1.Add(node4);
        tree1.Add(node5);
        tree1.Add(node6);
        tree1.Add(node7);
        tree1.Add(node8);
        tree1.Add(node9);
        tree1.Add(node10);
        tree1.Add(node11);
        tree1.Delete(node10);
        tree1.Delete(node6);
        tree1.Delete(node1);
        tree1.Delete(node2);
        tree1.Delete(node3);
        tree1.Delete(node11);
        tree1.Delete(node4);
        System.out.println(tree1.PreOrder());
        System.out.println(tree1.InOrder());
        System.out.println(tree1.PostOrder());
        tree1.Delete(node7);
        System.out.println(tree1.PreOrder()); //still works
        
        
       
    }
    
}
