/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    NoIfAbs
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
 *    Create at:   2021/11/16 11:13 上午
 *
 *    Revision:
 *
 *    2021/11/16 11:13 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

/**
 * NoIfAbs
 * 不用判断语句，求整数的绝对值
 * 思路：带符号右移31位，正数变为0，负数变为-1。
 * 任何数和-1做“异或”运算相当于取反
 * 负数要变正数是取反+1  补码就是正数
 * 有了以上三点。
 * 正数^(正数>>31) = 正数
 * 负数^(负数>>31) = 取反  还差+1
 * 正数>>31等于0  负数>>31 等于-1
 * 差的+1可以直接写成-(num>>31)，正数-0  负数-（-1）刚好满足
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/16 11:13 上午
 */
public class NoIfAbs {

    public static void NoIfAbsFun(int num) {
//        System.out.println(num ^ (num >> 31));
        System.out.println(num + "的绝对值是:" + ((num^(num>>31))-(num>>31)));
    }

    public static void main(String[] args) {
        int a = 123;
        int b = -123;
        int c = 0;

        System.out.println(a >> 31);
        System.out.println(b >> 31);
        System.out.println(b ^ -1);

        NoIfAbsFun(a);
        NoIfAbsFun(b);
        NoIfAbsFun(c);
    }

}
