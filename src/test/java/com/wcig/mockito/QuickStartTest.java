package com.wcig.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * 快速开始 (Mockito 不支持静态方法 mock, 可以用 Powermock 支持)
 */
public class QuickStartTest {
    @Test
    public void testFirst() {
        // mock DemoDao 实例
        DemoDao demoDao = Mockito.mock(DemoDao.class);

        // 打桩 total 方法
        Mockito.when(demoDao.total()).thenReturn(123);

        // 使用 mock 对象的 total 方法结果都是 123
        int result1 = demoDao.total();
        Assertions.assertEquals(123, result1);

        DemoService demoService = new DemoService(demoDao);
        int result2 = demoService.total();
        Assertions.assertEquals(123, result2);
    }
}
