package com.wcig.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * 参数匹配
 */
@ExtendWith(MockitoExtension.class)
public class ArgumentMatchTest {
    @Mock
    private Random random;

    @Test
    public void testWithArgumentMatch() {
        when(random.nextInt(anyInt())).thenReturn(123);
        assertEquals(123, random.nextInt(10));
        assertEquals(123, random.nextInt(1000));
    }
}

// | any()                | 所有对象类型                             |
// | anyInt()             | 基本类型 int、非 null 的 Integer 类型     |
// | anyChar()            | 基本类型 char、非 null 的 Character 类型  |
// | anyShort()           | 基本类型 short、非 null 的 Short 类型     |
// | anyBoolean()         | 基本类型 boolean、非 null 的 Boolean 类型 |
// | anyDouble()          | 基本类型 double、非 null 的 Double 类型   |
// | anyFloat()           | 基本类型 float、非 null 的 Float 类型     |
// | anyLong()            | 基本类型 long、非 null 的 Long 类型       |
// | anyByte()            | 基本类型 byte、非 null 的 Byte 类型       |
// | anyString()          | String 类型(不能是 null)                 |
// | anyList()            | `List<T>` 类型(不能是 null)              |
// | anyMap()             | `Map<K, V>`类型(不能是 null)             |
// | anyCollection()      | `Collection<T>`类型(不能是 null)         |
// | anySet()             | `Set<T>`类型(不能是 null)                |
// | any(`Class<T>` type) | type类型的对象(不能是 null)               |
// | isNull()             | null                                    |
// | notNull()            | 非 null                                 |
// | isNotNull()          | 非 null                                 |