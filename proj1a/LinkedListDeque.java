//public class LinkedListDeque<T>  {
//    int size = 0;
//    ItemNode sentinel = new ItemNode();
//    ItemNode last = null;
//
//    public class ItemNode{
//        ItemNode prev;
//        T item;
//        ItemNode next;
//
//        public ItemNode(ItemNode p, T itemT, ItemNode n){
//            prev = p;
//            item = itemT;
//            next = n;
//        }
//
//        public ItemNode(){
//            prev = this;
//            next = this;
//        }
//    }
//
//
//
//
//    public void addFirst(T item) {
//        ItemNode newNode = new ItemNode(sentinel,item,sentinel.next);
//        sentinel.next.prev = newNode;
//        sentinel.next = newNode;
//        if (size == 0) last = newNode;
//        size += 1;
//    }
//
//
//    public void addLast(T item) {
//        ItemNode newNode = new ItemNode(last,item,last.next);
//        last.next = newNode;
//        last = newNode;
//        if (size==0) sentinel.next=newNode;
//        size += 1;
//    }
//
//
//    public boolean isEmpty() {
////        if(size == 0)  return true;
////        return false;
//// 上面的写法没错，但是下名的写法更加优雅！值得学习！
//        return size == 0;
//    }
//
//
//    public int size() {
//        return size;
//    }
//
//
//    public void printDeque() {
//        ItemNode p = sentinel;
//        while (p.next != sentinel){
//            System.out.print(p.item);
//            System.out.print(' ');
//            p=p.next;
//        }
//
//    }
//
//
//    public T removeFirst() {
//        if(size == 0) return null;
//
//        ItemNode firstNode = sentinel.next;
//        T firstItem = firstNode.item;
//        sentinel.next = firstNode.next;
//        firstNode.next.prev = sentinel;
//        size -= 1;
//        return firstItem;
//    }
//
//    public T removeLast() {
//        if(size == 0) return null;
//        T lastItem = last.item;
//        last = last.prev;
//        last.next = sentinel;
//        size -= 1;
//        return lastItem;
//    }
//
//    public T get(int index) {
//        if(index<0 || index >=size) return null;
//
//        ItemNode p = sentinel;
//        for(int i=0; i <= index; i++)
//        {
//            p = p.next;
//        }
//        return p.item;
//    }
//}

/**  first part of project1A.
 *   Deque implemented by Linked List
 *  @author FlyingPig
 */
public class LinkedListDeque<T> {
    /** inner class Node. */
    public class Node {
        /** the item stored on this node. */
        private T item;
        /** the Node before this Node. **/
        private Node pre;
        /** the Node after this Node. **/
        private Node next;

        /** constructor for Node. */
        public Node(T n, Node ppre, Node nnext) {
            item = n;
            pre = ppre;
            next = nnext;
        }

        /** constructor for Node.(especially for sentinel node). */
        public Node(Node ppre, Node nnext) {
            pre = ppre;
            next = nnext;
        }
    }

    /** sentinel node. */
    private Node sentinel;
    /** size of the deque. */
    private int size;

    /** constructor for deque. */
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.pre = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node newList = new Node(item, sentinel, sentinel.next);
        sentinel.next.pre = newList;
        sentinel.next = newList;
        size++;
    }

    public void addLast(T item) {
        Node newList = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newList;
        sentinel.pre = newList;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ret = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T ret = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return ret;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }

    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }
}