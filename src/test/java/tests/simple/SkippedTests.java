package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkippedTests {

    @Test
    @Disabled
    void test00() {
        assertTrue(false);
    }

    @Test
    @Disabled
    void test010() {
        assertTrue(false);
    }

    @Test
    @Disabled
    void test020() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void test030() {
        assertTrue(false);
    }
}
