/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    ChangeTurnOn
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
 *    Create at:   2021/11/25 7:54 下午
 *
 *    Revision:
 *
 *    2021/11/25 7:54 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * ChangeTurnOn
 * 非LeetCode
 * 交替打印
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/25 7:54 下午
 */
public class ChangeTurnOn {

    public static void ChangeTurnOnFun() {
        /**
         * 利用 1 ^ 1 = 0
         *     0 ^ 1 = 1
         *     每次异或1 都翻转
         */
        int a = 1;
        for (int i = 0; i < 100; i++) {
            a ^= 1;
            if (a == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }

    public static void main(String[] args) {
        ChangeTurnOnFun();
    }

}
