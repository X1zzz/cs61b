public class ArrayDeque<T> implements doubleEndedQueue<T> {
    int size;
    T[] itemArray;
    int first;
    int last;
    int capacity;

    // Creates an empty array deque.
    public ArrayDeque() {
        size = 0;
        itemArray = (T[]) new Object[8];
        first = 0;
        last = 0;
        capacity = 8;
    }

    public void resizing() {
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


    @Override
    public void addFirst(T item) {
        if (size == 0) {
            itemArray[first] = item;
            size +=1;
            return;
        }
        size = size + 1;
        resizing();
        first = (first - 1 + capacity) % capacity;
        itemArray[first] = item;
    }

    @Override
    public void addLast(T item) {
        if (size == 0) {
            itemArray[last] = item;
            size +=1;
            return;
        }
        size = size + 1;
        resizing();
        last = (last + 1) % capacity;
        itemArray[last] = item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i <= size - 1; i++) {
            int currIdx = (i + first) % capacity;
            System.out.print(itemArray[currIdx]);
            System.out.print(" ");
        }
    }

    @Override
    public T removeFirst() {
        T firstRemoved = itemArray[first];
        first = (first + 1) % capacity;
        size -= 1;
        return firstRemoved;
    }

    @Override
    public T removeLast() {
        T lastRemoved = itemArray[last];
        first = (last - 1 + capacity) % capacity;
        size -= 1;
        return lastRemoved;
    }

    @Override
    public T get(int index) {
        return itemArray[(first + index) % capacity];
    }


}



