package org.suupaamaaketto.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void assert_false() {
        // assertTrue(false); // Uncomment me to check that tests are running. This should fail.
    }

    @Test
    public void test_main_return_string() {
        Main main = new Main();
        assertEquals(String.class, main.call("").getClass());
        assertEquals("{}", main.call(""));
    }
}
