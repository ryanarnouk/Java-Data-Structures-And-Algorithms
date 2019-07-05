/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Ryan
 */
public class Node<E> {
    public E contents; 
    public Node next; 
    
    public Node() {
        contents = null; 
        next = null; 
    }
    
    public Node(E data) {
        contents = data; 
    }
}
