package stack;

public interface Stack<T> {

    /**
     * 将对象X压至栈顶
     * @param x 要压入的对象
     */
    public void push(T x);

    /**
     * 若栈非空，则将栈顶对象移除，并将其返回 否则，报错
     * @return 栈顶对象
     */
    public T pop() throws ExceptionStackEmpty;

    /**
     * 返回栈内当前对象的数目
     * @return 非负整数
     */
    public int getSize();

    /**
     *检查栈是否为空
     * @return 检查栈是否为空
     */
    public boolean isEmpty();

    /**
     * 若栈非空，则返回栈顶对象（但并不移除）
     * @return T 栈顶对象
     */
    public T top() throws ExceptionStackEmpty;

}
