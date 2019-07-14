package lists;

import java.util.Iterator;

/**
 *
 * @author JaredWicklein
 */
public class UnorderedLinkedList<T> implements UnorderedListADT<T>
{
    LinearNode<T> head;
    LinearNode<T> tail;
    int size = 0;
    
    LinearNode<T> notFound = null;
    
    public UnorderedLinkedList()
    {
        head = null;
        tail = null;
    }
    
    @Override
    public void addToFront(T element)
    {
        if (isEmpty())
        {
            LinearNode<T> pointer = new LinearNode<T>((T) element);
            head = pointer;
            tail = pointer;
        }
        
        else
        {
            LinearNode<T> pointer = new LinearNode<T>((T) element);
            pointer.setNext(head);
            head = pointer;
        }
        size++;
    }
    
    @Override
    public void addToRear(T element)
    {
        if (isEmpty())
        {
            LinearNode<T> pointer = new LinearNode<T>((T) element);
            head = pointer;
            tail = pointer;
        }
        
        else
        {
            LinearNode<T> pointer = new LinearNode<T>((T) element);
            tail.setNext(pointer);
            tail = pointer;
        }
        
        size++;
    }
    
    private LinearNode<T> find(T element)
    {
        LinearNode<T> returnNode = head;
        
        while (returnNode != null)
        {
            if (returnNode.getElement().equals(element))
            {
                return returnNode;
            }
            
            else
            {
                returnNode = returnNode.getNext();
            }
        }
        
        return notFound;
    }
    
    @Override
    public void addAfter(T element, T target) throws Exception
    {
        LinearNode<T> locationNode = find(target);
        
        if (locationNode == notFound)
        {
            throw new Exception("UnorderedArrayList");
        }
        
        LinearNode<T> pointer = new LinearNode<T>((T) element);
        pointer.setNext(locationNode.getNext());
        locationNode.setNext(pointer);
        size++;
    }
    
    @Override
    public T removeFirst()
    {   
        T result = head.getElement();
        
        if (size == 1)
        {
            head = tail = null;
        }
        
        else
        {
            head = head.getNext();
        }
        size--;
        return result;
    }
    
    @Override
    public T removeLast()
    {
        T result = tail.getElement();
        
        if (size == 1)
        {
            head = tail = null;
        }
        
        else
        {
            LinearNode<T> temp = head;
            while (temp.getNext().getNext() != null)
            {
                temp = temp.getNext();
            }
            
            temp.setNext(null);
        }
        size--;
        return result;
    }
    
    @Override
    public T remove(T element) throws Exception
    {
        LinearNode<T> locationNode = find(element);
        
        if (locationNode == notFound)
        {
            throw new Exception("Element not found");
        }
        
        T result = locationNode.getElement();
        
        if (size() == 1)
        {
            head = tail = null;
        }
        
        else if (locationNode.equals(head))
        {
            removeFirst();
        }
        
        else if (locationNode.equals(tail))
        {
            removeLast();
        }
        
        else
        {
            LinearNode<T> temp = head;
            while (temp.getNext() != locationNode)
            {
                temp = temp.getNext();
            }
            
            temp.setNext(locationNode.getNext());
        }
        
        size--;
        return result;
    }
    
    @Override
    public T first()
    {
        return head.getElement();
    }
    
    @Override
    public T last()
    {
        return tail.getElement();
    }
    
    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    @Override
    public int size()
    {
        return size;
    }
    
    @Override
    public boolean contains(T element)
    {
        if (find(element) == notFound)
        {
            return false;
        }
        
        else
        {
            return true;
        }
    }
    
    @Override
    public String toString()
    {
        String returnString = "";
        returnString += "Front << ";
        
        LinearNode<T> myNodeRef = head;
        
        while(myNodeRef != null)
        {
            returnString += myNodeRef.getElement() + " ";
            myNodeRef = myNodeRef.getNext();
        }
        
        returnString += ">> Back";
        return returnString;
    }
    
    @Override
    public Iterator<T> iterator()
    {
        return new UnorderedLinkedIterator();
    }
    
    private class UnorderedLinkedIterator implements Iterator<T>
    {
        LinearNode<T> currentNode;
        
        public UnorderedLinkedIterator()
        {
            currentNode = head;
        }
        
        @Override
        public boolean hasNext()
        {
            return (currentNode.getNext() != null);
        }
        
        @Override
        public T next()
        {
            return currentNode.getNext().getElement();
        }
    }
}
