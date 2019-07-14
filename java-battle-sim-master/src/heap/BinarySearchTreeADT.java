/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

/**
 *
 * @author wickl
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T>
{
    void addElement(T element) throws NonComparableElementException, DuplicateElementException;
    
    T removeElement(T targetElement) throws ElementNotFoundException;
    void removeAllOccurrences(T targetElement) throws ElementNotFoundException;
    
    T removeMin() throws EmptyCollectionException;
    T removeMax() throws EmptyCollectionException;
    
    T findMin() throws ElementNotFoundException;
    T findMax() throws ElementNotFoundException;
}
