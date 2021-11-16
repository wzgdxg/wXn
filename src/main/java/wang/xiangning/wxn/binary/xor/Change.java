/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    Change
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
 *    Create at:   2021/11/15 2:42 下午
 *
 *    Revision:
 *
 *    2021/11/15 2:42 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

/**
 * Change
 * 例一：在不引入第三个变量的情况下，两个变量的值（整数）
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 2:42 下午
 */
public class Change {

    public static void ChangeFun(int a, int b) {
        a = a ^ b;
        b = a ^ b;  //b = a ^ b ^ b = a ^ 0 = a   归零律  恒等律
        a = a ^ b;  //a = a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b   交换律 结合律 归零律 恒等律

        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        ChangeFun(a, b);
    }

}
