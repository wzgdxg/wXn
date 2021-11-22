/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    FindThreeAlone
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
 *    Create at:   2021/11/16 11:01 上午
 *
 *    Revision:
 *
 *    2021/11/16 11:01 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FindThreeAlone
 * 给你1-1000个连续自然数，然后从中随机去掉三个，再打乱顺序，要求只遍历一次，求出被去掉的两个数。
 * 和两个去掉类似。wang.xiangning.wxn.binary.xor.FindTwoRunAway
 * 思路
 * 无法通过一个位1确定分成3份数据，
 * 那只能先分两堆，又因为无法确定哪堆中有两个数，分别将两堆再按去掉两个数做法做一遍。
 * 3个数的情况下，某一位为1  存在两种情况
 *   a.只有一个数在该位为1  可以分成2堆
 *   b.三个数在该位全为1    无法分成2堆
 *
 *  如果是a没问题，b的话还得再找。所以要循环
 *  判定条件，分成两堆后，肯定是a^b和c 且a^b != 0 && c != 0   如果a^b^c  ^ a^b = c 说明分成了两堆
 *  c!= 0是关键，有可能a^b == a^b^c  也符合a^b^c  ^ a^b = c
 *  简化后的判定条件就是 a^b != 0 && c != 0
 *
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/16 11:01 上午
 */
public class FindThreeAlone {

    public static void FindThreeAloneFun(List<Integer> list) {
        List<Integer> newList = new ArrayList(1997);
        for (int i = 1; i <= 1000; i++) {
            newList.add(i);
        }
        newList.addAll(list);

        int axorbxorc = 0;
        for (int num : newList) {
            axorbxorc ^= num;
        }
        List<Integer> nums1 = null;
        List<Integer> nums2 = null;
        int axorb1 = 0;
        int axorb2 = 0;
        int position = 0;
        boolean loop = true;
        while (loop) {
            nums1 = new ArrayList<>();
            nums2 = new ArrayList<>();

            while ((axorbxorc & (1 << position)) != (1 << position)) {  //注意位运算优先级很低
                position++;
            }
            int classification = 1 << position;
            for (int num : newList) {
                if ((num & classification) == classification) {
                    nums1.add(num);
                } else {
                    nums2.add(num);
                }
            }

            for (int num : nums1) {
                axorb1 ^= num;
            }

            for (int num : nums2) {
                axorb2 ^= num;
            }

            /**
             * 就能区分出两堆，否则的话 position++ 再来一遍
             */
            if (axorb1 != 0 && axorb2 != 0) {  //有一个等于0相当于 3个都在一堆
                loop = false;
            } else {
                position++; //换个位置
            }
        }

        FindTwoRunAwayFun(nums1);
        FindTwoRunAwayFun(nums2);

    }

    public static void FindTwoRunAwayFun(List<Integer> list) {
        int axorb = 0;
        for (int num : list) {
            axorb ^= num;
        }
        System.out.println(axorb);
        int position = 0;
        while ((axorb & (1 << position)) != (1 << position)) {  //注意位运算优先级很低
            position++;
        }
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();

        int classification = 1 << position;
        for (int num : list) {
            if ((num & classification) == classification) {
                nums1.add(num);
            } else {
                nums2.add(num);
            }
        }

        int ans1 = 0;
        for (int num : nums1) {
            ans1 ^= num;
        }
        int ans2 = 0;
        for (int num : nums2) {
            ans2 ^= num;
        }

        System.out.println("数1：" + ans1);
        System.out.println("数2：" + ans2);
    }


    public static void main(String[] args) {
        int ans1 = 761;
        int ans2 = 351;
        int ans3 = 121;
        List<Integer> list = new ArrayList<>(997);
        for (int i = 1; i <= 1000; i++) {
            if (i == ans1 || i == ans2 || i == ans3) {
                continue;
            }
            list.add(i);
        }
        System.out.println(list.size());

        Collections.shuffle(list);

        FindThreeAloneFun(list);
    }

}
