package lists;

/**
 *
 * @author wickl
 */
public class Driver
{
    public static void main(String[] args) throws Exception
    {
       OrderedListADT<Integer> myTest = new OrderedLinkedList();
       
       myTest.add(1);
       myTest.add(5);
       myTest.add(5);
       myTest.add(7);
       myTest.add(5);
       myTest.add(-5);
       
       System.out.println(myTest.size());
       
       System.out.println(myTest.toString());
       
       
    } 
}
