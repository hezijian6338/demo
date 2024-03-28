package com.coding.hezijian6338.service;

/**
 * 字母表~~.
 * @author hezijian6338
 */
public class Alphabet {
    public boolean isInAlphabet(char alphabet) {
        final char a = 'a';
        final char b = 'b';
        if (alphabet >= a && alphabet <= b) {
            return true;
        } else {
            return false;
        }
    }
}
