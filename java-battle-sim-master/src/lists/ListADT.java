package lists;

//import java.util.Iterator;
/**
 *
 * @author wickl
 */
public interface ListADT<T>
{
    T removeFirst();
    T removeLast();
    T remove(T element) throws Exception;
    T first();
    T last();
    boolean isEmpty();
    int size();
    //Iterator<T> iterator();
    boolean contains(T element);
    @Override
    String toString();
    
}
