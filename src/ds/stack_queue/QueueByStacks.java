package ds.stack_queue;

public class QueueByStacks {
    private MyStack<Integer> stack1;
    private MyStack<Integer> stack2;

    public QueueByStacks() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    public void add(int item) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack1.push(item);
    }

    public int remove() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.peek();
    }
}
