package heap;

/**
 *
 * @author JaredWicklein
 */
public interface HeapADT<T> extends BinaryTreeADT<T> 
{
    void addElement(T obj);
    T removeMin() throws EmptyCollectionException;
    T findMin() throws EmptyCollectionException;
}
