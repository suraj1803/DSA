package arrays;

public class Array {
    private int[] array;
    private int count = 0;

    public Array(int length) {
        array = new int[length];
    }

    public void insert(int item) {
        if (count == array.length) {
            int[] temp = new int[count * 2];
            for(int i = 0; i < count; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[count++] = item;
    }

    public void insert(int item, int index) {
        if (index < 0 || index  >= count)
            throw new IllegalArgumentException();
        if (count == array.length) {
            int[] temp = new int[count * 2];
            for (int i = 0; i < count; i++) {
                temp[i] = array[i];
            }
            for (int i = count - 1; i >=index; i--) {
                temp[i+1] = temp[i];
            }
            temp[index] = item;
            array = temp;
            count++;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if(array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public int max() {
        int max = array[0];
        for (int i = 0; i < count; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public void reverse() {
        int start = 0;
        int end = count - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }

}
