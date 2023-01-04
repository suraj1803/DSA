package queues;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<Integer> items;
    private int count;
    private int front;
    public PriorityQueue(){
        items = new ArrayList<>(5);
        count = 0;
        front = 0;
    }
    public void add(int item) {
        int i;
        for (i = count - 1; i >= 0; i--){
            if (items.get(i) < item)
                break;
        }
        items.add(i + 1, item);
        count++;
    }

    public int remove() {
        return items.remove(front++);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
