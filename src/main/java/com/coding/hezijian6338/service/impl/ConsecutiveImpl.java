package com.coding.hezijian6338.service.impl;

import com.coding.hezijian6338.service.Consecutive;
import com.coding.hezijian6338.service.Solution;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 替换 3个或者以上的相同字符串.
 * @author hezijian6338
 */
public final class ConsecutiveImpl extends Solution implements Consecutive {
    /**
     * 第一阶段的任务 (分段).
     */
    public void stageOne(List<String> list, Consumer<List<String>> consumer) throws IllegalArgumentException {
        if (list.size() == 0) {
            consumer.accept(list);
        }

        List<String> res = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (j != 0 && j >= i) {
                continue;
            }
            String curr = list.get(i);
            if (!this.isInAlphabet(curr.charAt(0))) {
                res.clear();
                consumer.accept(res);
                throw new IllegalArgumentException("不在字母表中! ");
            }
            if (i + 2 < list.size()) {
                String next = list.get(i + 1);
                String nextTwo = list.get(i + 2);
                if (curr.equals(next) && curr.equals(nextTwo)) {
                    j = i + 2;
                } else {
                    res.add(list.get(i));
                }
            } else {
                res.add(list.get(i));
            }
        }

        consumer.accept(res);
    }

    /**
     * 第二阶段任务 (分段).
     */
    public void stageTwo(List<String> list, Consumer<List<String>> consumer) throws IllegalArgumentException {
        if (list.size() == 0) {
            consumer.accept(list);
        }

        List<String> res = new ArrayList<>();

        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            if (j != 0 && j >= i) {
                continue;
            }
            String curr = list.get(i);
            if (!this.isInAlphabet(curr.charAt(0))) {
                res.clear();
                consumer.accept(res);
                throw new IllegalArgumentException("不在字母表中! ");
            }
            if (i + 2 < list.size()) {
                String next = list.get(i + 1);
                String nextTwo = list.get(i + 2);
                char c = (char) (curr.charAt(0) - 1);
                int cInt = (int) c;
                if (curr.equals(next) && curr.equals(nextTwo) && cInt >= getAint()) {
                    res.add(String.valueOf(c));
                    System.out.println(curr + curr + curr + " is replaced by " + c);
                    j = i + 2;
                } else if (curr.equals(next) && curr.equals(nextTwo)) {
                    j = i + 2;
                } else {
                    res.add(list.get(i));
                }
            } else {
                res.add(list.get(i));
            }
        }

        consumer.accept(res);
    }

    /**
     * 重写输出方法, 实现更符合.
     */
    @Override
    public void outputStageOne(List<String> list, Consumer<List<String>> consumer) throws IllegalArgumentException {
        this.stageOne(list, res -> {
            // 和源数据一致.
            if (res.size() == list.size()) {
                consumer.accept(res);
            } else {
                List<String> nList = new ArrayList<>();
                nList.addAll(res);
                System.out.println("-> " + nList.toString().replace("[", "").replace("]", "").replace(",", "").trim());
                outputStageOne(nList, consumer);
            }
        });
    }

    /**
     * 重写输出方法, 更符合.
     */
    @Override
    public void outputStageTwo(List<String> list, Consumer<List<String>> consumer) throws IllegalArgumentException {
        this.stageTwo(list, res -> {
            // 和源数据一致.
            if (res.size() == list.size()) {
                consumer.accept(res);
            } else {
                List<String> nList = new ArrayList<>();
                nList.addAll(res);
                System.out.println("-> " + nList.toString().replace("[", "").replace("]", "").replace(",", "").trim());
                outputStageTwo(nList, consumer);
            }
        });
    }

}
