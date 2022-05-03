package queue;

import link.Node;

/**
 * 基于链表实现队列
 * @param <T>
 */
public class QueueLinkList<T> implements Queue<T> {

    protected Node<T> head;
    protected Node<T> tail;
    protected int size=0;

    @Override
    public void enqueue(T x) {
        Node<T> element = new Node<>(x);
        if (head == null){
            head = element;
        } else {
            tail.setNext(element);
        }
        tail = element;
        size++;
    }

    @Override
    public T dequeue() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        T element = head.getElement();
        head = head.getNext();
        if (head == null){
            tail = null;
        }
        size--;
        return element;
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
    public T front() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        return head.getElement();
    }

    public static void main(String[] args) {
        QueueLinkList<Integer> queueLinkList = new QueueLinkList<>();
        for (int i = 0; i < 1024; i++) {
                queueLinkList.enqueue(i);
        };
        while (!queueLinkList.isEmpty()){
            System.out.println(queueLinkList.dequeue());
        }
    }
}

