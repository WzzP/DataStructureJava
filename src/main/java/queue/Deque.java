package queue;

/**
 * 双头队列
 */
public interface Deque<T> {
    /**
     * 将对象x作为首元素插入
     *
     * @param x 输入元素
     */
    public void insertFirst(T x);

    /**
     * 将对象x作为末元素插入
     *
     * @param x 输入元素
     */
    public void insertLast(T x);

    /**
     * 若队列非空，将首元素删除，并将其内容返回。否则、报错
     *
     * @return T
     */
    public T removeFirst() throws ExceptionQueueEmpty;

    /**
     * 若队列非空，则将末元素删除，并将其内容返回，否则、报错
     *
     * @return T
     */
    public T removeLast() throws ExceptionQueueEmpty;

    /**
     * 若队列非空，返回队首元素的内容，否则报错
     *
     * @return T
     */
    public T first() throws ExceptionQueueEmpty;

    /**
     * 若队列非空，返回队首元素的内容，否则报错
     *
     * @return T
     */
    public T last() throws ExceptionQueueEmpty;

    public int getSize();

    public boolean isEmpty();

}
