package dataStructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int lenght;


    static class Node {
        String data;
        Node next;

        Node (String data) {
            this.data = data;
        }
    }

    public LinkedList (String data) {
        Node newNode = new Node(data);
        this.head = newNode;
        this.tail = newNode;
        this.lenght = 1;
    }

    public String getHead() {
        if (head == null) {
            return null;
        }
        return head.data;
    }
    public String getTail() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }
    public int getLenght() {
        return lenght;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.lenght = 0;
    }

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void append (String data) {
        Node newNode = new Node(data);
        if (this.lenght == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.next = null;
        }
        this.lenght++;
    }

    public void removeLast(){
        if (this.lenght == 1) {
            this.head = null;
            this.tail = null;
            this.lenght = 0;
        }
        else if (this.lenght > 1) {
            Node temp = this.head;
            int i = 1;
            while (i < this.lenght - 1) {
                temp = temp.next;
                i++;
            }
            this.tail = temp;
            this.tail.next = null;
            this.lenght--;
        }
        else {
            System.out.println("List is empty");
        }
    }

    public void prepend(String data) {
        Node newNode = new Node(data);
        if (this.lenght == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.lenght++;
    }




//    public static void main(String[] args) {
//        LinkedList test = new LinkedList("Test");
//        //test.append("Olá");
//        //test.append("Ultimo");
//        test.print();
//        test.removeLast();
//        test.print();
//        test.makeEmpty();
//        test.print();
//        test.removeLast();
//    //    System.out.println(test.getLenght());
//    //}
}
