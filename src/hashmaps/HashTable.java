package hashmaps;

import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    private class Entry {
        public int key;
        public String value;
        Entry (int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
           return key + ", " + value;
        }
    }

    private LinkedList<Entry> list[];

    public HashTable (int size) {
       list = new LinkedList[size];
    }

    public void put(int key, String value) {
        int index = hash(key);
        if (list[index] ==  null)
            list[index] = new LinkedList<>();

        for (var entry : list[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        var entry = new Entry(key, value);
        list[index].addLast(entry);
    }


    public String get(int key) {
        int index = hash(key);
        if (list[index] != null) {
            for (var entry : list[index]) {
                if (entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        if (list[index] == null)
            throw new IllegalStateException();
        for (var entry : list[index]) {
            if (entry.key == key) {
                list[index].remove(entry);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private int hash(int key) {
        key = Math.abs(key);
        return key % list.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

}
