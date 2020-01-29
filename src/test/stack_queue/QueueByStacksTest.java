package test.stack_queue;

import ds.stack_queue.QueueByStacks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueByStacksTest {

    QueueByStacks queue;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        queue = new QueueByStacks();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    void testQueue(){
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(2, queue.peek());
    }
}
