/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    MissingNumber
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
 *    Create at:   2021/11/22 4:03 下午
 *
 *    Revision:
 *
 *    2021/11/22 4:03 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * MissingNumber
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/22 4:03 下午
 */
public class MissingNumber {

    public static int MissingNumberFun(int[] nums) {
        /**
         * 异或 a^a = 0
         * 那就多个相同的数异或
         *
         * 但又多了个0，排除0后异或
         */
        int allXor = 0;
        for (int i = 1; i <= nums.length; i++) {
            allXor ^= i;
        }

        int numsXor = 0;
        for (int num : nums) {
            if (num != 0) {
                numsXor ^= num;
            }
        }
        return allXor ^ numsXor;
    }


    public static void main(String[] args) {
        int[] a = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(MissingNumberFun(a));
    }

}
