package org.suupaamaaketto.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {


    private Stack stack = new Stack();

    @Test
    public void assert_false() {
        // assertTrue(false); // Uncomment me to check that tests are running. This should fail.
    }

    @Test
    public void stackShouldBeEmpty() {
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void stackShouldHaveOneElementAfterPush() {
        stack.push("foo");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void poppingAnEmptyStackShouldThrowAnUnderflowException(){
        assertThrows(UnderFlowException.class,()->stack.pop());
    }

    @Test
    public void afterPushAndPoStackShouldBeEmpty() throws UnderFlowException {
        stack.push("test");
        stack.pop();

        assertTrue(stack.isEmpty(), "Stack should be empty");
    }

    @Test
    public void afterTwoPushAndOnePopStackShouldNotBeEmpty() throws UnderFlowException {
        stack.push("foo");
        stack.push("bar");
        stack.pop();
        assertFalse(stack.isEmpty(), "stack should NOT be empty");
    }

    @Test
    public void afterPushingAnItemAndPopItShouldReturnTheSameItem() throws UnderFlowException{
        String item1="item1";
        stack.push(item1);
        String returendValue=stack.pop();
        assertEquals(item1,returendValue,"The rturn item should be the same as pushed item");
    }

}
