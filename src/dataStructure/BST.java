package dataStructure;

public class BST {

    Node root;

    public static class Node{

        public int data;
        public Node right, left;

        public Node(int data) {
            this.data = data;
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
            Node current = root;
            while(true){
                if(current.data > data){
                    if(current.left == null){
                        current.left = newNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (current.data < data){
                    if(current.right == null){
                        current.right = newNode;
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    break;
                }
            }
        }
    }
    public void inOrder() {
        inOrder(this.root);
        System.out.println(" ");
    }

    private void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void contains(int value) {
        Node current = contains(this.root, value);
        System.out.println(current!=null);
    }

    private Node contains(Node root, int value) {
        if(root == null) { return null; }
        if(root.data == value) { return root; }
        else if(root.data > value) { return contains(root.left, value); }
        else { return contains(root.right, value); }
    }

    public void remove(int value) {



    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(1);
        bst.insert(91);
        bst.insert(3);
        bst.insert(42);
        bst.insert(23);
        bst.insert(55);
        bst.insert(35);
        bst.insert(5);
        bst.contains(23);
        bst.contains(0);

    }

}
