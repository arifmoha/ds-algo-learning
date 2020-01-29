package ds.stack_queue;

import java.util.NoSuchElementException;

public class MyQueue<T> {

    private static class QueueNode<T> {
        T item;
        QueueNode<T> next;

        QueueNode(T item) {
            this.item = item;
        }
    }

    private QueueNode<T> top;
    private QueueNode<T> end;

    public boolean isEmpty(){
        return top == null;
    }

    public void add(T item){
        QueueNode<T> qn = new QueueNode<>(item);
        if(end == null){
            top = qn;
            end = qn;
        }
        else {
           end.next = qn;
           end = qn;
        }
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        return top.item;
    }

    public T remove(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        T item = top.item;
        top = top.next;
        return item;
    }
}
