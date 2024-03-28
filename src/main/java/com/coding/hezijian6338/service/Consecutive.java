package com.coding.hezijian6338.service;

import java.util.List;
import java.util.function.Consumer;

/**
 * 接口管控方法方向.
 * @author hezijian6338
 */
public interface Consecutive {
    /**
     * 第一阶段任务.
     * @param list
     * @param consumer
     */
   void stageOne(List<String> list, Consumer<List<String>> consumer); 

   /**
    * 第二阶段任务.
    * @param list
    * @param consumer
    */
   void stageTwo(List<String> list, Consumer<List<String>> consumer); 
}
