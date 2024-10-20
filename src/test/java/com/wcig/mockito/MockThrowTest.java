package com.wcig.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

/**
 * mock 异常
 */
@ExtendWith(MockitoExtension.class)
public class MockThrowTest {
    @Mock
    private Random random;

    @Mock
    private User user;

    @Test
    public void testMockThrow() {
        when(random.nextInt()).thenThrow(new RuntimeException("exception"));

        try {
            int val = random.nextInt();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertEquals("exception", e.getMessage());
        }
    }

    @Test
    public void testMockThrowMultiException() {
        // thenThrow 传参多个异常时, 调用时异常依次数显
        when(random.nextInt()).thenThrow(new RuntimeException("exception-1"), new RuntimeException("exception-2"));

        try {
            int val = random.nextInt();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertEquals("exception-1", e.getMessage());
        }

        try {
            int val = random.nextInt();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertEquals("exception-2", e.getMessage());
        }
    }

    @Test
    public void testDoThrow() {
        doThrow(new RuntimeException("exception")).when(user).ok();

        try {
            user.ok();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
            assertEquals("exception", e.getMessage());
        }
    }

    class User {
        public void ok() {
        }
    }
}
