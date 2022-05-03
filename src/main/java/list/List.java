package list;

import link.Position;

public interface List<T> {
    /**
     * 若S非空，则给出第一个元素的位置，否则报错
     * @return 位置
     */
    public Position<T> first();

    /**
     * 若S非空，则给出其中最后一个元素的位置，否则报错
     * @return 位置
     */
    public Position<T> last();

    /**
     * 若p不是第一个位置，则给出S中p的前驱所在的位置，否则报错
     * @param p
     * @return
     */
    public Position<T> getPrev(Position<T> p);

    /**
     *若P不是最后一个位置，则给出S中p的前驱所在的位置
     */
    public Position<T> getNext(Position<T> p);

}
