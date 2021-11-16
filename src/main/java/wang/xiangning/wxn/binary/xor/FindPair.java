/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    FindPair
 *
 *    Description: 
 *
 *    Copyright:   Copyright (c) 2001-2019
 *
 *    Company:     hhdd.com
 *
 *    @author: 王志刚
 *
 *    @version: 1.0.0
 *
 *    Create at:   2021/11/15 3:04 下午
 *
 *    Revision:
 *
 *    2021/11/15 3:04 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

import wang.xiangning.wxn.tools.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * FindPair
 * 找出唯一一个成对的数
 *
 * 题干：1-1000这1000个数放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现 一次。每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空 间，能否设计一个算法实现？
 * 解法：异或运算的归零率
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 3:04 下午
 */
public class FindPair {

    public static void FindPairFun(List<Integer> list) {
        int contrast = 0;  //利用异或恒等性，初始可以设置为0
        for (int i = 1; i <= 1000; i++) {
            contrast ^= i;  //异或是不进位的加法，所以没有溢出的可能
        }
        int source = 0;
        for (int num : list) {
            source ^= num;
        }

        /**
         * source:   1^2^3^3^4^5
         * contrast: 1^2^3  ^4^5
         * =         1^1^2^2^3^3^3^4^4^5^5
         * =         (1^1)^(2^2)^(3^3)^3^(4^4)^(5^5)
         * =         0    ^0    ^0    ^3^0    ^0
         * =         3
         */
        System.out.println((source ^ contrast));
    }

    public static void main(String[] args) {
        int ans = 763;
        List<Integer> list = new ArrayList<>(1001);
        for (int i = 1; i <= 1000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println(list.size());

        list.add(RandomUtil.one(1000), ans);
        System.out.println(list.size());

        FindPairFun(list);


    }

}
