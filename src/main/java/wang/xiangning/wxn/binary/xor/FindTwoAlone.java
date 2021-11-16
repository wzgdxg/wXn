/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    FindTwoAlone
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
 *    Create at:   2021/11/15 3:59 下午
 *
 *    Revision:
 *
 *    2021/11/15 3:59 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

import wang.xiangning.wxn.tools.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FindTwoAlone
 * 找出数组中落单的那两个数
 * 思路一：
 * 排序后，异或到偶数位非0的前一个奇数。
 * 思路二：
 * 和找出唯一一个落单一样，前提是将数分成两堆，两个落单的数分别在两堆中，然后全异或就行了。
 * 分解，先全异或，得出 a^b(a和b就是两个落单的数)，然后看哪一位是1，说明a和b中至少有一个数该位上是1，然后根据该位上是否为1，
 * 将所有数分成两堆。省下的就是分别全量异或了。
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 3:59 下午
 */
public class FindTwoAlone {

    public static void FindTwoAloneFun(List<Integer> list) {
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

        System.out.println(ans1);
        System.out.println(ans2);
    }

    public static void main(String[] args) {
        int ans1 = 763;
        int ans2 = 356;
        int test = -3;
        System.out.println(String.format("%16s", Integer.toBinaryString(ans1)));
        System.out.println(String.format("%16s", Integer.toBinaryString(ans2)));
        System.out.println(Integer.toBinaryString(test));

        List<Integer> list = new ArrayList<>(2000);
        for (int i = 1; i <= 998; i++) {
            if (i == ans1 || i == ans2) {
                continue;
            }
            list.add(i);
            list.add(i);
        }

        list.add(RandomUtil.one(1000), ans1);
        list.add(RandomUtil.one(1000), ans2);

        Collections.shuffle(list);

        FindTwoAloneFun(list);
    }

}
