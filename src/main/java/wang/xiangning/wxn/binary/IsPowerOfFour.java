/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    IsPowerOfFour
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
 *    Create at:   2021/11/22 7:44 下午
 *
 *    Revision:
 *
 *    2021/11/22 7:44 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * IsPowerOfFour
 * 342 4的幂
 *
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/22 7:44 下午
 */
public class IsPowerOfFour {

    public static boolean IsPowerOfFourFun(int n) {
        /**
         * 4的幂 就是 22次方的幂 需要满足2的次幂：
         * 大于0
         * 有且只有最高位为1
         *
         * 同时4的幂有个特点奇数位为1  转化为程序为i是偶数
         *
         * 判定偶数位为1  可以用for循环，也可以用自己构建的mask
         *
         * 和0101 0101 0101 0101 0101 0101 0101 0101 与结果为0
         * 16进制简化表示法 0xAAAAAAAA
         */
        return (n > 0) && ((n & (n - 1)) == 0) && (n &  0xAAAAAAAA) == 0;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(IsPowerOfFourFun(n));
        n = 3;
        System.out.println(IsPowerOfFourFun(n));
        n = 12;
        System.out.println(IsPowerOfFourFun(n));
        n = 8;
        System.out.println(IsPowerOfFourFun(n));
    }

}
