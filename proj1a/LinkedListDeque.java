public class LinkedListDeque<T>  {
    int size = 0;
    ItemNode sentinel = new ItemNode();
    ItemNode last = null;

    public class ItemNode{
        ItemNode prev;
        T item;
        ItemNode next;

        public ItemNode(ItemNode p, T itemT, ItemNode n){
            prev = p;
            item = itemT;
            next = n;
        }

        public ItemNode(){
            prev = this;
            next = this;
        }
    }




    public void addFirst(T item) {
        ItemNode newNode = new ItemNode(sentinel,item,sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        if (size == 0) last = newNode;
        size += 1;
    }


    public void addLast(T item) {
        ItemNode newNode = new ItemNode(last,item,last.next);
        last.next = newNode;
        last = newNode;
        if (size==0) sentinel.next=newNode;
        size += 1;
    }


    public boolean isEmpty() {
//        if(size == 0)  return true;
//        return false;
// 上面的写法没错，但是下名的写法更加优雅！值得学习！
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void printDeque() {
        ItemNode p = sentinel;
        while (p.next != sentinel){
            System.out.print(p.item);
            System.out.print(' ');
            p=p.next;
        }

    }


    public T removeFirst() {
        if(size == 0) return null;

        ItemNode firstNode = sentinel.next;
        T firstItem = firstNode.item;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size -= 1;
        return firstItem;
    }

    public T removeLast() {
        if(size == 0) return null;
        T lastItem = last.item;
        last = last.prev;
        last.next = sentinel;
        size -= 1;
        return lastItem;
    }

    public T get(int index) {
        if(index<0 || index >=size) return null;

        ItemNode p = sentinel;
        for(int i=0; i <= index; i++)
        {
            p = p.next;
        }
        return p.item;
    }
}
