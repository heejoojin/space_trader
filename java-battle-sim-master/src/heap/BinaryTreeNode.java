package heap;

/**
 *
 * @author JaredWicklein
 */
public class BinaryTreeNode<T>
{
    protected T element;
    protected BinaryTreeNode<T> left, right;
    
    public BinaryTreeNode(T element)
    {
        this.element = element;
    }
    
    public BinaryTreeNode(T element, BinaryTreeNode<T> left, BinaryTreeNode<T> right)
    {
        this.element = element;
        this.left = left;
        this.right = right;
    }
    
    public T getElement()
    {
        return element;
    }
    
    public void setElement(T element)
    {
        this.element = element;
    }
    
    public BinaryTreeNode<T> getLeft()
    {
        return left;
    }
    
    public BinaryTreeNode<T> getRight()
    {
        return right;
    }
    
    public void setLeft(BinaryTreeNode<T> BTNode)
    {
        this.left = BTNode;
    }
    
    public void setRight(BinaryTreeNode<T> BTNode)
    {
        this.right = BTNode;
    }
    
    public int numChildren()
    {
        int numChildren = 0;
        
        if (left != null)
        {
            numChildren++;
        }
        
        if (right != null)
        {
            numChildren++;
        }
        
        return numChildren;
    }
}
