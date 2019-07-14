package heap;

/**
 *
 * @author JaredWicklein
 */
public class LinkedBinarySearchTree<T> implements BinarySearchTreeADT<T>
{
    private BinaryTreeNode<T> root;
    
    
    public LinkedBinarySearchTree()
    {
        root = null;
    }
    
    public LinkedBinarySearchTree(T element)
    {
        BinaryTreeNode<T> root = new BinaryTreeNode<T>(element);
        this.root = root;
    }
    
    public LinkedBinarySearchTree(BinaryTreeNode<T> root)
    {
        this.root = root;
    }
    
    @Override
    public void addElement(T element) throws NonComparableElementException, DuplicateElementException
    {
        if (!(element instanceof Comparable))
        {
            throw new NonComparableElementException("Elements in a binary search tree must be comparable.");
        }
        
        if (contains(element))
        {
            throw new DuplicateElementException("That element already exists in the tree.");
        }
                
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if (isEmpty())
        {
            root = new BinaryTreeNode<>(element);
        }
        else
        {
          
            
            if (comparableElement.compareTo(root.getElement()) < 0)
            {
                if (root.getLeft() == null)
                {
                    this.root.setLeft(new BinaryTreeNode<T>(element));
                }
                else
                {
                    addElement(element, root.getLeft());
                }
            }
            else
            {
                if (root.getRight() == null)
                {
                    this.root.setRight(new BinaryTreeNode<T>(element));
                }
                else
                {
                    addElement(element, root.getRight());
                }
            }
        }
    }
    
    private void addElement(T element, BinaryTreeNode<T> node)
    {
        Comparable<T> comparableElement = (Comparable<T>)element;
        
   
        if (comparableElement.compareTo(node.getElement()) < 0)
        {
            if (node.getLeft() == null)
            {
                node.setLeft(new BinaryTreeNode<T>(element));
            }
            else
            {
                addElement(element, node.getLeft());
            }
        }
        else
        {
            if (node.getRight() == null)
            {
                node.setRight(new BinaryTreeNode<T>(element));
            }
            else
            {
                addElement(element, node.getRight());
            }
        }
    }
    
    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException
    {
        T result = null;
        
        if (isEmpty())
        {
            throw new ElementNotFoundException("Tree is empty!");
        }
        else
        {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>)targetElement).equals(root.element))
            {
                result = root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null)
                {
                    root = null;
                }
                else
                {
                    root.element = temp.element;
                    root.setRight(temp.right);
                    root.setLeft(temp.left);
                }
            }
            else
            {
                parent = root;
                if(((Comparable)targetElement).compareTo(root.element) < 0)
                {
                    result = removeElement(targetElement, root.getLeft(), parent);
                }
                else
                {
                    result = removeElement(targetElement, root.getRight(), parent);
                }
            }
        }
        
        return result;
    }
    
    private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent) throws ElementNotFoundException
    {
        T result = null;
        
        if (node == null)
        {
            throw new ElementNotFoundException("Element not found.");
        }
        else
        {
            if (((Comparable<T>)targetElement).equals(node.element))
            {
                result = node.element;
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.right == node)
                {
                    parent.right = temp;
                }
                else
                {
                    parent.left = temp;
                }
                //modcount
            }
            else
            {
                parent = node;
                if (((Comparable)targetElement).compareTo(node.element) < 0)
                {
                    result = removeElement(targetElement, node.getLeft(), parent);
                }
                else
                {
                    result = removeElement(targetElement, node.getRight(), parent);
                }
            }
        }
        return result;
    }
    
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node)
    {
        BinaryTreeNode<T> result = null;
        
        if ((node.left == null) && (node.right == null))
        {
            result = null;
        }
        
        else if ((node.left != null) && (node.right) == null)
        {
            result = node.left;
        }
        
        else if ((node.left == null) && (node.right != null))
        {
            result = node.right;
        }
        
        else
        {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            
            while(current.left != null)
            {
                parent = current;
                current = current.left;
            }
            
            current.left = node.left;
            if (node.right != current)
            {
                parent.left = current.right;
                current.right = node.right;
            }
            
            result = current;
        }
        return result;
    }
    
    @Override
    public void removeAllOccurrences(T targetElement) throws ElementNotFoundException
    {
        removeElement(targetElement);
        
        try
        {
            while (contains((T)targetElement))
            {
                removeElement(targetElement);
            }
        }
        catch (Exception ElementNotFoundException)
        {
        }
    }
    
    @Override
    public T removeMin() throws EmptyCollectionException
    {
        T result = null;
        
        if (isEmpty())
        {
            throw new EmptyCollectionException("Tree is empty!");
        }
        else
        {
            if (root.left == null)
            {
                result = root.element;
                root = root.right;
            }
            else
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while(current.left != null)
                {
                    parent = current;
                    current = current.left;
                }
                result = current.element;
                parent.left = current.right;
            }
            //modcount -1
        }
        return result;
    }
    
    @Override
    public T removeMax() throws EmptyCollectionException
    {
        T result = null;
        
        if (isEmpty())
        {
            throw new EmptyCollectionException("Tree is empty!");
        }
        else
        {
            if (root.right == null)
            {
                result = root.element;
                root = root.left;
            }
            else
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.right;
                while(current.right != null)
                {
                    parent = current;
                    current = current.right;
                }
                result = current.element;
                parent.right = current.left;
            }
        }
        return result;
    }
    
    @Override
    public T findMin() throws ElementNotFoundException
    {
        if (root == null)
        {
            //throw exception
            throw new ElementNotFoundException("Tree has no root!");
        }
        else
        {
            return findMin(root);
        }
        
        
    }
    
    private T findMin(BinaryTreeNode<T> node)
    {
        if (node.getLeft() == null)
        {
            return node.getElement();
        }
        else
        {
            return findMin(node.getLeft());
        }
    }
    
    @Override
    public T findMax() throws ElementNotFoundException
    {
        if (root == null)
        {
            throw new ElementNotFoundException("Tree has no root!");
        }
        else
        {
            return findMax(root);
        }
    }
    
    private T findMax(BinaryTreeNode<T> node)
    {
        if (node.getRight() == null)
        {
            return node.getElement();
        }
        else
        {
            return findMax(node.getRight());
        }
    }
    
    @Override
    public T getRootElement()
    {
        return root.getElement();
    }
    
    @Override
    public boolean isEmpty()
    {
        return (root == null);
    }
    
    @Override
    public int size() //what does this return
    {
        return size(root);
    }
    
    private int size(BinaryTreeNode<T> node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }
    
    @Override
    public boolean contains(T targetElement)
    {
        try
        {
            find(targetElement);
        }
        catch (Exception ElementNotFoundException)
        {
            return false;
        }
        return true;
    }
    
    @Override
    public T find(T targetElement) throws ElementNotFoundException
    {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        
        if (current == null)
        {
            throw new ElementNotFoundException("Element not found.");
        }
        
        return (current.getElement());
    }
    
    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next)
    {
        if (next == null)
        {
            return null;
        }
        
        if (next.getElement().equals(targetElement))
        {
           return next; 
        }
        
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        
        if (temp == null)
        {
            temp = findNode(targetElement, next.getRight());
        }
        
        return temp;
    }
    
    @Override
    public void print_inOrder()
    {
        if (isEmpty())
        {
            System.out.println("Empty tree.");
        }
        else
        {
            print_inOrder(root);
        }
    }
    
    private void print_inOrder(BinaryTreeNode<T> node)
    {
        
        if (node.getLeft() != null)
        {
            print_inOrder(node.getLeft());
        }
        
        System.out.println(node.getElement().toString());
        
        if (node.getRight() != null)
        {
            print_inOrder(node.getRight());
        }
        
    }
    
}
