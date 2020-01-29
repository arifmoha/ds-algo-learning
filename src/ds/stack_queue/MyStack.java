package ds.stack_queue;

import ds.exceptions.FullStackException;

import java.util.EmptyStackException;

public class MyStack<T> {

    private static class StackNode<T> {
        T item;
        StackNode<T> next;

        StackNode(T item) {
            this.item = item;
        }
    }



    private StackNode<T> top;
    private int size=0;
    private int capacity;
    private int DEFAULT_CAPACITY=5;

    public MyStack(){
        capacity = DEFAULT_CAPACITY;
    }

    public MyStack(int capacity){
        this.capacity = capacity;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = top.item;
        top = top.next;
        return item;
    }

    public void push(T item) {
        if(isFull()){
            throw new FullStackException("Stack is Full");
        }

        if (top == null) {
            top = new StackNode<>(item);
        } else {
            StackNode<T> newItem = new StackNode<>(item);
            newItem.next = top;
            top = newItem;
        }
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull(){
        return size == capacity;
    }
}
