package com.csj.ceshi.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String对象的常用方法封装
 *
 * @author tobiasy
 */
public class StringUtils {
    private static final Integer MAX_NUMBER = 9;
    private static final Integer MIN_NUMBER = 0;

    /**
     * 首字母大写
     *
     * @param str
     * @return
     */
    public static String capitalizeCase(String str) {
        char[] ch = str.toCharArray();
        char a = 'a';
        char z = 'z';
        if (ch[0] >= a && ch[0] <= z) {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    /**
     * 首字母大写
     *
     * @param str 可以是任意带下划线的字符串
     * @return
     */
    public static String capitalize(String str) {
        String str1 = camelcase(str);
        return str1.substring(0, 1).toUpperCase() + str1.substring(1);
    }

    /**
     * 首字母小写
     *
     * @param str
     * @return
     */
    public static String initialCase(String str) {
        String str1 = camelcase(str);
        return str1.substring(0, 1).toLowerCase() + str1.substring(1);
    }

    /**
     * 驼峰命名转下划线‘_’+小写保存
     *
     * @param className
     * @return
     */
    public static String underline(String className) {
        className = className.substring(0, 1).toLowerCase()
                + className.substring(1);
        for (int i = 0; i < className.length(); i++) {
            char c = className.charAt(i);
            if (Character.isUpperCase(c)) {
                className = className.substring(0, i) + "_"
                        + className.substring(i, i + 1).toLowerCase()
                        + className.substring(i + 1);
            }
        }
        return className.toLowerCase();
    }

    /**
     * 根据位数 生成随机数
     *
     * @param number 随机数位数
     * @return
     */
    public static String createRandom(int number) {
        if (number > MAX_NUMBER || number <= MIN_NUMBER) {
            throw new RuntimeException("非法参数！整形随机数位数范围(0,9]");
        }
        int l = 1;
        for (int i = 0; i < number; i++) {
            l = 10 * l;
        }
        int max = l - 1;
        int min = l / 10;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return String.valueOf(s);
    }

    /**
     * 转驼峰命名
     *
     * @param str
     * @return
     */
    public static String camelcase(String str) {
        String line = "_";
        if (str.endsWith(line)) {
            str = str.substring(0, str.lastIndexOf(line));
        }
        if (str.startsWith(line)) {
            str = str.substring(1);
        }
        while (str.contains(line)) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ('_' == c) {
                    String str1 = str.substring(0, i) + str.substring(i + 1, i + 2).toUpperCase() + str.substring(i + 2);
                    str = str1;
                }
            }
        }
        return str;
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线,效率比上面高
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 检查字符串是否包含有效字符
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(String cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                char c = cs.charAt(i);
                if (!Character.isWhitespace(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 把Object数组转化为符号mark分开的字符串
     * 相当于split的逆向操作
     *
     * @param mark    连接符
     * @param objects 基本数据类型（不能为对象数组）
     * @return
     */
    public static String join(String mark, Object... objects) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (Object o : objects) {
            if (flag) {
                sb.append(mark);
            }
            sb.append(o);
            flag = true;
        }
        return sb.toString();
    }

    /**
     * 在字符串origin后面追加一个数组，mark分隔
     *
     * @param origin 原始字符串
     * @param mark   分隔符
     * @param value  追加数组
     * @return
     */
    public static String append(String origin, String mark, Object... value) {
        if (!isBlank(origin)) {
            StringBuilder buff = new StringBuilder(origin);
            for (Object o : value) {
                buff.append(mark).append(o);
            }
            return buff.toString();
        } else {
            return append(mark, value);
        }
    }

    public static String append(String mark, Object... value) {
        StringBuilder origin = new StringBuilder();
        boolean flag = true;
        for (Object o : value) {
            if (flag) {
                origin.append(o);
                flag = false;
            } else {
                origin.append(mark).append(o);
            }
        }
        return origin.toString();
    }

    /**
     * 字符串split返回List用法
     * @param string 字符串
     * @param split 分隔符
     * @return
     */
    public static List<String> splitToList(String string, String split) {
        if (isBlank(string)) {
            return new ArrayList<>();
        }
        String[] strings = string.split(split);
        return ArrayUtils.arrayToList(strings);
    }

    /**
     * 字符串反转
     * @param s
     * @return
     */
    public static String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(splitToList("account,user", ","));
        System.out.println(reverse("hello"));
    }

}
