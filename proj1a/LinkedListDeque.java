public class LinkedListDeque<T> implements doubleEndedQueue<T> {
    int size = 0;
    itemNode sentinel = new itemNode();
    itemNode last = null;

    public class itemNode{
        itemNode prev;
        T item;
        itemNode next;

        public itemNode(itemNode p, T itemT, itemNode n){
            prev = p;
            item = itemT;
            next = n;
        }

        public itemNode(){
            prev = this;
            next = this;
        }
    }



    @Override
    public void addFirst(T item) {
        itemNode newNode = new itemNode(sentinel,item,sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        if (size == 0) last = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        itemNode newNode = new itemNode(last,item,last.next);
        last.next = newNode;
        last = newNode;
        if (size==0) sentinel.next=newNode;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
//        if(size == 0)  return true;
//        return false;
// 上面的写法没错，但是下名的写法更加优雅！值得学习！
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        itemNode p = sentinel;
        while (p.next != sentinel){
            System.out.print(p.item);
            System.out.print(' ');
            p=p.next;
        }

    }

    @Override
    public T removeFirst() {
        if(size == 0) return null;

        itemNode firstNode = sentinel.next;
        T firstItem = firstNode.item;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size -= 1;
        return firstItem;
    }

    @Override
    public T removeLast() {
        if(size == 0) return null;
        T lastItem = last.item;
        last = last.prev;
        last.next = sentinel;
        size -= 1;
        return lastItem;
    }

    @Override
    public T get(int index) {
        if(index<0 || index >=size) return null;

        itemNode p = sentinel;
        for(int i=0; i <= index; i++)
        {
            p = p.next;
        }
        return p.item;
    }
}
