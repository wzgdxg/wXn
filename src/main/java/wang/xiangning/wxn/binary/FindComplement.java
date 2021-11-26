/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    FindComplement
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
 *    Create at:   2021/11/25 5:27 下午
 *
 *    Revision:
 *
 *    2021/11/25 5:27 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * FindComplement
 * 476 数字的补数
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/25 5:27 下午
 */
public class FindComplement {

    public static int FindComplementFun(int num) {
        /**
         * 你以为只是翻转吗？
         * too young too naive
         * 101 翻转后变成11111111111111111111111111111010
         * 题是 1到 231-1次
         * 所以都是正整数，翻转后都是1开头。
         * 所以只要获取原数的最高1位，得到111111111 000 异或
         *
         * 暴力解法就不说了
         */
        int index = GetHighBitIndexFun(num);
        return (num ^ -1) ^ (-1 << index);
    }

    public static int FindComplementFun2(int num) {
        /**
         * 你以为只是翻转吗？  最简单的翻转就是和-1 异或 num ^ -1;
         * too young too naive
         * 101 翻转后变成11111111111111111111111111111010
         * 问题就在 最高位前的0 不能与-1异或，否则前面全是-1了。 略感就是补数和补码的区别、
         * 所以解决问题的根本就是将全1改为 原数最高位相同的全1.  其实和方法1原理相同，表达方式不一样
         *
         * 题是 1到 231-1次
         * 测试例  13 的二进制是 1101
         * 最高位1，在结果中是0，所以只要计算后面的就行
         * 拿到最高位后，可以获得其后位都是0的数x = 1000，
         * 的x-1 = 0111
         *
         */
        int index = GetHighBitIndexFun(num);
        return num ^ ((1 << index) - 1);
    }

    public static int GetHighBitIndexFun(int num) {
        if (num < 0) {
            return 32;
        }
        if (num == 0) {
            return 0;
        }
        int numPre = num;
        int numAft = num;
        int ans = 0;
        int tans = 16;

        for (int i = 0; i < 10; i++) {  //这里的其实
            numAft = num >> tans;
            if (numAft > 0) {
                ans += tans;
                numPre = numAft;
                num = numAft;
            } else {
                num = numPre;
            }
            tans = tans / 2;
            if (num == 1) {
                return ans + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5 ^ -1));

        System.out.println(FindComplementFun2(5));
        System.out.println(FindComplementFun2(1));
    }

}
