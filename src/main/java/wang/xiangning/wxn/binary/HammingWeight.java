/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    Binary
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
 *    Create at:   2021/11/22 2:59 下午
 *
 *    Revision:
 *
 *    2021/11/22 2:59 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * Binary
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/22 2:59 下午
 */
public class HammingWeight {

    public static int HammingWeightFun(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                num++;
            }
            n = n >> 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int a = Integer.parseUnsignedInt("00000000000000000000000000001011", 2);
        System.out.println(HammingWeightFun(a));
    }

}
