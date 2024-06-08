package dataStructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;


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
        this.length = 1;
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
    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void print() {
        System.out.println("######################################");
        if (head == null) {
            System.err.println("List is empty");
        }
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void append (String data) {
        Node newNode = new Node(data);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
            this.tail.next = null;
        }
        this.length++;
    }

    public void removeLast(){
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length = 0;
        }
        else if (this.length > 1) {
            Node temp = this.head;
            int i = 1;
            while (i < this.length - 1) {
                temp = temp.next;
                i++;
            }
            this.tail = temp;
            this.tail.next = null;
            this.length--;
        }
        else {
            System.err.println("List is empty");
        }
    }

    public void prepend(String data) {
        Node newNode = new Node(data);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public void removeFirst() {
        if (this.length == 0) {
            System.err.println("List is empty");
        }
        else if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length = 0;
        }else {
            this.head = this.head.next;
            this.length--;
        }
    }

    private Node getNode(int idx){
        if (this.length == 0) {
            System.err.println("List is empty");
            return null;
        }
        if (idx > this.length || idx < 0) {
            System.err.println("Index out of bounds");
            return null;
        }
        Node temp = this.head;
        int i = 1;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        return temp;
    }
    public void get(int idx) {
        Node temp = getNode(idx);
        if (temp != null) {
            System.out.println(temp.data);
        }

    }
    public void update(int idx, String data) {
        Node temp = getNode(idx);
        if (temp != null) {
            temp.data = data;
        }
    }

    public void add(int idx, String data) {
        Node newNode = new Node(data);
        if (idx == 1) {
            Node next = this.head;
            this.head = newNode;
            newNode.next = next;
            this.length++;
        } else {
            Node temp = getNode(idx-1);
            if (temp != null) {
                Node next = temp.next;
                temp.next = newNode;
                if (next != null) {
                    newNode.next = next;
                } else {
                    this.tail = newNode;
                }
                this.length++;
            }
        }
    }

    public void remove(int idx) {
         if (idx == 1) {
             removeFirst();
         }
         else if (idx == this.length) {
             removeLast();
         }
         else {
             Node temp = getNode(idx - 1);
             if (temp != null) {
                 temp.next = temp.next.next;
                 this.length--;
             }
         }
    }
}
