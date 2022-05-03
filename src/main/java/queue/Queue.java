package queue;

public interface Queue<T> {

    /**
     * 将元素x加到队列末端
     * @param x 输入对象
     */
    public void enqueue(T x);

    /**
     * 若队列非空，则将队首元素移除，并将其返回，否则报错
     * @return 队顶元素
     */
    public T dequeue() throws ExceptionQueueEmpty;

    /**
     * 返回队列中当前包含的元素目
     * @return int
     */
    public int getSize();

    /**
     * 判断队列是否为空
     * @return 布尔
     */
    public boolean isEmpty();

    /**
     * 若队列非空，则返回队首元素,但并不移除
     * @return T
     */
    public T front() throws ExceptionQueueEmpty;




}
