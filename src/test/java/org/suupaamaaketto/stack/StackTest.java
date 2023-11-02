package org.suupaamaaketto.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows; 

import org.junit.jupiter.api.Test;

public class StackTest {
    

    @Test
    public void assert_false() {
        // assertTrue(false); // Uncomment me to check that tests are running. This should fail.
    }

    @Test
    public void stackShouldBeEmpty() {
        Stack stack = new Stack();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void stackShouldHaveOneElementAfterPush() {
        Stack stack = new Stack();
        stack.push("foo");
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void poppingAnEmptyStackShouldThrowAnUnderflowException(){
        //Arrange
        Stack stack=new Stack();
        //Act
        //Assert
        assertThrows(UnderFlowException.class,()->stack.pop());
    }

}
