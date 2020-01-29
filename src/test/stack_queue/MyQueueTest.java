package test.stack_queue;

import ds.stack_queue.MyQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {

    MyQueue<Integer> queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        queue = new MyQueue<>();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void testAdd(){
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1, queue.peek());
    }

    @Test
    void testRemove(){
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.remove();
        assertEquals(2, queue.peek());

        queue.remove();
        assertEquals(3, queue.peek());

        queue.remove();
        assertTrue(queue.isEmpty());
    }
}
