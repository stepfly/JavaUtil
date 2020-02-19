package com.yzhu.leecode;

import java.util.stream.Stream;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
public class CodeOne {
    private static int[] printNumbers(int n) {
        if(n <= 0) return new int[0];
        int result = 1;
        int x = 10;
        while(n != 0){
            if((n & 1) == 1){
                result *= x;
            }
            n >>= 1;
            x *= x;
        }
        int len = result - 1;
        int[]array = new int[len];
        for(int i = 0;i < len;i++){
            array[i] = i + 1;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] result=printNumbers(3);
        System.out.println(result[0]);
        System.out.println(result[result.length-1]);
        Stream.of(result).forEach(System.out::println);
    }
}
