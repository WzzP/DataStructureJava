package vector;

import java.util.Vector;

public class VectorExtArray<T> extends VectorArray<T> {


    @Override
    public T insertAtRank(int r, T e) throws ExceptionBoundaryViolation {
        if (r < 0 || r > size){
            throw new ExceptionBoundaryViolation();
        }
        if (size >= capacity){ //数组容量到达极限
            System.out.printf("Extend: %s%n", capacity);
            capacity = capacity * 2;
            Object[] array2 = new Object[capacity];
            if (getSize() >= 0) System.arraycopy(array, 0, array2, 0, getSize());
            array = array2;
        }
        for (int i = size; i > r; i--) {
            array[i] = array[i - 1];
        }
        array[r] = e;
        size++;
        return e;
    }

    public VectorExtArray(int capacity) {
        super(capacity);
    }

    public VectorExtArray() {
        super();
    }

    public static void main(String[] args) {
        VectorExtArray<Integer> vectorExtArray = new VectorExtArray<>(10);
        for (int i = 0; i < 1024; i++) {
            vectorExtArray.insertAtRank(i, i);
        }
        for (int i = 0; i < 1024; i++) {
            System.out.println(vectorExtArray.removeAtRank(0));
        }

    }
}
