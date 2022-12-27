package linkedlist;

public class DoublyLinkedList {
    private Node first;
    private Node last;

    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        last.next = node;
        node.previous = last;
        last = node;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        first.previous = node;
        node.next = first;
        first = node;
    }

    public void removeLast() {
        if (isEmpty())
            return;
        if (first == last) {
            first = last = null;
            return;
        }
        var node = last.previous;
        node.next = null;
        last.previous = null;
        last = node;
    }

    public void print() {
        Node node = first;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

}
