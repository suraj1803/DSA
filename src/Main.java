import hashmaps.CharFinder;
import hashmaps.HashTable;
import hashmaps.HashTableExercise;
import linkedlist.LinkedList;
import queues.ArrayQueue;
import queues.PriorityQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.add(4);
        queue.add(2);
        queue.add(1);
        queue.add(3);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);

    }

    public static boolean isBalanced(String input) {
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < input.length(); i++) {
           char x = input.charAt(i);
           if (x == '{' || x == '[' || x == '(' || x == '<') {
               stack.push(x);
           }
           if (x == '}' || x == ']' || x == ')' || x == '>') {
              if (stack.isEmpty())
                  return false;
              char top = stack.pop();
              if ( (x == '}' && top != '{') || (x == ')' && top != '(') || (x == ']' && top != '['))
                 return false;
           }
       }
       return stack.isEmpty();
    }
}