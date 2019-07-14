package lists;

import java.util.Iterator;

/**
 *
 * @author JaredWicklein
 */
public class OrderedLinkedList<T> implements OrderedListADT<T>
{
    LinearNode<T> head;
    LinearNode<T> tail;
    int size = 0;
    
    LinearNode<T> notFound = null;
    
    public OrderedLinkedList()
    {
        head = null;
        tail = null;
    }
    
    @Override
    public void add(T element) throws Exception
    {
        //check if element is comparable
        
        if (!(element instanceof Comparable))
        {
            throw new Exception("Bad things happened");
        }
        
        LinearNode<T> pointer = new LinearNode<T>((T) element);
        
        if (size == 0)
        {
            head = pointer;
            tail = pointer;
        }
        
        else
        {
            Comparable comparableElement = (Comparable) element;
            
            if (comparableElement.compareTo(head.getElement()) < 0)
            {
                pointer.setNext(head);
                head = pointer;
            }
            
            else
            {
                LinearNode<T> locationNode = head;
                LinearNode<T> nodeAfterLocation = head.getNext();
                
                while (nodeAfterLocation != null)
                {
                    if (comparableElement.compareTo(nodeAfterLocation.getElement()) < 0)
                    {
                        break;
                    }
                    
                    locationNode = nodeAfterLocation;
                    nodeAfterLocation = nodeAfterLocation.getNext();
                    
                }
                
                pointer.setNext(locationNode.getNext());
                locationNode.setNext(pointer);
            }
        }
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
        return new OrderedLinkedIterator();
    }
    
    private class OrderedLinkedIterator implements Iterator<T>
    {
        LinearNode<T> currentNode;
        
        public OrderedLinkedIterator()
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
