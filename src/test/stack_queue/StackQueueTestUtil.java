package test.stack_queue;

import ds.stack_queue.MyStack;

public class StackQueueTestUtil {
    StringBuilder sb = new StringBuilder();
    public String stackElementsAsString(MyStack s){
        while(!s.isEmpty()){
            sb.append(s.pop());
            if(!s.isEmpty()) sb.append(" ,");
        }

        return sb.toString();
    }
}
