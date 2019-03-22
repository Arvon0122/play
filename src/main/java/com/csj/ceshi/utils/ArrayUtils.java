package com.csj.ceshi.utils;

import com.csj.ceshi.enums.SortEnum;
import org.apache.commons.collections4.map.HashedMap;

import java.util.*;


/**
 * @author tobiasy
 */
public class ArrayUtils {
    /**
     * 根据参数快捷创建数组
     *
     * @param t   不定参数
     * @param <T> 泛型
     * @return
     */
    public static <T> T[] toArray(T... t) {
        return t;
    }

    public static <T> List<T> toList(T... t) {
        return Arrays.asList(t);
    }

    /**
     * 数组转化为集合
     *
     * @param args 数组
     * @return 集合
     */
    public static <T extends Object> List<T> arrayToList(T... args) {
        List<T> list = new ArrayList<>();
        for (T o : args) {
            list.add(o);
        }
        return list;
    }

    /**
     * List 集合转化为 Object[] 数组
     *
     * @param list 集合
     * @return Object类型数组
     */
    public static String[] listToStringArray(List<? extends Object> list) {
        int i = 0;
        String[] args = new String[list.size()];
        for (Object o : list) {
            args[i++] = (String) o;
        }
        return args;
    }

    /**
     * 集合转化为数组，需要先初始化集合中的类型
     *
     * @param list
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends Object> T[] listToArray(List<T> list, T[] t) {
        if (list.size() != t.length) {
            try {
                throw new Exception("初始化数组：" + t.getClass() + "长度不匹配！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i = 0;
        for (T o : list) {
            t[i++] = o;
        }
        return t;
    }

    public static <T> Object[] listToArray(List<T> list) {
        Object[] objects = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            objects[i] = t;
        }
        return objects;
    }

    /**
     * char类型数组转化为字符串数组
     *
     * @param chars
     * @return
     */
    public static String[] charToString(char[] chars) {
        String[] arr = new String[chars.length];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = String.valueOf(chars[i]);
        }
        return arr;
    }

    /**
     * 指定的value是否在集合中
     *
     * @param value
     * @param ojs
     * @param <T>
     * @return
     */
    public static <T> boolean inList(T value, List<T> ojs) {
        for (T o : ojs) {
            if (o.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean inArray(T value, T... ojs) {
        for (T o : ojs) {
            if (o.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> listAddArray(List<T> object, T[] arr) {
        List<T> list = new ArrayList<>();
        list.addAll(object);
        for (T t : arr) {
            list.add(t);
        }
        return list;
    }

    public static <T> Object[] arrayAddList(T[] arr, List<T> object) {
        for (T t : arr) {
            object.add(t);
        }
        return object.toArray();
    }

    /**
     * 数组中添加List集合
     *
     * @param arr    数组
     * @param list   List集合
     * @param result 预先定义的空结果数组
     * @param <T>
     * @return
     */
    public static <T> T[] arrayAddList(T[] arr, List<T> list, T[] result) {
        if (result.length != (arr.length + list.size())) {
            throw new RuntimeException(new Throwable(result.getClass() + "长度跟被复制长度不一致！"));
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < list.size(); i++) {
            result[i + arr.length] = list.get(i);
        }
        return result;
    }

    /**
     * 数组默认排序 -- 升序
     *
     * @param arr
     */
    public static void sort(Integer[] arr) {
        sort(arr, SortEnum.ASC);
    }

    /**
     * 排列，需要指定升序还是降序
     *
     * @param arr
     * @param sort
     */
    public static void sort(Integer[] arr, SortEnum sort) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (SortEnum.DESC.name().equals(sort.name())) {
                    if (arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                } else {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 字符串集合排序
     *
     * @param list
     * @return
     */
    public static List<String> sort(List<String> list) {
        Collections.sort(list);
        return list;
    }

    /**
     * 字符串数组排序
     *
     * @param list
     * @return
     */
    public static List<String> sort(String[] list) {
        Arrays.sort(list);
        return arrayToList(list);
    }

    public static <T> List<T> append(T[] arr, T... ts) {
        List<T> list = new ArrayList<>(Arrays.asList(arr));
        for (T t : ts) {
            list.add(t);
        }
        return list;
    }

    public static <T> T[] append(T[] arr, T t, T[] result) {
        if (arr.length + 1 != result.length) {
            throw new RuntimeException(new Throwable(result.getClass() + "结果集数组长度和子数组长度之和不一致！"));
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            result[index++] = arr[i];
        }
        result[index++] = t;
        return result;
    }

    public static <T> T[] append(T[] arr, T[] ts, T[] result) {
        if (arr.length + ts.length != result.length) {
            throw new RuntimeException(new Throwable(result.getClass() + "结果集数组长度和子数组长度之和不一致！"));
        }
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            result[index++] = arr[i];
        }
        for (int i = 0; i < ts.length; i++) {
            result[index++] = ts[i];
        }
        return result;
    }

    /**
     * 过滤重复的键，把所有匹配的映射值放置到该键对应的值中
     *
     * @param keys
     * @param values
     * @return
     */
    public static Map<Object, List<Object>> truncateKey(Object[] keys, Object[] values) {
        Map<Object, List<Object>> map = new HashedMap<>();
        for (int i = 0; i < keys.length; i++) {
            Object key = keys[i];
            List<Object> ss = map.get(key);
            if (ss == null) {
                ss = new ArrayList<>();
            }
            ss.add(values[i]);
            map.put(key, ss);
        }
        return map;
    }

    public static String[] toStringArray(Object[] objects) {
        String[] result = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            Object o = objects[i];
            String value = String.valueOf(o);
            result[i] = value;
        }
        return result;
    }

}
