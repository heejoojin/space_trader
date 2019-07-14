package lists;

import java.util.Iterator;

/**
 *
 * @author JaredWicklein
 *
 */
public class OrderedArrayList<T> implements OrderedListADT<T>
        
{
    private int head, tail = 0;
    private final static int DEFAULT_CAPACITY = 10;
    
    private final static int NOT_FOUND = -1;
    private T[] myArray;
    
    public OrderedArrayList()
    {
        myArray = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    @Override
    public void add(T element) throws Exception
    {
        //check if element is comparable
        
        if (!(element instanceof Comparable))
        {
            throw new Exception("Bad things happened");
        }
        
        Comparable comparableElement = (Comparable) element;
        
        //expand array if full
        
        if (tail == myArray.length)
        {
            expandArray();
        }
        
        //search for correct spot
        int insertPosition;
        for (insertPosition = 0; insertPosition < tail && comparableElement.compareTo(myArray[insertPosition]) > 0; insertPosition++)
        {
            //empty on purpose
        }
        
        //shift elements over
        
        for (int i = tail; i > insertPosition; i--)
        {
            myArray[i] = myArray[i - 1];
        }
        
        //place the element
        
        myArray[insertPosition] = element;
        tail++;
    }
    
    private void expandArray()
    {
        T[] newArray = (T[]) new Object[myArray.length * 2];
        
        for (int i = head; i < myArray.length; i++) //fuck off netbeans
        {
            newArray[i] = myArray[i];
        }
        
        myArray = newArray;
    }
    
    @Override
    public T removeFirst()
    {
        T result = myArray[head];
        
        for (int index = head; index < tail; index++)
        {
            myArray[index] = myArray[index + 1];
        }
        
        tail--;
        myArray[tail] = null;
        return result;
    }
    
    @Override
    public T removeLast()
    {
        T result = myArray[tail - 1];
        
        tail--;
        myArray[tail] = null;
        
        return result;
    }
    
    @Override
    public T remove(T element) throws Exception
    {
        T result;
        int index = find(element);
        
        if (index == NOT_FOUND)
        {
            throw new Exception("Element not found.");
        }
        
        result = myArray[index];
        tail--;
        
        for (int scan = index; scan < tail; scan++)
        {
            myArray[scan] = myArray[scan + 1];
        }
        myArray[tail] = null;
        return result;
    }
    
    @Override
    public T first()
    {
        return myArray[head];
    }
    
    @Override
    public T last()
    {
        return myArray[tail - 1];
    }
    
    @Override
    public boolean isEmpty()
    {
        return tail==0;
    }
    
    @Override
    public int size()
    {
        return tail;
    }
    
    private int find(T element)
    {
        for(int i = head; i < tail; i++)
        {
            if (myArray[i].equals(element))
            {
                return i;
            }
        }
        
        return NOT_FOUND;
    }
    
    @Override
    public boolean contains(T element)
    {
        if (find(element) == NOT_FOUND)
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
        String returnString = "<HEAD> ";
        
        for (int i = head; i < tail; i++)
        {
            returnString += myArray[i] + " ";
        }
        
        returnString += "<TAIL>";
        return returnString;
    }
    
    @Override
    public Iterator iterator()
    {
       return new OrderedArrayIterator();
    }
    
    private class OrderedArrayIterator implements Iterator<T>
    {
        int currentIndex;
        
        public OrderedArrayIterator()
        {
            currentIndex = head;
        }
        
        @Override
        public boolean hasNext()
        {
            return currentIndex < tail;
        }
        
        @Override
        public T next()
        {
            return myArray[currentIndex++];
        }
        
    }
}

