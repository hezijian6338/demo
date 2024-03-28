package com.coding.hezijian6338.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import com.coding.hezijian6338.service.Consecutive;
import com.coding.hezijian6338.service.Solution;

/**
 * 替换 3个或者以上的相同字符串.
 * 
 * @author hezijian6338
 */
public final class ConsecutiveImpl extends Solution implements Consecutive {
    public void stageOne(List<String> list, Consumer<List<String>> consumer) throws Exception {
        if (list.size() == 0) {
            consumer.accept(list);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String curr = list.get(i);
            if (!this.isInAlphabet(curr.charAt(0))) {
                consumer.accept(null);
                throw new Exception("不在字母表中! ");
            }
            if (i + 2 < list.size()) {
                String next = list.get(i + 1);
                String nextTwo = list.get(i + 2);
                if (curr.equals(next) && curr.equals(nextTwo)) {
                    i = i + 2;
                } else {
                    res.add(list.get(i));
                }
            } else {
                res.add(list.get(i));
            }
        }

        consumer.accept(res);
    }

    public void stageTwo(List<String> list, Consumer<List<String>> consumer) throws Exception {
        if (list.size() == 0) {
            consumer.accept(list);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String curr = list.get(i);
            if (!this.isInAlphabet(curr.charAt(0))) {
                res.clear();
                consumer.accept(res);
                throw new Exception("不在字母表中! ");
            }
            if (i + 2 < list.size()) {
                String next = list.get(i + 1);
                String nextTwo = list.get(i + 2);
                if (curr.equals(next) && curr.equals(nextTwo)) {
                    int aInt = 97;
                    char c = (char) (curr.charAt(0) - 1);
                    int cInt = (int) c;
                    if (cInt >= aInt) {
                        res.add(String.valueOf(c));
                    }
                    i = i + 2;
                } else {
                    res.add(list.get(i));
                }
            } else {
                res.add(list.get(i));
            }
        }

        consumer.accept(res);
    }

    @Override
    public void outputStageOne(List<String> list, Consumer<List<String>> consumer) throws Exception {
        this.stageOne(list, res -> {
            // 和源数据一致.
            if (res.size() == list.size()) {
                consumer.accept(res);
            } else {
                List<String> nList = new ArrayList<>();
                nList.addAll(res);
                System.out.println("-> " + nList.toString().replace("[", "").replace("]", "").replace(",", "").trim());
                try {
                    outputStageOne(nList, consumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void outputStageTwo(List<String> list, Consumer<List<String>> consumer) throws Exception {
        this.stageTwo(list, res -> {
            // 和源数据一致.
            if (res.size() == list.size()) {
                consumer.accept(res);
            } else {
                List<String> nList = new ArrayList<>();
                nList.addAll(res);
                System.out.println("-> " + nList.toString().replace("[", "").replace("]", "").replace(",", "").trim());
                try {
                    outputStageTwo(nList, consumer);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
