package main;

import components.barrier.Barrier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarrierTest {
    private Barrier barrier;

    @BeforeEach
    void setUp() {
        barrier = new Barrier();
    }

    @Test
    void open() {
        barrier.open();
        assertTrue(barrier.isOpen());
    }

    @Test
    void close() {
        barrier.close();
        assertFalse(barrier.isOpen());
    }

    @Test
    void isOpen() {
        assertFalse(barrier.isOpen());
        barrier.open();
        assertTrue(barrier.isOpen());
        barrier.close();
        assertFalse(barrier.isOpen());
    }
}
