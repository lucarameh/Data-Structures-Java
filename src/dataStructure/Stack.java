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
}
