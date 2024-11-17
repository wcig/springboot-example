package com.wcig.mockito;

import com.wcig.service.mockito.ServiceA;
import com.wcig.service.mockito.ServiceB;
import com.wcig.service.mockito.ServiceC;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

// ServiceA -> ServiceB -> ServiceC: 可使用以下方式 mock ServiceC 方法 (推荐直接 mock 当前类依赖, 不推荐 mock 其依赖的依赖)
// 参考: https://stackoverflow.com/questions/6300439/multiple-levels-of-mock-and-injectmocks
@ExtendWith(MockitoExtension.class)
public class MultiMockTest {
    @InjectMocks
    private ServiceA serviceA = new ServiceA();

    @InjectMocks
    private ServiceB serviceB = spy(ServiceB.class);

    @Spy
    private ServiceC serviceC;

    @Test
    public void testA() {
        when(serviceC.testC()).thenReturn(123);
        int val = serviceA.testA();
        assertEquals(123, val);
    }
}
