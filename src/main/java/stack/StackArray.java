package stack;

import java.util.ArrayList;

/**
 * 栈的数组实现
 * @param <T>
 */
public class StackArray<T > implements Stack<T> {

    public static final int CAPACITY=1024;//数组默认容量
    protected Object[] S; //对象数组
    protected int capacity; //数组实际容量
    private int top = -1; //栈顶元素位置

    public StackArray(int capacity) {
        this.capacity = capacity;
        S  = new Object[capacity];
    }

    public StackArray(){
        this(CAPACITY);
    }


    @Override
    public void push(T x) {
        if (getSize() < capacity){
            S[++top] = x;
        } else {
            throw new ExceptionStackFull();
        }
    }

    @Override
    public T pop() throws ExceptionStackEmpty {
        if (isEmpty()){
            throw new ExceptionStackEmpty();
        }
        Object elem;
        elem = S[top];
        S[top--] = null;
        return (T) elem;
    }

    @Override
    public int getSize() {
        return top+1;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public T top() throws ExceptionStackEmpty {
        if (isEmpty()){
            throw new ExceptionStackEmpty();
        }
        return (T) S[top];
    }

    public static void main(String[] args) {
        StackArray<Integer> stackArray = new StackArray<>();
        stackArray.push(5);
        stackArray.push(3);
        System.out.println(stackArray.pop());
        stackArray.push(7);
        System.out.println(stackArray.pop());
        System.out.println(stackArray.pop());
        stackArray.pop();
    }
}
