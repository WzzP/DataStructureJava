package queue;

import stack.ExceptionStackFull;

/**
 * 基于数组的队列实现
 */
public class QueueArray<T> implements Queue<T> {

    private static int CAPACITY=1024; //队列容量
    private final int capacity;
    private Object[] Q; // 存放队列数据的数组；
    private int f = 0; //队首元素位置
    private int r = 0; //队末元素位置
    public QueueArray(int capacity){
        this.capacity = capacity;
        this.Q = new Object[capacity];
    }

    public QueueArray() {
        this(CAPACITY);
    }


    @Override
    public void enqueue(T x) {
        if (getSize() < capacity -1 ){
            Q[r] = (Object) x;
            r = (r+1) % capacity; //循环使用数组位置
        } else {
            throw new ExceptionQueueFull();
        }
    }

    @Override
    public T dequeue() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        Object elem = Q[f];
        Q[f] = null;
        f = (f+1) % capacity;
        return (T) elem;
    }

    @Override
    public int getSize() {
        return (capacity -f + r) % capacity;
    }

    @Override
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    public T front() throws ExceptionQueueEmpty {
        if (isEmpty()){
            throw new ExceptionQueueEmpty();
        }
        return (T) Q[f];
    }

    public static void main(String[] args) {
        QueueArray<Integer> q = new QueueArray(10);
        for (int i = 0; i < 10; i++) {
            try {
                q.enqueue(i);
            } catch (ExceptionQueueFull ex){
                System.out.println(q.getSize());
                System.out.println(q.front());
                System.out.println(q.Q.length);
                break;
            }

        }
        System.out.println(q.Q.toString());
//        while (!q.isEmpty()){
//            System.out.println(q.dequeue());
//        }
    }
}
