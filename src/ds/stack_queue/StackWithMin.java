package ds.stack_queue;

import java.util.EmptyStackException;

public class StackWithMin {
    private MyStack<Integer> stack;
    private MyStack<Integer> stackMin;

    public StackWithMin() {
        stack = new MyStack<>();
        stackMin = new MyStack<>();
    }

    public void push(Integer item) {
        stack.push(item);

        if (stackMin.isEmpty()) {
            stackMin.push(item);
        } else if (item < stackMin.peek()) {
            stackMin.pop();
            stackMin.push(item);
        }
    }

    public Integer pop() {
        if (stack.peek().equals(stackMin.peek())) {
            Integer item = stackMin.peek();
            stackMin.pop();
            stack.pop();
            return item;
        } else {
            Integer item = stack.peek();
            stack.pop();
            return item;
        }
    }

    public Integer min() {
        if (stackMin.isEmpty()) {
            throw new EmptyStackException();
        }
        return stackMin.peek();
    }
}
