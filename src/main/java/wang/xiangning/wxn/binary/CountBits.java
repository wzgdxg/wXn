/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    CountBits
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
 *    Create at:   2021/11/22 4:35 下午
 *
 *    Revision:
 *
 *    2021/11/22 4:35 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * CountBits
 * 338
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/22 4:35 下午
 */
public class CountBits {

    public static int[] countBitsFun(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countBit(i);
        }
        return ans;
    }

    public static int countBit(int n) {
        int ans = 0;
        while (n > 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] ans = countBitsFun(n);
        for (int an : ans) {
            System.out.println(an);
        }
    }

}
