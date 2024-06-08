package dataStructure;

public class Stack {

    private Node top;
    private int height;

    static class Node {

        String value;
        Node next;

        Node(String v) {
            this.value = v;
        }
    }
    public Stack(String data) {
        this.top = new Node(data);
        this.height = 1;
    }

    public void getTop() {
        if (this.top == null) {
            System.err.println("Stack is empty");
        } else {
            System.out.println(this.top.value);
        }
    }
    public void getHeight() {
        if (this.top == null) {
            System.err.println("Stack is empty");
        } else {
            System.out.println(this.height);
        }
    }

    public void print() {
        System.out.println("###################################");
        if (this.top == null) {
            System.err.println("Stack is empty");
        }
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#######################################");
    }

    public void push(String v) {
        if (this.top == null) {
            this.top = new Node(v);
            this.height = 1;
        } else {
            Node newNode = new Node(v);
            newNode.next = this.top;
            this.top = newNode;
            this.height++;
        }
    }

    public void pop() {
        if (this.top == null) {
            System.err.println("Stack is empty");
        } else {
            String val = this.top.value;
            this.top = this.top.next;
            System.out.println("Popped: " + val);
        }
    }

    public static void main(String[] args) {
        Stack pilha =  new Stack("elm1");
        pilha.push("elm2");
        pilha.push("elm3");
        pilha.print();
        pilha.pop();
        pilha.pop();
        pilha.pop();
        pilha.print();
        pilha.push("elm4");
        pilha.push("elm5");
        pilha.print();

    }
}
