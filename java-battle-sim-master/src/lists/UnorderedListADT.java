package lists;


/**
 *
 * @author wickl
 */
public interface UnorderedListADT<T> extends ListADT<T>, Iterable<T>
{
    //add methods specific to unordered list
    void addToFront(T element);
    void addToRear(T element);
    void addAfter(T element, T target) throws Exception;
}
