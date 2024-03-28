package com.coding.hezijian6338;

import com.coding.hezijian6338.service.Alphabet;
import com.coding.hezijian6338.service.impl.ConsecutiveImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * st.1 基础任务, 正确值测试. (阶段1 单次)
     * @throws Exception
     */
    @Test
    void st1() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("b");
        list.add("b");
        list.add("a");
        list.add("d");



        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.stageOne(Arrays.asList("a", "a", "b", "c", "c", "c", "b", "b", "a", "d"), r -> {
            assertEquals(Arrays.asList("a", "a", "b", "b", "b", "a", "d"), r);
        });
    }

    /**
     * st.2 基础任务, 正确值测试. (阶段1 完整结果)
     * @throws Exception
     */
    @Test
    void st2() throws Exception {
        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.outputStageOne(Arrays.asList("a", "a", "b", "c", "c", "c", "b", "b", "a", "d"), r -> {
            assertEquals(Arrays.asList("d"), r);
        });
    }

    /**
     * st.3 基础任务, 正确值测试. (阶段2 完整结果)
     * @throws Exception
     */
    @Test
    void st3() throws Exception {
        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.outputStageTwo(Arrays.asList("a", "b", "c", "c", "c", "b", "a", "d"), r -> {
            assertEquals(Arrays.asList("d"), r);
        });
    }

    /**
     * st.4.1 数组空值测试. (阶段1)
     * @throws Exception
     */
    @Test
    void st4_1() throws Exception {
        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.outputStageOne(Arrays.asList(), r -> {
            assertEquals(Arrays.asList(), r);
        });
    }

    /**
     * st.4.2 数组空值测试. (阶段2)
     * @throws Exception
     */
    @Test
    void st4_2() throws Exception {
        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.outputStageTwo(Arrays.asList(), r -> {
            assertEquals(Arrays.asList(), r);
        });
    }

    /**
     * st.5.1 数组不在字母表中. (阶段1)
     * @throws Exception
     */
    @Test()
    void st5_1() throws Exception {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ConsecutiveImpl consecutive = new ConsecutiveImpl();
            consecutive.outputStageOne(Arrays.asList(","), r -> {
                assertEquals(Arrays.asList(), r);
            });
        });
        assertEquals("不在字母表中! ", exception.getMessage());
    }

    /**
     * st.5.2 数组不在字母表中. (阶段2)
     * @throws Exception
     */
    @Test()
    void st5_2() throws Exception {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            ConsecutiveImpl consecutive = new ConsecutiveImpl();
            consecutive.outputStageTwo(Arrays.asList(","), r -> {
                assertEquals(Arrays.asList(), r);
            });
        });
        assertEquals("不在字母表中! ", exception.getMessage());
    }

    /**
     * st.99.1 父类方法测试, 不在字母表中.
     */
    @Test
    void st99_1() {
        char t = "[".charAt(0);
        Alphabet al = new Alphabet();
        boolean res = al.isInAlphabet(t);
        assertFalse(res);
    }

    /**
     * st.99.2 父类方法测试, 在字母表中.
     */
    @Test
    void st99_2() {
        char t = "c".charAt(0);
        Alphabet al = new Alphabet();
        boolean res = al.isInAlphabet(t);
        assertTrue(res);
    }
}
