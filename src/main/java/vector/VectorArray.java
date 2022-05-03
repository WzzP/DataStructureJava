package vector;

/**
 * 基于数组的向量实现
 *
 * @param <T>
 */
public class VectorArray<T> implements Vector<T> {
    private static final int CAPACITY = 1024;
    protected int capacity;
    protected int size;
    protected Object[] array;

    public VectorArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public VectorArray() {
        this(CAPACITY);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public T getRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= size) {
            throw new ExceptionBoundaryViolation();
        }
        return (T) array[r];
    }

    @Override
    public T replaceAtRank(int r, T e) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= size) {
            throw new ExceptionBoundaryViolation();
        }
        T elem = (T) array[r];
        array[r] = e;
        return elem;
    }

    @Override
    public T insertAtRank(int r, T e) throws ExceptionBoundaryViolation {
        if (r < 0 || r > size) {
            throw new ExceptionBoundaryViolation();
        }
        for (int i = size; i > r; i--) {
            array[i] = array[i - 1];
        }
        array[r] = e;
        size++;
        return e;
    }

    @Override
    public T    removeAtRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= size) {
            throw new ExceptionBoundaryViolation();
        }
        T elem = (T) array[r];
        for (int i = r; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return elem;
    }

    public static void main(String[] args) {
        VectorArray<Integer> integerVectorArray = new VectorArray<>();
        System.out.println(integerVectorArray.insertAtRank(0, 9));
        System.out.println(integerVectorArray.insertAtRank(0, 4));
        System.out.println(integerVectorArray.getRank(1));
        System.out.println(integerVectorArray.insertAtRank(2, 5));
        System.out.println(integerVectorArray.getSize());

//        System.out.println(integerVectorArray.getRank(3));
    }
}
