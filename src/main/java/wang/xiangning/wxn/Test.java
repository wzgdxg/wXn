/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn
 *
 *    Filename:    Test
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
 *    Create at:   2021/11/18 9:53 上午
 *
 *    Revision:
 *
 *    2021/11/18 9:53 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn;

/**
 * Test
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/18 9:53 上午
 */
public class Test {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(a));

        System.out.println((1 ^ -1) + 1);
        System.out.println((2 ^ -1) + 1);

        System.out.println((-1 ^ -1) + 1);
        System.out.println((-2 ^ -1) + 1);
    }
}
