package hashmaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char firstNonRepeatingCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = input.toCharArray();

        for (char ch : chars){
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (char ch : chars) {
           if (map.get(ch) == 1)
               return ch;
        }
        return Character.MIN_VALUE;
    }

    public char firstRepeatedCharacter(String input) {
        Set<Character> set = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
