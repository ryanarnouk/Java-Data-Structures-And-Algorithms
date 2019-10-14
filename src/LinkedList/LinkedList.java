
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.Stack;
/**
 *
 * @author Ryan
 */
public class LinkedList<E> {
    private Node<E> head; 
    private Node<E> tail; 
    private int size; 
    
    public LinkedList() {
        size = 0; 
        head = new Node(); 
        tail = new Node(); 
    }
    
    public void add(E item) {
        // add based on head and tail 
        Node data = new Node(item);
        if (size == 0) {
            head = data; 
            tail = head; 
        } else {
            tail.next = data;
            tail = data;
        }
        
        size++;
    }
    
    public Node<E> getNode(int n) {
        Node<E> temp = head;
        for (int count = 0; count < n; count++)
            temp = temp.next;
       
        return temp;
    }
    
    public E get (int n) {
        return getNode(n).contents;
    }
    
    public void remove (int n) {
        if (n == 0) {
            // removing first element
            head = head.next;
        } else if (n == size - 1) {
            // removing last element
            Node temp = getNode(size - 2);
            tail = temp; 
            temp.next = null;
        } else if (size == 1 && n == 0) {
            // size of array is one
            head = new Node();
            tail = new Node(); 
        } else {
            Node temp = getNode(n - 1); // get index before n to unlink the element off the chain
            temp.next = temp.next.next; // element gets set to next next element to remove n off teh chain
            // java would automatically clean up the unlinked inex from system memory
        }
        
        size--;
    }
    
    public void add(E item, int index) {
        Node data = new Node(item);
        Node current = head; 
        int jump;
        
        if (index > size || index < 0) {
            System.out.println("Add Failed: Index passed in is out of the bounds of the size of the linked list."); 
        } else {
            jump = 0;
            
            while (jump < index - 1) {
                // shift array back
                current = current.next;
                jump++;
            }
            data.next = current.next;
            current.next = data; 
            size++;
            System.out.println("Added " + item + " at index: " + index);
        }
    }
    
    public void print() {
       Node current = head; 
       while(current.next != null) {
           // loop while in bounds of list
           System.out.print(current.contents);
           current = current.next;
       }
       System.out.print(current.contents); // print last one
       System.out.println();
    }
    
    public void printinreverse() {
        // use a stack to loop through the data 
        Stack<Node> stack = new Stack(); 
        
        Node current = head;
        
        while (current != null) {
            // append to stack
            stack.add(current);
            current = current.next;
        }
        
        while (!stack.isEmpty()) {
            Node node = stack.pop(); // pop off last node and print it 
            System.out.print(node.contents);
        }
        System.out.println();
    }
       
    public void reverselist() {
        Node current = head;
        Node prev = null; 
        
        while (current != null) {
            // rearrange the order of the linked list by pointing each node in reverse order 
            // 1 -> 2 -> 3 becomes 1 <- 2 <- 3 and the order rearranges
            Node nextnode = current.next; 
            current.next = prev;
            prev = current;
            current = nextnode;
        }
    }
    
    public void insertAtHead(Node head, E data) {
        Node newnode = new Node(data);
        // set next of new data to linked list
        newnode.next = head;
        // set head to new temp linked list
        head = newnode;
    }
    
    public static void main(String[] args) {
        LinkedList NewList = new LinkedList();
        NewList.add(1);
        NewList.add(2);
        NewList.add(3);
        NewList.add(4);
        NewList.add(5);
        NewList.remove(1); // remove element with data "2"
        NewList.print(); // Output: 1334
        
        NewList.add(2, 1); // append element with data "2" to index 1
        NewList.print(); 
        
        // print in reverse
        System.out.println("Reverse print:");
        NewList.printinreverse();
        
        // reverse the whole linked list
        System.out.println("New reversed list:");
        NewList.reverselist();
        NewList.print();
    }
}
