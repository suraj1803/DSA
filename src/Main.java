import hashmaps.CharFinder;
import hashmaps.HashTable;
import hashmaps.HashTableExercise;
import linkedlist.LinkedList;
import queues.ArrayQueue;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashTableExercise exercise = new HashTableExercise();
        int[] arr = {2, 7, 11, 15};
        System.out.println(exercise.twoSum(arr, 9));
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