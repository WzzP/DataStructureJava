package link;

public class Node <T> {
    private T element;
    private Node<T> next;

    public Node(T e, Node<T> n) {
        this.element = e;
        this.next = n;
    }
    public Node(T e){
        this(e,null);
    }

    public T getElement() {
        return element;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
