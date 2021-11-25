/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    HammingDistance
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
 *    Create at:   2021/11/25 11:57 上午
 *
 *    Revision:
 *
 *    2021/11/25 11:57 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * HammingDistance
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/25 11:57 上午
 */
public class HammingDistance {

    public static int HammingDistanceFun(int x, int y) {
        int ans = 0;
        int xXorY = x ^ y;

        while (xXorY > 0) {
            xXorY = xXorY & (xXorY - 1);
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(HammingDistanceFun(x, y));
    }

}
