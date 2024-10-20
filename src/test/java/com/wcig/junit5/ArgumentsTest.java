package com.wcig.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 参数化测试
 */
public class ArgumentsTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testValueSource(int num) {
        assertTrue(num > 0);
    }

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    public void testEnumSource(TimeUnit timeUnit) {
        System.out.println(timeUnit);
        // Output:
        // NANOSECONDS
        // MICROSECONDS
        // MILLISECONDS
        // SECONDS
        // MINUTES
        // HOURS
        // DAYS
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, names = {"DAYS", "HOURS", "MINUTES"})
    public void testEnumSourceInclude(TimeUnit timeUnit) {
        System.out.println(timeUnit);
        // Output:
        // MINUTES
        // HOURS
        // DAYS
    }

    @ParameterizedTest
    @EnumSource(value = TimeUnit.class, mode = EnumSource.Mode.EXCLUDE, names = {"DAYS", "HOURS", "MINUTES"})
    public void testEnumSourceExclude(TimeUnit timeUnit) {
        System.out.println(timeUnit);
        // Output:
        // NANOSECONDS
        // MICROSECONDS
        // MILLISECONDS
        // SECONDS
    }

    // 引用一个或多个静态方法, 方法必须返回一个Stream，Iterable，Iterator或者参数数组
    @ParameterizedTest
    @MethodSource("integerProvider")
    public void testMethodSource(Integer num) {
        assertTrue(num > 0);
    }

    public static Stream<Integer> integerProvider() {
        return Stream.of(1, 2, 3);
    }

    @ParameterizedTest
    @CsvSource({"tom, 1", "jerry, 2", "'abc, xyz', 3"})
    void testWithCsvSource(String first, int second) {
        System.out.println(first + "|" + second);
        // Output:
        // tom|1
        // jerry|2
        // abc, xyz|3
    }
}
