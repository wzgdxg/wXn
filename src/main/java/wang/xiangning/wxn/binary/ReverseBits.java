/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    ReverseBits
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
 *    Create at:   2021/11/18 10:50 上午
 *
 *    Revision:
 *
 *    2021/11/18 10:50 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * ReverseBits
 * 190 颠倒二进制位
 * 知识点
 * 1.Integer.parseInt() 不认识补码，所以要传正整数原码，如要表是负数，可以是负数的整数部分前面加-
 * 2.Integer.parseUnsignedInt 认识补码，能解析出负数。
 * 3.移位
 * 4.用或 上1
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/18 10:50 上午
 */
public class ReverseBits {

    public static int ReverseBitsFun(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
//                ans += (Math.pow(2, 31 - i)); //最高位为31次方   溢出了
                ans |= 1 << (31 - i);
            }
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = Integer.parseUnsignedInt("11111111111111111111111111111101", 2);

        System.out.println(Integer.toBinaryString(ReverseBitsFun(a)));

    }

}
