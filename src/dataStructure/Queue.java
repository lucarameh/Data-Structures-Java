package dataStructure;

public class Queue {

    private Node first;
    private Node last;
    private int size;

    static class Node{
        String data;
        Node next;
        public Node(String data){
            this.data = data;
        }
    }
    public Queue(String data){
        Node newNode = new Node(data);
        this.first = newNode;
        this.last = newNode;
        this.size = 1;
    }
    public void getFirst(){
        if (this.first == null){
            System.out.println("Queue is empty");
        } else {
            System.out.println(first.data);
        }
    }

    public void getLast(){
        if (this.last == null){
            System.out.println("Queue is empty");
        } else {
            System.out.println(last.data);
        }
    }

    public void getSize(){
        if (this.size == 0){
            System.out.println("Queue is empty");
        }
        System.out.println(this.size);
    }

    public void print() {
        System.out.println("######################################");
        if(this.size == 0){
            System.out.println("Queue is empty");
        }
        Node temp = this.first;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("######################################");
    }

    public void enqueue(String data){
        Node newNode = new Node(data);
        if(this.size == 0){
            this.first = newNode;
        } else {
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    public static void main(String[] args) {
        Queue queue = new Queue("elemento1");
        queue.enqueue("elemento2");
        queue.enqueue("elemento3");
        queue.getFirst();
        queue.getLast();
        queue.getSize();
        queue.print();
    }
}
