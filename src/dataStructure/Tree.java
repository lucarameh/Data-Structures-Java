package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    private Node root;

    public static class Node{
        public int data;
        public Node left;
        public Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
        public boolean isLeaf(){
            return this.left == null && this.right == null;
        }

    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node currentNode = queue.remove();
                if(currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                } if (currentNode.right == null){
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println("  ");
    }

    private void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println(" ");
    }

    private void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void inOrder() {
        inOrder(root);
        System.out.println(" ");
    }

    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

    }

    public void BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.data + " ");
            if(!currentNode.isLeaf()) {
                queue.add(currentNode.left);
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        System.out.println(" ");
    }

    public void DFS() {
        preOrder(root);
        System.out.println("  ");
    }
}
