package com.coding.hezijian6338.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * 解决办法.
 * @author hezijian6338
 */
public class Solution extends Alphabet {
    /**
     * 第一阶段要求返回.
     * @param list
     * @param consumer
     */
    public void outputStageOne(List<String> list, Consumer<List<String>> consumer) throws Exception {
        System.out.println(Optional.ofNullable(list));
    }

    /**
     * 第二阶段要求返回.
     * @param list
     * @param consumer
     */
    public void outputStageTwo(List<String> list, Consumer<List<String>> consumer) throws Exception {
        System.out.println(Optional.ofNullable(list));
    }
}
