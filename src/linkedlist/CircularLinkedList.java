package linkedlist;

public class CircularLinkedList {
    private Node first;
    private Node last;

    private class Node{
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = node;
        else {
             last.next = node;
        }
        last = node;
        last.next = first;
    }

    public void print() {
        Node node = first;

        do {
            System.out.println(node.value + "  ");
            node = node.next;
        } while (node != first);
    }
    private boolean isEmpty() {
        return first == null;
    }

}
