/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    OddOrEven
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
 *    Create at:   2021/11/15 2:48 下午
 *
 *    Revision:
 *
 *    2021/11/15 2:48 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

/**
 * OddOrEven
 * 判断奇数偶数更简单更高效的做法
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 2:48 下午
 */
public class OddOrEven {

    public static void OddOrEvenFun(int a) {
        if ((a & 1) == 1) {
            System.out.println("奇数");
        } else {
            System.out.println("偶数");
        }

    }

    public static void main(String[] args) {
        int a = 0;
        OddOrEvenFun(a);
        a = 1;
        OddOrEvenFun(a);
        a = 2;
        OddOrEvenFun(a);
        a = 5;
        OddOrEvenFun(a);
    }

}
