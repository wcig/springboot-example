package com.wcig.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * mock 打桩在不同方法是隔离的
 */
@ExtendWith(MockitoExtension.class)
public class IsolationTest {
    @Spy
    private Math math;

    @Test
    public void test1() {
        assertEquals(3, math.sum(1, 2));

        when(math.sum(1, 2)).thenReturn(12);

        assertEquals(12, math.sum(1, 2));
    }

    @Test
    public void test2() {
        assertEquals(3, math.sum(1, 2));

        when(math.sum(1, 2)).thenReturn(12);

        assertEquals(12, math.sum(1, 2));
    }

    class Math {
        public int sum(int a, int b) {
            return a + b;
        }
    }
}
