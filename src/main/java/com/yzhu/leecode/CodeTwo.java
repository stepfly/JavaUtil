package com.yzhu.leecode;

import java.util.stream.Stream;

//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
public class CodeTwo {
    private static int[] singleNumber(int[] nums) {
        int num1 = 0, num2 = 0;
        int xor = 0;
        for(int num : nums)
            xor ^= num;
        int bit_1 = 1;
        while((xor & 1) == 0) {
            xor >>= 1;
            bit_1 <<= 1;
        }
        for(int num : nums) {
            if((num & bit_1) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        int[] result=singleNumber(nums);
        System.out.println(result[0]);
        System.out.println(result[result.length-1]);
        Stream.of(result).forEach(System.out::println);
    }
}
