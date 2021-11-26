/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    FindHighBit
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
 *    Create at:   2021/11/25 7:20 下午
 *
 *    Revision:
 *
 *    2021/11/25 7:20 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * FindHighBit
 * 非 LeetCode
 * 保留最高位
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/25 7:20 下午
 */
public class GetHighBit {

    public static int GetHighBitFun(int num) {
        /**
         * 最高位的1往后复制成全是1。 比如0101 变成 0111
         * 在和整体无符号右移一位的自己异或： 0111 ^ 0011 = 0100
         * 相同于Integer.highestOneBit()
         * 知识点在往右复制如何实现
         * 复制一位 num = 0101 0000
         * num | num >> 1   0101 0000 | 0010 1000 = 0111 1000  保证最高2位都为1  1位
         * num | num >> 2   0111 1000 | 0001 1110 = 0111 1110  保证最高4位都为1  1+ 2 = 3位
         * num | num >> 4   0111 1110 | 0000 0111 = 0111 1111  保证最高8位都为1  1+ 2 + 4 = 7位
         * num | num >> 8   0111 1111 | 0000 0000 = 0111 1111  保证最高16位都为1  1+ 2 + 4 + 8= 15位
         * num | num >> 16   0111 1111 | 0000 0000 = 0111 1111 保证最高16位都为1  1+ 2 + 4 + 8 + 16= 31位  31位覆盖了负数所有位数
         */
        num |= num >> 1;
        num |= num >> 2;
        num |= num >> 4;
        num |= num >> 8;
        num |= num >> 6;
        return num ^ (num >>> 1);
    }

    public static void main(String[] args) {

//        System.out.println(Integer.toBinaryString(GetHighBitFun(5)));
//        System.out.println(Integer.toBinaryString(Integer.highestOneBit(5)));
//        System.out.println(Integer.toBinaryString(GetHighBitFun(15)));
//        System.out.println(Integer.toBinaryString(Integer.highestOneBit(15)));

        System.out.println(Integer.toBinaryString(GetHighBitFun(-5)));
        System.out.println(Integer.toBinaryString(Integer.highestOneBit(-5)));
        System.out.println(Integer.toBinaryString(GetHighBitFun(-15)));
        System.out.println(Integer.toBinaryString(Integer.highestOneBit(-15)));
    }

}
