package link;

public class DLNode<T> implements Position<T> {

    private T element;
    private DLNode<T> prev; //指向前驱节点
    private DLNode<T> next; //指向后继节点

    public DLNode(T element, DLNode<T> prev, DLNode<T> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public DLNode(T element, DLNode<T> prev) {
        this(element, prev, null);
    }

    public DLNode(T element) {
        this.element = element;
    }

    public DLNode<T> getPrev() {
        return prev;
    }

    public DLNode<T> getNext() {
        return next;
    }

    @Override
    public T getElem() {
        return element;
    }

    @Override
    public T setElem(T e) {
        T result = element;
        element = e;
        return result;
    }


    public void setPrev(DLNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(DLNode<T> next) {
        this.next = next;
    }
}
