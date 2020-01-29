package test.stack_queue;

import ds.exceptions.FullStackException;
import ds.stack_queue.MyStack;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

        MyStack<Integer> stack;

        @org.junit.jupiter.api.BeforeEach
        void setUp() {
            stack = new MyStack<>();
        }

        @org.junit.jupiter.api.AfterEach
        void tearDown() {
            stack = null;
        }

        @Test
       void testPush(){
            stack.push(3);
            assertEquals(3, stack.peek());

            stack.push(2);
            assertEquals(2, stack.peek());

            stack.push(1);
            assertEquals(1, stack.peek());
        }

        @Test
        void testPop(){
            stack.push(3);
            stack.push(2);
            stack.push(1);

            assertEquals(1,stack.pop());
            assertEquals(2,stack.peek());

            assertEquals(2,stack.pop());
            assertEquals(3,stack.peek());

            assertEquals(3,stack.pop());
            assertTrue(stack.isEmpty());

            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        void testStackIsFull(){
            MyStack<Integer> stack = new MyStack<>(3);
            stack.push(3);
            stack.push(2);
            stack.push(1);

            assertTrue(stack.isFull());

            assertThrows(FullStackException.class, () -> stack.push(99));
        }

}