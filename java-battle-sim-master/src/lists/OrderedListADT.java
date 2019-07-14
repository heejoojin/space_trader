package lists;

/**
 *
 * @author wickl
 * 
 */
public interface OrderedListADT<T> extends ListADT<T>, Iterable<T>
{
    void add(T element) throws Exception;
}
