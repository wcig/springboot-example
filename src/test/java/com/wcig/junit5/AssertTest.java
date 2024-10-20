package com.wcig.junit5;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 断言测试
 */
public class AssertTest {
    @Test
    public void testAssertTrue() {
        assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        assertFalse(false);
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(123);
    }

    @Test
    public void testAssertNull() {
        assertNull(null);
    }

    @Test
    public void testAssertEquals() {
        int num1 = 1, num2 = 1;
        assertEquals(num1, num2);

        String str1 = "abc", str2 = "abc";
        assertEquals(str1, str2);

        User user1 = new User(1, "abc");
        User user2 = new User(1, "abc");
        assertEquals(user1, user2);

        List<User> list1 = Arrays.asList(user1, user2);
        List<User> list2 = Arrays.asList(user1, user2);
        assertEquals(list1, list2);
    }

    @Test
    public void testAssertNotEquals() {
        int num1 = 1, num2 = 2;
        assertNotEquals(num1, num2);

        String str1 = "abc", str2 = "xyz";
        assertNotEquals(str1, str2);

        User user1 = new User(1, "abc");
        User user2 = new User(2, "xyz");
        assertNotEquals(user1, user2);

        List<User> list1 = Arrays.asList(user1, user2);
        List<User> list2 = Arrays.asList(user2, user2);
        assertNotEquals(list1, list2);
    }

    // assertSame用于比较两个对象的引用是否相等, 不能用于基础类型比较
    @Test
    public void testAssertSame() {
        User user1 = new User(1, "abc");
        User user2 = user1;
        assertSame(user1, user2);
    }

    @Test
    public void testAssertNotSame() {
        User user1 = new User(1, "abc");
        User user2 = new User(2, "xyz");
        assertNotSame(user1, user2);
    }

    @Test
    public void testAssertAll() {
        assertAll("all",
                () -> assertTrue(true),
                () -> assertFalse(false)
        );
    }

    @Test
    public void testAssertTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(80);
        });
    }

    @Test
    public void testAssertDoesNotThrow() {
        assertDoesNotThrow(() -> {
            Integer.valueOf("1");
        });
    }

    @Test
    public void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf("");
        });
    }

    // 重复执行指定次数
    @RepeatedTest(3)
    public void testRepeated() {
        System.out.println("testRepeated");
    }

    @Data // 实现 getters, toString, hashCode, equals 方法
    @AllArgsConstructor
    public class User {
        private int id;
        private String name;
    }
}
