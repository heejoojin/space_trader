package lists;

import java.util.Iterator;

/**
 *
 * @author JaredWicklein
 */
public class UnorderedArrayList<T> implements UnorderedListADT<T>
{
    private int head, tail = 0;
    private final static int DEFAULT_CAPACITY = 100;
    private final static int NOT_FOUND = -1;
    private T[] myArray;
    
    public UnorderedArrayList()
    {
        myArray = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    @Override
    public void addToFront(T element)
    {
        //check if it's full
        if (tail == myArray.length)
        {
            expandArray();
        }
        
        //move everything over to make room at front
        for (int i = tail; i > 0; i--)
        {
            myArray[i] = myArray[i - 1];
        }
        
        //add the new item
        myArray[head] = element;
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
    public void addToRear(T element)
    {
        if (tail == myArray.length)
        {
            expandArray();
        }
        
        myArray[tail] = element;
        tail++;
    }
    
    @Override
    public void addAfter(T element, T target) throws Exception
    {
        //check if full
        if (tail==myArray.length)
        {
            expandArray();
        }
        
        //find target element
        
        int locationIndex = find(target);
        
        if(locationIndex == NOT_FOUND)
        {
            throw new Exception("Unordered Array List");
        }
        //make space for it
        for (int i = tail; i > locationIndex; i--)
        {
            myArray[i] = myArray[i-1];
        }
        
        //insert, update tail
        myArray[locationIndex + 1] = element;
        tail++;
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
        int elementLocation = find(element);
        
        if (elementLocation == NOT_FOUND)
        {
            throw new Exception("Element not found.");
        }
        
        result = myArray[elementLocation];
        tail--;
        
        for (int index = elementLocation; index < tail; index++)
        {
            myArray[index] = myArray[index + 1];
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
        return (tail == 0);
    }
    
    @Override
    public int size()
    {
        return tail;
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
    public Iterator iterator()
    {
       return new UnorderedArrayIterator();
    }
    
    private class UnorderedArrayIterator implements Iterator<T>
    {
        int currentIndex;
        
        public UnorderedArrayIterator()
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
