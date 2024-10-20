package com.wcig.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * spy
 * spy 与 mock 有两个区别: 1)spy创建对象实例时入参为对象; 2)spy默认走真实方法
 */
@ExtendWith(MockitoExtension.class)
public class SpyTest {
    @Spy
    Math math2;

    @Test
    public void testSpy() {
        Math math = spy(new Math());

        // 未打桩时, 走默认方法
        assertEquals(3, math.sum(1, 2));

        // 打桩后, 方法返回打桩设定的值
        when(math.sum(1, 2)).thenReturn(12);
        assertEquals(12, math.sum(1, 2));

        // 方法参数与打桩参数不匹配时, 走默认方法
        assertEquals(3, math.sum(2, 1));
    }

    @Test
    public void testSpyAnnotation() {
        when(math2.sum(1, 2)).thenReturn(12);
        assertEquals(12, math2.sum(1, 2));
    }

    class Math {
        public int sum(int a, int b) {
            return a + b;
        }
    }
}
