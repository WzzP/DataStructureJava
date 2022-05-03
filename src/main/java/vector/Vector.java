package vector;

public interface Vector <T> {
    /**
     * 报告向量中的元素数目
     * @return 非负整数
     */
    public int getSize();

    /**
     *判断向量是否为空
     * @return 布尔值
     */
    public boolean isEmpty();

    /**
     * 若 0 < r < getSize() 则返回rank为r的元素
     * @param r 整数rank
     * @return T
     */
    public T getRank(int r) throws ExceptionBoundaryViolation;

    /**
     * 若 0 < r < getSize() 则将rank为r的元素替换为e，并返回原来元素
     * @param r 整数rank
     * @return T 杯替换掉的元素
     */
    public T replaceAtRank(int r, T e) throws ExceptionBoundaryViolation;

    /**
     * 若 0 < r < getSize() 则将e插入向量，作为rank为r的元素（原rank不小于r的元素顺次后移），并返回该元素，否则报错
     * @param r 插入的rank位置 非负整数
     * @param e 插入的对象
     * @return T
     */
    public T insertAtRank(int r, T e) throws ExceptionBoundaryViolation;

    /**
     * 若0 < r < getSize() 则删除rank为r的那个元素并返回之（原rank大于r的元素顺次前移）
     * @param r 非负整数
     * @return
     */
    public T removeAtRank(int r) throws ExceptionBoundaryViolation;
}
