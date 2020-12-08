package Task2;

public class DynamicDoubleArray<T> {

    private int capacity;
    private Object[] array = new Object[capacity];
    private int pos = 0;

    public DynamicDoubleArray(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return capacity;
    }

    public void add(double num) {
        System.out.println("array.length = " + array.length);
        System.out.println("array.length = " + capacity);
        if (array.length <= capacity) {
            Object[] temp = array;
            do
                array = new Object[capacity * 2];
            while (array.length <= capacity);
            for (int i = 0; i < temp.length; i++) {
                array[i] = temp[i];
            }
        }
        array[pos] = num;
        pos++;
    }

    public T get(int position) {
        return (T) array[position];
    }

    public void deleteFromIndex(int position) {
        array[position] = 0.0;
    }

    public void printToString() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("a[" + i + "] = " + array[i]);
        }

    }
}
