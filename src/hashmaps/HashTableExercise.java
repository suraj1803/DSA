package hashmaps;

import java.util.*;

public class HashTableExercise{

    public int mostFrequentInteger(int arr[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = map.containsKey(arr[i]) ? map.get(arr[i]) : 0;
            count++;
            map.put(arr[i], count);
        }

        int maxCount = 1;
        int maxItem = arr[0];
        for (var item : map.keySet()) {
            if (map.get(item) > maxCount) {
                maxCount = map.get(item);
                maxItem = item;
            }
        }
        return maxItem;
    }

    public int countPairsWithDiff(int[] arr, int k) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (var item : arr) {
            set.add(item);
        }

        for (var item : arr) {
            if (set.contains(item + k))
                count++;
        }
        return count;
    }

    public String twoSum(int[] arr, int target) {
        // Here we use a hashmap to store the array items as key and indexes
        // as values
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int result = target - arr[i];
            if (map.containsKey(result))
                return Arrays.toString(new int[] {map.get(result), i});
            map.put(arr[i], i);
        }
        return null;
    }
}
