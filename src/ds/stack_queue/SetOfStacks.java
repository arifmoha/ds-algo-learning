package ds.stack_queue;

import ds.exceptions.FullStackException;

import java.util.EmptyStackException;

public class SetOfStacks {

    private MyStack[] arrayOfStacks;
    private int index = -1;
    private int capacity;
    private int stackCapacity;

    SetOfStacks(int capacity, int stackCapacity) {
        arrayOfStacks = new MyStack[capacity];
        this.capacity = capacity;
        this.stackCapacity = stackCapacity;
    }

    public void push(int item) {
        if(isStackSetFull()){
            throw new FullStackException("No Stacks Available");
        }
        if (isStackSetEmpty() || arrayOfStacks[index].isFull()) {
          MyStack<Integer> stack = new MyStack<>(stackCapacity);
          stack.push(item);
          arrayOfStacks[index++]=stack;
        }
        else{
            MyStack stack = arrayOfStacks[index];
            stack.push(item);
        }
    }

    public int pop(){
        if(isStackSetEmpty()){
            throw new EmptyStackException();
        }

        int item = -1;
        if(arrayOfStacks[index].isEmpty()){
            index = index-1;
            if(isStackSetEmpty()){
                throw new EmptyStackException();
            }
            item = (int) arrayOfStacks[index].pop();
        }
        return item;
    }

    public int popAt(int index) {
        if (!isStackSetFull()) {
            return (int) arrayOfStacks[index].pop();
        }
        return -1;
    }

    public boolean isStackSetFull(){
        return index+1 == capacity;
    }

    public boolean isStackSetEmpty(){
        return index == -1;
    }
}
