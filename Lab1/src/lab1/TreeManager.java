package lab1;

/**
 * Tree class
 * @author Spencer Lawry
 */
public class TreeManager<E extends Comparable>
{
    private Node<E> root;
    
    //public TreeManager() {}
    public TreeManager(Node<E> root)
    {
        this.root = root;
    }
    public TreeManager(E data)
    {
        this.root = new Node<E>(data);    
    }
    public Node<E> GetRoot()
    {
        return root;
    }
    public void Add(Node<E> new_node)
    {
        if (new_node.GetData().compareTo(root.GetData()) < 0)
        {
            if (root.GetLeft() == null)
            {
                root.SetLeft(new_node);
                new_node.SetParent(root);
            }
            else
            {
                TreeManager left_tree = new TreeManager(root.GetLeft());
                left_tree.Add(new_node);               
            }
        }
        else if (new_node.GetData().compareTo(root.GetData()) > 0)
        {
            if (root.GetRight() == null)
            {
                root.SetRight(new_node);
                new_node.SetParent(root);
            }
            else
            {
                TreeManager right_tree = new TreeManager(root.GetRight());
                right_tree.Add(new_node);
            }
        }            
    }
    public void Delete(Node<E> del_node)
    {
        if (del_node.GetData().compareTo(root.GetData()) == 0)
        { //found it! remove sequence begins
            if (root.GetParent() == null && root.GetRight() == null &&
                root.GetLeft() == null)
            { // removing the root of the tree with no children
                root = null;
                return;
            }
            else if(root.GetParent() == null)
            {// removing root with tree below.
             // rather than completely rewriting my delete sequence without
             // p_relate or a workaround, I will just handle the case in a
             // helper function
                DisposeOfOrphan();
                return;
                
            }
            //checking whether it is the left or right child of its parent
            int p_relate = root.GetData().compareTo(root.GetParent().GetData());
            
            if (root.GetLeft() == null && root.GetRight() == null)
            { //we are removing a leaf
                if (p_relate > 0)
                { //it is the right child
                    root.GetParent().SetRight(null);
                }
                else 
                { //it is the left child
                    root.GetParent().SetLeft(null);
                }
            }
            else if (root.GetLeft() == null)
            { // root has a right child
                root.GetRight().SetParent(root.GetParent()); //fix parent
                if (p_relate > 0)
                { //it is the right child, & it has a right child
                    root.GetParent().SetRight(root.GetRight());
                }
                else
                { //it is the left child, & it has a right child
                    root.GetParent().SetLeft(root.GetRight());
                } 
            } 
            else if (root.GetRight() == null)
            { //root has a left child
                root.GetLeft().SetParent(root.GetParent()); //fix parent
                if (p_relate > 0)
                { //it is the right child, & it has a left child
                    root.GetParent().SetRight(root.GetLeft());
                }
                else
                { //it is the left child, & it has a left child
                    root.GetParent().SetLeft(root.GetLeft());
                } 
            }
            else
            { // it has two children
                if (root.GetLeft().GetRight() == null)
                { // it has a left child with no right
                    
                    root.GetLeft().SetRight(root.GetRight());
                    // root.left adopts root.right
                    root.GetRight().SetParent(root.GetLeft()); // fix right par
                    root.GetLeft().SetParent(root.GetParent()); // fix left par
                    if (p_relate > 0)
                    {//it is a right child
                        root.GetParent().SetRight(root.GetLeft());
                    }
                    else
                    { // it is a left child
                        root.GetParent().SetLeft(root.GetLeft());
                    }
                }
                else
                {
                    // Find the rightmost node in the right subtree
                    // of left child. Copy its data into the local root's
                    // data and remove it by setting its parent to reference
                    // its left child
                    Node<E> right_most = GoRight(root.GetLeft());
                    root.SetData(right_most.GetData());
                    if (right_most.GetLeft() != null)
                    { //set right_most's left child to have right_most's
                      // parent instead
                        right_most.GetLeft().SetParent(right_most.GetParent());
                    }
                    right_most.GetParent().SetRight(right_most.GetLeft()); 
                }
            }
            
        }
        else
        {
            if (root.GetLeft() == null && root.GetRight() == null)
            {
                //dead end entirely (don't delete, just do nothing)
            }
            else if (root.GetLeft() == null)
            {
                TreeManager right_tree = new TreeManager(root.GetRight());
                right_tree.Delete(del_node);
            }
            else if (root.GetRight() == null)
            {
                TreeManager left_tree = new TreeManager(root.GetLeft());
                left_tree.Delete(del_node);
            }
            else 
            {
                if (del_node.GetData().compareTo(root.GetData()) < 0) 
                { // if it exists, it is to the left, so delete from there
                TreeManager left_tree = new TreeManager(root.GetLeft());
                left_tree.Delete(del_node); //delete from left
                }
                else
                { //if it exists, it is to the right, so delete from there
                TreeManager right_tree = new TreeManager(root.GetRight());
                right_tree.Delete(del_node); //delete from right
                }

            }
        }
    }
    /* finds the right-most node (delete helper function) */
    private Node GoRight(Node<E> gright)
    {
        if (gright.GetRight() == null)
        {
            return gright;
        }
        else
        {
            return GoRight(gright.GetRight());
        }
    }
    /* removes the root of the tree without the parent stuff (because it has
    no parents and is a sad orphan that I wish didn't exist) (delete helper) */
    private void DisposeOfOrphan()
    {

            if (root.GetLeft() == null)
            { // root has a right child only
                root.GetRight().SetParent(null);
                this.root = root.GetRight();

            } 
            else if (root.GetRight() == null)
            { //root has a left child only
                root.GetLeft().SetParent(null);
                this.root = root.GetLeft();
            }
            else
            { // it has two children
                if (root.GetLeft().GetRight() == null)
                {
                   // root has left child with no right child
                   root.GetLeft().SetParent(null);
                   root.GetRight().SetParent(root.GetLeft());
                   root.GetLeft().SetRight(root.GetRight());
                   this.root = root.GetLeft();

                }
                else
                {
                    // Find the rightmost node in the right subtree
                    // of left child. Copy its data into the local root's
                    // data and remove it by setting its parent to reference
                    // its left child
                    Node<E> right_most = GoRight(root.GetLeft());
                    root.SetData(right_most.GetData());
                    if (right_most.GetLeft() != null)
                    { //set right_most's left child to have right_most's
                      // parent instead
                        right_most.GetLeft().SetParent(right_most.GetParent());
                    }
                    right_most.GetParent().SetRight(right_most.GetLeft()); 
                }
            }
    }
    
    @Override
    public String toString()
    {
        return root.toString();
    }
      public String PreOrder()
    {
        return root.PreOrder();
    }
      public String InOrder()
    {
        return root.InOrder();
    }
      public String PostOrder()
    {
        return root.PostOrder();
    }
}
