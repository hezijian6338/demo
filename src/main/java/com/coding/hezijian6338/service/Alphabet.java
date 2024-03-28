package com.coding.hezijian6338.service;

/**
 * 字母表~~.
 * @author hezijian6338
 */
public class Alphabet {
    private final int aInt = 97;

    /**
     * 是否在字母表中的检测方法~~.
     * @param alphabet
     * @return
     */
    public boolean isInAlphabet(char alphabet) {
        final char a = 'a';
        final char z = 'z';
        if (alphabet >= a && alphabet <= z) {
            return true;
        }
        return false;
    }

    public int getAint() {
        return this.aInt;
    }
}
