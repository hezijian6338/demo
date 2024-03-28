package com.coding.hezijian6338;

import org.junit.jupiter.api.Test;
import com.coding.hezijian6338.service.impl.ConsecutiveImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * st.1 基础任务, 正确值测试. (单次)
     */
    @Test
    void st1() {
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
     * 基础任务, 正确值测试. (完整结果)
     */
    @Test
    void st2() {
        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.outputStageOne(Arrays.asList("a", "a", "b", "c", "c", "c", "b", "b", "a", "d"), r -> {
            assertEquals(Arrays.asList("d"), r);
        });
    }

    @Test
    void st3() {
        ConsecutiveImpl consecutive = new ConsecutiveImpl();
        consecutive.outputStageTwo(Arrays.asList("a", "b", "c", "c", "c", "b", "a", "d"), r -> {
            assertEquals(Arrays.asList("d"), r);
        });
    }
}
