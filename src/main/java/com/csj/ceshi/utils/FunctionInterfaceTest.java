package com.csj.ceshi.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @CalssName FunctionInterfaceTest
 * @Description TODO
 * @Author paean
 * @Date 2019/1/22 13:23
 **/


public class FunctionInterfaceTest {
    private void func(FunctionInterface functionInterface) {

        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
//        features.forEach(n -> System.out.println(n));
//        int x = 1;
//        functionInterface.test(x);
        features.parallelStream().forEach(n-> System.out.println(n));
    }

    @Test
    public void test() {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.stream().map(new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        });
//        features.forEach(n -> System.out.println(n));
//        int x = 1;
//        functionInterface.test(x);
        features.parallelStream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }




}
