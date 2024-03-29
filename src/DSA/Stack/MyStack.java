// 05-10-2022 12:33 October

package DSA.Stack;

public class MyStack {
    private final int maxSize;
    private final long[] stackArray;
    private int top;
    
    public MyStack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    
    public void push(long j) {
        stackArray[++top] = j;
    }
    
    public long pop() {
        return stackArray[top--];
    }
    
    public long peek() {
        return stackArray[top];
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
