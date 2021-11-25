/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    ToHex
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
 *    Create at:   2021/11/23 3:10 下午
 *
 *    Revision:
 *
 *    2021/11/23 3:10 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * ToHex
 * 405 数字转换为十六进制数
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/23 3:10 下午
 */
public class ToHex {

    public static String ToHexFun(int num) {
        /**
         * 四个一组
         * 一组值的int值 转 字符
         */
        int mask = 0x0000000f;
        int[] ans = new int[8];
        for (int i = 0; i < 8; i++) {
            ans[7-i] = (num >> (4 * i)) & mask;
        }
        StringBuilder hex = new StringBuilder();
        boolean start = false;
        for (int an : ans) {
            if (!start && an > 0 || start) {
                start = true;
                if (an > 9) {
                    hex.append((char) (an - 10 + 97));
                } else {
                    hex.append((char) (an + 48));
                }

            }
        }
        if (hex.length() == 0) {
            return "0";
        }
        return hex.toString();
    }

    public static void main(String[] args) {

        System.out.println(ToHexFun(26));
        System.out.println(ToHexFun(-1));
        System.out.println(ToHexFun(0));
    }

}
