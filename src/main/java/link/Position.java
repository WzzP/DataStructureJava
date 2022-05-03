package link;

public interface Position <T> {
    /**
     * 返回存放于该位置的元素
     * @return T
     */
    public T getElem();

    /**
     * 将给定元素存放至改位置，返回此前存放的元素
     * @param e 元素
     * @return T
     */
    public T setElem(T e);
}
