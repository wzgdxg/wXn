/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    FindTheDifference
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
 *    Create at:   2021/11/23 10:24 上午
 *
 *    Revision:
 *
 *    2021/11/23 10:24 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * FindTheDifference
 * 389 找不同
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/23 10:24 上午
 */
public class FindTheDifference {

    public static char FindTheDifferenceFun(String s, String t) {
        /**
         * 还是异或
         */
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= Integer.valueOf(s.charAt(i));
        }
        int[] tarr = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            ans ^= Integer.valueOf(t.charAt(i));
        }
        return (char) ans;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(FindTheDifferenceFun(s, t));
    }

}
