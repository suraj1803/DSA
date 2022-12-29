package linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node {
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
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;

    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexOf(int item) {
        Node node = first;

        int index = 0;
        while (node != null) {
            if (node.value == item)
                return index;
            index++;
            node = node.next;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }


    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }
        Node node = first.next;
        first.next = null;
        first = node;

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
            size--;
            return;
        }

        Node node = first;
        while (node.next != last) {
            node = node.next;
        }
        // now node = 2nd last
        node.next = null;
        last = node;

        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];

        Node node = first;

        int i = 0;
        while (node != null) {
            array[i++] = node.value;
            node = node.next;
        }

        return array;
    }

    public static boolean search(Node head, int key) {
        if (head == null)
            return false;
        if (head.value == key)
            return true;
        return search(head.next, key);
    }

    public int getKthFromTheEnd(int k) {
        var a = first;
        var b= first;
        if (a == null)
            throw new IllegalStateException();
        for (int i = 0; i < k -1; i++) {
            b = b.next;
           if (b == null)
               throw new IllegalArgumentException();
        }
        while (b != last) {
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void reverse() {
       Node previous = first;
       Node current = first.next;
       while (current != null) {
           Node next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }
       last = first;
       last.next = null;
       first = previous;
    }

    public void printMiddle() {
        var a = first;
        var b = first;

        while (b != last && b.next != last) {
            a = a.next;
            b = b.next.next;
        }

        if (b == last) //means size is odd
            System.out.println(a.value);
        else
            System.out.println(a.value + " " + a.next.value);
    }

    public boolean hasLoop() {
        if(isEmpty())
            throw new IllegalStateException();
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
    public String toString() {
        int[] arr = new int[size];
        int i = 0;
        Node node = first;
        while (node != null) {
            arr[i] = node.value;
            i++;
            node = node.next;
        }
        return Arrays.toString(arr);
    }

    private boolean isEmpty() {
        return first == null;
    }
}
