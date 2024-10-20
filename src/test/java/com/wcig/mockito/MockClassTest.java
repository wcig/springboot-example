package com.wcig.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * mock 对象实例
 */
public class MockClassTest {
    @Test
    public void testMockRandom() {
        Random random = mock(Random.class);
        when(random.nextBoolean()).thenReturn(true);
        when(random.nextInt()).thenReturn(123);

        assertEquals(true, random.nextBoolean());
        assertEquals(123, random.nextInt());

        // 调用多次都是返回一样的结果
        assertEquals(true, random.nextBoolean());
        assertEquals(123, random.nextInt());
    }

    @Test
    public void testMockList() {
        List<String> list = mock(List.class);

        // 没有 mock 方法时, 默认为初始值
        assertEquals(0, list.size());

        // mock 方法
        when(list.size()).thenReturn(1);
        when(list.get(0)).thenReturn("tom");

        assertEquals(1, list.size());
        assertEquals("tom", list.get(0));

        // 这里给 list 添加元素是无效的
        list.add("jerry");
        assertEquals(1, list.size());
        assertEquals("tom", list.get(0));
    }
}
