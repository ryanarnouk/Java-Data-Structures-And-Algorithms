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

class PreOrderTraversal {
    /* you only have to complete the function given below.  
    Node is defined as  

    class Node {
        int data;
        Node left;
        Node right;
    }

    */

    public static void preOrder(Node root) {
        if (root == null) return;
        // first print of data 
        System.out.print(root.data + " ");
        // left subtree
        preOrder(root.left);
        // right subtree
        preOrder(root.right);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
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