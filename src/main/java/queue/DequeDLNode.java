package queue;

import link.DLNode;

public class DequeDLNode<T> implements Deque<T> {
    protected DLNode<T> header; //头部
    protected DLNode<T> trailer; //尾部
    protected int size;

    public  DequeDLNode() {
        this.header = new DLNode<T>(null);
        this.trailer = new DLNode<T>(null);
        this.header.setNext(this.trailer);
        this.trailer.setPrev(this.header);
    }

    @Override
    public void insertFirst(T x) {
        DLNode<T> elem = new DLNode<>(x);
        elem.setNext(header.getNext());
        header.getNext().setPrev(elem);
        elem.setPrev(header);
        header.setNext(elem);
        size++;
    }

    @Override
    public void insertLast(T x) {
        DLNode<T> elem = new DLNode<>(x);
        elem.setNext(trailer);
        elem.setPrev(trailer.getPrev());
        trailer.getPrev().setNext(elem);
        trailer.setPrev(elem);
        size++;
    }

    @Override
    public T removeFirst() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        T elem = header.getNext().getElem();
        header.getNext().getNext().setPrev(header);
        header.setNext(header.getNext().getNext());
        size--;
        return elem;

    }

    @Override
    public T removeLast() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        T elem = trailer.getPrev().getElem();
        trailer.getPrev().getPrev().setNext(trailer);
        trailer.setPrev(trailer.getPrev().getPrev());
        size--;
        return elem;
    }

    @Override
    public T first() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        return header.getNext().getElem();
    }

    @Override
    public T last() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        return trailer.getPrev().getElem();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header.getNext() == trailer;
    }

    public static void main(String[] args) {
        DequeDLNode<Integer> dequeDLNode = new DequeDLNode<>();
        for (int i = 0; i < 10; i++) {
            dequeDLNode.insertFirst(i);
        }
        while (!dequeDLNode.isEmpty()){
            System.out.println(dequeDLNode.removeLast());
        }
        System.out.println("------------");
        System.out.println(dequeDLNode.header);
        System.out.println(dequeDLNode.trailer.getPrev());
        System.out.println(dequeDLNode.header.getNext());
        System.out.println(dequeDLNode.trailer);
        for (int i = 0; i < 10; i++) {
            dequeDLNode.insertLast(i);
        }
        System.out.println(dequeDLNode.isEmpty());
        while (!dequeDLNode.isEmpty()){
            System.out.println(dequeDLNode.removeFirst());
        }

    }

}
