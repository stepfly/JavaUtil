package com.yzhu.jdk8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String value=null;
        String value1="hello world";
        //存空值
        Optional<String> optional=Optional.ofNullable(value);
        //存其他值
        Optional<String> optional1=Optional.of(value1);
        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        System.out.println(optional.orElse(""));
        //Optional.get - 获取值，值需要存在
        System.out.println(optional1.get());
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.println(e);
        });
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
        });
    }
}
