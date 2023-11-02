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
//        Stack stack = new Stack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void stackShouldHaveOneElementAfterPush() {
//        Stack stack = new Stack();
        stack.push("foo");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void poppingAnEmptyStackShouldThrowAnUnderflowException(){
        //Arrange
//        Stack stack=new Stack();
        //Act
        //Assert
        assertThrows(UnderFlowException.class,()->stack.pop());
    }

    @Test
    public void afterPushAndPoStackShouldBeEmpty() throws UnderFlowException {
        stack.push("test");
        stack.pop();

        assertTrue(stack.isEmpty(), "Stack should be empty");
    }

}
