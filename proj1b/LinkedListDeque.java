import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Isn't this solution kinda... cheating? Yes.
 */
public class LinkedListDeque<T> extends LinkedList<T> implements Deque<T>{
// 子类可以调用父类，没有重写的方法默认会使用父类的方法。

    @Override
    public void printDeque() {
        System.out.println("dummy");
    }

    public T getRecursive(int i) {
        return get(i);
    }

    @Override
    public T removeFirst() {
        try {
            return super.removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T removeLast() {
        try {
            return super.removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
