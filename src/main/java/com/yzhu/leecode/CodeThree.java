package com.yzhu.leecode;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CodeThree {
    /**
     * 求近似值
     */
    public static void jsData() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double d = scanner.nextDouble();
            System.out.println(Math.round(d));
        }
    }

    /**
     * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
     */
    public static void zsCount() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int count = 0;
        while (m > 0) {
            if ((m ^ 1) == 1) {
                count++;
            }
            m = m >> 1;
        }
        System.out.println(count);
    }

    public static int qsCount(int m) {
        if (m <= 1) {
            return 0;
        } else if (m == 2 || m == 3) {
            return 1;
        } else {
            return m / 3 + qsCount(m / 3 + m % 3);
        }
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            System.out.println(qsCount(n));
        }
    }

    /**
     * 求最长增加子序列
     */
    public static int getMaxSteps(int[] arr, int n) {
        int[] dp = new int[n];
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }

    public static void input1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(getMaxSteps(a, n));
        }
    }

    /**
     * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
     */
    public static void averager() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        int flag = 0;
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num < 0) {
                count++;
            } else {
                sum += num;
                flag++;
            }
        }
        System.out.println(count);
        if (flag == 0) {
            System.out.println("0.0");
        } else {
            System.out.println(new DecimalFormat("0.0").format(sum / (count)));
        }
    }

    /**
     * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，
     * 如果统计的个数相同，则按照ASCII码由小到大排序输出。
     */
    public static String countData(String input) {
        Map<Character, Integer> hashmap = new HashMap<>();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char s = input.charAt(i);
            if(hashmap.containsKey(s)){
                hashmap.put(s,hashmap.get(s)+1);
            }else{
                hashmap.put(s,1);
            }
        }
        Map<Integer,Character> treemap=new TreeMap<>();
        for(Character key:hashmap.keySet()){
            treemap.put(hashmap.get(key)*128+128-key,key);
        }
        for(Integer key:treemap.keySet()){
            stringBuilder.append(treemap.get(key));
        }
        return stringBuilder.reverse().toString();
    }

    public static void input2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(countData(scanner.nextLine()));
        }
    }

    /**
     * 计算字符串最后一个单词的长度，单词以空格隔开。
     */
    public static int strLen(String input){
        String[] s=input.split(" ");
        return s[s.length-1].length();
    }

    public static void input3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(strLen(scanner.nextLine()));
        }
    }

    /**
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写。
     */
    public static int countData(){
        int count=0;
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toUpperCase();

        char target  = in.nextLine().toUpperCase().toCharArray()[0];

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == target){
                count++;
            }
        }
        return count;
    }

    /**
     * 输入多行（第一行总数，下面是每一行的数字）
     */
    public static void input4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(getMaxSteps(a, n));
        }
    }

    public static void main(String[] args) {
        System.out.println(countData());
    }
}
