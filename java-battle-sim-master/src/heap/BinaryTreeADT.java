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
public interface BinaryTreeADT<T>
{
    T getRootElement();
    boolean isEmpty();
    int size();
    boolean contains(T targetElement);
    T find(T targetElement) throws ElementNotFoundException;
    void print_inOrder();
}
