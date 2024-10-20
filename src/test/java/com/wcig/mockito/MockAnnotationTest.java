package com.wcig.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * mock 注解
 */
@ExtendWith(MockitoExtension.class)
public class MockAnnotationTest {
    @Mock
    private Random random;

    @Test
    public void testWithAnnotation() {
        when(random.nextBoolean()).thenReturn(true);
        when(random.nextInt()).thenReturn(123);

        assertEquals(true, random.nextBoolean());
        assertEquals(123, random.nextInt());

        // 调用多次都是返回一样的结果
        assertEquals(true, random.nextBoolean());
        assertEquals(123, random.nextInt());
    }
}
