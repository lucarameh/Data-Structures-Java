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

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        System.out.println(tree.root.data + " " + tree.root.left.data + " " + tree.root.right.data);
    }

}
