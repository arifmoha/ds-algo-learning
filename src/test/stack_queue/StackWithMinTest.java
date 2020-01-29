package test.stack_queue;

import ds.stack_queue.StackWithMin;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class StackWithMinTest {

    StackWithMin stack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        stack = new StackWithMin();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        stack = null;
    }

    @Test
    void testPush(){
        stack.push(3);
        assertEquals(3, stack.min());
        stack.push(2);
        assertEquals(2, stack.min());
        stack.push(5);
        assertEquals(2, stack.min());
    }

    @Test
    void testPop(){
        stack.push(3);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertThrows(EmptyStackException.class, stack::min);
    }
}
