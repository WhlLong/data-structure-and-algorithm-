package com.whl.offer.question4;

import java.util.Arrays;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 思路一: java中可以使用StringBuffer或者StringBuilder，相当于新建了一个String对象。
 * 思路二:
 * 每一个空格都会被替换成“%20”,长度为3，所以原字符串中每多一个空格，替换后的字符串的长度就会增加2。
 * 创建一个新的char数组，数组的长度=原本字符串的长度+2*空格的数量，
 * 然后对原本的字符串进行遍历，然后将新值加入到新的数组中。
 * 思路三:
 * 创建一个新的char数组，数组的长度=原本字符串的长度+2*空格的数量，
 * 然后对新数组进行倒叙遍历，将替换后的值从后往前添加到新数组中去
 */
public class ReplaceBlank {

    public static void main(String[] args) {

        String val2 = " We Are Happy ";
        System.out.println(ReplaceBlank.replace1(val2));
        System.out.println(ReplaceBlank.replace2(val2));
        System.out.println(ReplaceBlank.replace3(val2));
        System.out.println(ReplaceBlank.replace4(val2));
    }

    public static String replace1(String val) {
        if (val == null || "".equals(val)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : val.toCharArray()) {
            if (c == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(c);
            }
        }

        return stringBuffer.toString();
    }

    public static String replace2(String val) {
        if (val == null || "".equals(val)) {
            return "";
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(val.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    public static String replace3(String val) {
        if (val == null || "".equals(val)) {
            return "";
        }
        int blankNum = 0;
        int length = val.length();

        for (int i = 0; i < length; i++) {
            if (val.charAt(i) == ' ') {
                blankNum++;
            }
        }

        if (blankNum == 0) {
            //如果原字符串中没有空格，则不需要替换
            return val;
        }

        int newArrayLength = length + 2 * blankNum;
        char[] newArray = new char[newArrayLength];

        int index = newArrayLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (val.charAt(i) == ' ') {
                newArray[index--] = '0';
                newArray[index--] = '2';
                newArray[index--] = '%';
            } else {
                newArray[index--] = val.charAt(i);
            }
        }


        return new String(newArray);
    }

    public static String replace4(String val) {
        if (val == null || "".equals(val)) {
            return "";
        }
        int blankNum = 0;
        int length = val.length();

        for (int i = 0; i < length; i++) {
            if (val.charAt(i) == ' ') {
                blankNum++;
            }
        }

        if (blankNum == 0) {
            //如果原字符串中没有空格，则不需要替换
            return val;
        }

        int newArrayLength = length + 2 * blankNum;
        char[] newArray = Arrays.copyOf(val.toCharArray(), newArrayLength);

        int index = newArrayLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (newArray[i] == ' ') {
                newArray[index--] = '0';
                newArray[index--] = '2';
                newArray[index--] = '%';
            } else {
                newArray[index--] = val.charAt(i);
            }
        }


        return new String(newArray);
    }

}
