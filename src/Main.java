import linkedlist.LinkedList;
import queues.ArrayQueue;

import java.util.PriorityQueue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.reverse();
        System.out.println(list);
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