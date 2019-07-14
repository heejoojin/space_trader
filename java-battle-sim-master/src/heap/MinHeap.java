package heap;

/**
 *
 * @author JaredWicklein
 */
public class MinHeap<T extends Comparable<T>> implements HeapADT<T>
{
    
    //root at 0, left child at
    
    private T[] myArray;
    private final int startingArrayCapacity = 10;
    private int size;
    //private ExecutionCounter counter;
    
    public MinHeap()
    {
        myArray = (T[]) new Comparable[startingArrayCapacity];
        size = 0;
      //  counter = new ExecutionCounter();
    }
    
    @Override
    public void addElement(T obj)
    {
        if (size == myArray.length)
        {
            T[] tempArray = (T[]) new Comparable[2 * myArray.length];
            
            for (int i = 0; i < myArray.length; i++)
            {
                tempArray[i] = myArray[i];
            }
            myArray = tempArray;
        }
        
        myArray[size] = obj;
        
        percolateUp(size); //swap new element up until condition is met.
        
        size++;
    }
    
    private void percolateUp(int startingIndex)
    {
        //base case 1 = we're at the root
        //base case 2 = parent is of higher.
        
        if (startingIndex == 0)
        {
            return;
        }
        
        //find parent aand compare priorities
        //parentindex = (childindex - 1) / 2
        
        int parentIndex = (startingIndex - 1) / 2;
        
//        counter.incrementCounter();
        if(myArray[parentIndex].compareTo(myArray[startingIndex]) > 0)
        {
            //swaparoo.
            T temp = myArray[parentIndex];
            myArray[parentIndex] = myArray[startingIndex];
            myArray[startingIndex] = temp;
            percolateUp(parentIndex);
        }
        else
        {
            //This is fine.
            return;
        }
    }
    
    @Override
    public T removeMin() throws EmptyCollectionException
    {
        if (this.isEmpty() == true)
            
        {
            throw new EmptyCollectionException("pls");
        }
        T returnValue=myArray[0];
        
        myArray[0] = myArray[size - 1];
        
        size--;
        
        percolateDown(0);
        
        return returnValue;
    }
    
    private void percolateDown(int startingIndex)
    {
        //base case 1 = leaf node
        //base case 2 = both children are lower priority
        
        int leftChildIndex = 2 * startingIndex + 1;
        int rightChildIndex = 2 * startingIndex + 2;
        
        if(leftChildIndex >= size && rightChildIndex >= size)
        {
            return;
        }
        
        else if (rightChildIndex >= size && myArray[leftChildIndex].compareTo(myArray[startingIndex]) > 0)
        {
//            counter.incrementCounter();
            return;
        }
        else if (myArray[leftChildIndex].compareTo(myArray[startingIndex]) > 0 && myArray[rightChildIndex].compareTo(myArray[startingIndex]) > 0)
        {
  //          counter.incrementCounter();
    //        counter.incrementCounter();
            return;
        }
        else
        {
      //      counter.incrementCounter();
        //    counter.incrementCounter();
            
            int smallestChild = leftChildIndex;
            
          //  counter.incrementCounter();
            if(rightChildIndex < size && myArray[rightChildIndex].compareTo(myArray[leftChildIndex]) <= 0)
            {
                //swap
                smallestChild = rightChildIndex;
            }
            
            T temp = myArray[startingIndex];
            myArray[startingIndex] = myArray[smallestChild];
            myArray[smallestChild] = temp;
            
            percolateDown(smallestChild);
        }
    }
    
    @Override
    public T findMin() throws EmptyCollectionException
    {
        return getRootElement();
    }
    
    @Override
    public T getRootElement()
    {
        return myArray[0];
    }
    
    @Override
    public boolean isEmpty()
    {
        return (size() == 0);
    }
    
    @Override
    public int size()
    {
        return size;
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
        int targetIndex = find(targetElement, 0);
        
        if (targetIndex == -1)
        {
            throw new ElementNotFoundException("Target not found.");
        }
        
        return myArray[targetIndex];
    }
    
    private int find(T targetElement, int index)
    {
        if (myArray[index] == null)
        {
            return -1;
        }
        
        if (myArray[index].equals(targetElement))
        {
            return index;
        }
        
        int temp = find(targetElement, 2 * index + 1);
        
        if (temp == -1)
        {
            temp = find(targetElement, 2 * index + 2);
        }
        
        return temp;
    }
    
    @Override
    public void print_inOrder()
    {
        print_inOrder(0);
    }
    
    private void print_inOrder(int index)
    {
        if ((2 * index + 1) < myArray.length)
        {
            if (myArray[2 * index + 1] != null)
            {
                print_inOrder(2 * index + 1);
            }
        }
        
        System.out.print(myArray[index] + " ");
        
        if (2 * (index + 1) < myArray.length)
        {
            if (myArray[2* (index + 1)] != null)
            {
                print_inOrder(2 * (index + 1));
            }
        }
    }
    
    //public long getCount()
    //{
      //  return counter.getCount();
    //}
}
    
    