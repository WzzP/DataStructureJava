package stack;

import link.Node;

/**
 * 基于链表实现栈
 */
public class StackLinkList<T> implements Stack<T> {

    protected Node<T> head;
    protected int size = 0;
    protected int capacity;
    protected static int CAPACITY=1024;

    public StackLinkList(int capacity) {
        this.capacity = capacity;
    }

    public StackLinkList(){
        this(CAPACITY);
    }

    @Override
    public void push(T x) {
      head = new Node<T>(x, head);
      size++;
    }

    @Override
    public T pop() throws ExceptionStackEmpty {
        if (isEmpty()){
            throw new ExceptionStackEmpty();
        }
        T elem = head.getElement();
        head = head.getNext();
        size--;
        return elem;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public T top() throws ExceptionStackEmpty {
        if (isEmpty()){
            throw new ExceptionStackEmpty();
        }
        return (T) head.getElement();
    }

    public static void main(String[] args) {
        StackLinkList<Integer> linkList = new StackLinkList<>();
        for (int i = 0; i < 1024; i++) {
            linkList.push(i);
        }
        while (!linkList.isEmpty()){
            System.out.println(linkList.pop());
        }

    }
}
