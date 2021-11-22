/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    IsPowerOfTwo
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
 *    Create at:   2021/11/22 3:09 下午
 *
 *    Revision:
 *
 *    2021/11/22 3:09 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * IsPowerOfTwo
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/22 3:09 下午
 */
public class IsPowerOfTwo {

//    public static boolean IsPowerOfTwoFun(int n) {
//        if (n <= 0) {
//            return false;
//        }
//        /**
//         * 1.大于0的正数
//         * 2.有且只有一位为1
//         */
//        int num = 0;
//        for (int i = 0; i < 32; i++) {
//            if ((n & 1) == 1) {
//                num++;
//                if (num > 1) {
//                    return false;
//                }
//            }
//            n = n >> 1;
//        }
//        if (num == 0) {
//            return false;
//        }
//        return true;
//    }

    public static boolean IsPowerOfTwoFun(int n) {
        /**
         * 满足条件：
         * 1.大于0的正数
         * 2.有且只有一位为1 等于  最高位为1 其余都是0   那么（n-1）就是最高位为0，其余位都是1，与上就是0
         */
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int a = 23;
//        System.out.println(IsPowerOfTwoFun(a));
//        a = 20;
//        System.out.println(IsPowerOfTwoFun(a));
//        a = 16;
//        System.out.println(IsPowerOfTwoFun(a));
        a = -2147483648;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(IsPowerOfTwoFun(a));
    }

}
