public class ArrayDeque<T> {
    private int size;
    private T[] itemArray;
    private int first;
    private int last;
    private int capacity;

    // Creates an empty array deque.
    public ArrayDeque() {
        size = 0;
        itemArray = (T[]) new Object[8];
        first = 0;
        last = 0;
        capacity = 8;
    }

    private void resizing() {
        if (size / capacity > 0.75) {
            capacity *= 2;
            T[] itemArraryNew = (T[]) new Object[capacity];
            int startIdx = compareFL();
            System.arraycopy(itemArray, startIdx, itemArraryNew, 0, size);
            itemArray = itemArraryNew;
        } else if (size / capacity < 0.25 & size > 32) {
            capacity /= 2;
            T[] itemArraryNew = (T[]) new Object[capacity];
            int startIdx = compareFL();
            System.arraycopy(itemArray, startIdx, itemArraryNew, 0, size);
            itemArray = itemArraryNew;
        }

    }

    private int compareFL() {
        return first < last ? first : last;
    }



    public void addFirst(T item) {
        if (size == 0) {
            itemArray[first] = item;
            size += 1;
            return;
        }
        size = size + 1;
        resizing();
        first = (first - 1 + capacity) % capacity;
        itemArray[first] = item;
    }


    public void addLast(T item) {
        if (size == 0) {
            itemArray[last] = item;
            size += 1;
            return;
        }
        size = size + 1;
        resizing();
        last = (last + 1) % capacity;
        itemArray[last] = item;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        for (int i = 0; i <= size - 1; i++) {
            int currIdx = (i + first) % capacity;
            System.out.print(itemArray[currIdx]);
            System.out.print(" ");
        }
    }


    public T removeFirst() {
        T firstRemoved = itemArray[first];
        first = (first + 1) % capacity;
        size -= 1;
        return firstRemoved;
    }


    public T removeLast() {
        T lastRemoved = itemArray[last];
        first = (last - 1 + capacity) % capacity;
        size -= 1;
        return lastRemoved;
    }


    public T get(int index) {
        return itemArray[(first + index) % capacity];
    }


}



