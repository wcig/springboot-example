package com.wcig.junit5;

import org.junit.jupiter.api.*;

/**
 * 生命周期
 */
public class LifeCycleTest {
    // 在所有测试方法执行前执行一次, 必须是static方法
    @BeforeAll
    public static void initAll() {
        System.out.println("BeforeAll");
    }

    // 在所有测试方法执行后执行一次, 必须是static方法
    @AfterAll
    public static void tearDownAll() {
        System.out.println("AfterAll");
    }

    // 在每个测试方法执行前执行一次, 必须是static方法
    @BeforeEach
    public void init() {
        System.out.println("BeforeEach");
    }

    // 在每个测试方法执行后执行一次, 必须是static方法
    @AfterEach
    public void tearDown() {
        System.out.println("AfterEach");
    }

    @Test
    public void testSuccess() {
        System.out.println("testSuccess");
    }

    @Test
    public void testSuccess2() {
        System.out.println("testSuccess2");
    }

    // 某个单元测试方法失败不影响整个单元测试, 后续的测试方法会继续执行
    @Test
    public void testFail() {
        System.out.println("testFail");
        Assertions.fail("testFail");
    }

    // @Disabled注解, 添加在方法上忽略该测试方法, 添加在类文件上忽略该类所有测试方法
    @Disabled("the test method is deprecated")
    @Test
    public void testDisabled() {
        System.out.println("testDisabled");
    }
}

// Output:
// BeforeAll
// BeforeEach
// testSuccess2
// AfterEach
// BeforeEach
// testFail
// AfterEach
//
// org.opentest4j.AssertionFailedError: testFail
//
// 	at org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:38)
// 	at org.junit.jupiter.api.Assertions.fail(Assertions.java:138)
// 	at com.wcig.junit5.LifeCycleTest.testFail(LifeCycleTest.java:47)
// 	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
// 	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
// 	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
//
//
// the test method is deprecated
// BeforeEach
// testSuccess
// AfterEach
// AfterAll
