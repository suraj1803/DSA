package stacks;

import java.util.Arrays;


// Stack using LinkedList
public class StackL {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public void push(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        int value = first.value;
        if (first == last) {
            first = last = null;
        }
        else {

            Node node = first.next;
            first.next = null;
            first = node;
        }
        size--;
        return value;
    }


    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return first.value;
    }

    private boolean isEmpty(){
        return first == null;
    }

    @Override
    public String toString() {
        int[] arr = new int[size];
        Node node = first;
        int i = 0;
        while(node != null) {
            arr[i] = node.value;
            node = node.next;
            i++;
        }
        return Arrays.toString(arr);
    }

}
