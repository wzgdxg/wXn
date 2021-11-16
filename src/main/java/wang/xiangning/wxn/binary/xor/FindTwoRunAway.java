/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    FindTwoRunAway
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
 *    Create at:   2021/11/15 5:04 下午
 *
 *    Revision:
 *
 *    2021/11/15 5:04 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FindTwoRunAway
 * 给你1-1000个连续自然数，然后从中随机去掉两个，再打乱顺序，要求只遍历一次，求出被去掉的两个数。
 * 思路：新建一个1-1000的数组，在于原数组合并，全量异或得出a^b值，后面就和wang.xiangning.wxn.binary.xor.FindTwoAlone解法一样了
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 5:04 下午
 */
public class FindTwoRunAway {

    public static void FindTwoRunAwayFun(List<Integer> list) {
        List<Integer> newList = new ArrayList(1998);
        for (int i = 1; i <= 1000; i++) {
            newList.add(i);
        }
        newList.addAll(list);
        int axorb = 0;
        for (int num : newList) {
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
        for (int num : newList) {
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

        System.out.println(ans1);
        System.out.println(ans2);
    }

    public static void main(String[] args) {
        int ans1 = 763;
        int ans2 = 356;
        List<Integer> list = new ArrayList<>(998);
        for (int i = 1; i <= 1000; i++) {
            if (i == ans1 || i == ans2) {
                continue;
            }
            list.add(i);
        }
        System.out.println(list.size());

        Collections.shuffle(list);

        FindTwoRunAwayFun(list);
    }

}
