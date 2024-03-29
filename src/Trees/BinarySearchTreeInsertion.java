/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author Ryan 
 */
import java.util.*;

class BinarySearchTreeInsertion {
    public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }


    public static Node insert(Node root,int data) {
        if (root == null) {
            // reached end to insert
            root = new Node(data);
            return root;
        }
        if (data <= root.data) {
            // go left
            root.left = insert(root.left, data);
        } else if (data >= root.data) {
            // go right
            root.right = insert(root.right, data);
        }
        return root; 
    }

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}