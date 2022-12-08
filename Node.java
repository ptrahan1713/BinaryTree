package binaryproblem1;
/**
 *
 * @author pattr
 */
public class Node<E>
{
    private Node left;
    private Node right;
    private E data;
    
    public Node(E userdata)
    {
        data = userdata;
        left = null;
        right = null;
    }
    
    public E getData()
    {
        return data;
    }
    
    public Node leftTree()
    {
        return left;
    }
    
    public Node rightTree()
    {
        return right;
    }
    
    public void setData(E userdata)
    {
        data = userdata;
    }
    
    public void setRight(Node userRight)
    {
        right = userRight;
    }
    
    public void setLeft(Node userLeft)
    {
        left = userLeft;
    }
    
    @Override
    public String toString()
    {
        return data.toString();
    }
}
