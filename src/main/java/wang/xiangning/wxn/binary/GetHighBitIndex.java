/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    GetHighBitIndex
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
 *    Create at:   2021/11/26 2:04 下午
 *
 *    Revision:
 *
 *    2021/11/26 2:04 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

import wang.xiangning.wxn.tools.Timing;

import java.util.function.Consumer;

/**
 * GetHighBitIndex
 *
 * 100万次下
 * 方法1：耗时9
 * 方法2：耗时22
 * 方法3：耗时49
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/26 2:04 下午
 */
public class GetHighBitIndex {

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

    public static int GetHighBitIndexFun2(int num) {
        /**
         * 减少一倍循环
         */
        if (num < 0) {
            return 32;
        }
        if (num == 0) {
            return 0;
        }
        int ans = 0;
        int temp;

        while (num > 0) {
            temp = num >> 2;
            if (temp > 0) {
                num = temp;
                ans += 2;
            } else {
                temp = num >> 1;
                if (temp > 0) {
                    ans += 2;
                } else {
                    ans += 1;
                }
                break;
            }
        }

        return ans;
    }

    public static int GetHighBitIndexFun3(int num) {
        if (num < 0) {
            return 32;
        }
        /**
         * 单个往外删
         */
        int ans = 0;
        while (num > 0) {
            num >>= 1;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(GetHighBitIndexFun(5));
        System.out.println(GetHighBitIndexFun(15));
        System.out.println(GetHighBitIndexFun(-5));

        System.out.println(GetHighBitIndexFun2(5));
        System.out.println(GetHighBitIndexFun2(15));
        System.out.println(GetHighBitIndexFun2(-5));

        System.out.println(GetHighBitIndexFun3(5));
        System.out.println(GetHighBitIndexFun3(15));
        System.out.println(GetHighBitIndexFun3(-5));

        Timing.go("方法1：", 100_0000, s -> GetHighBitIndexFun(566554554));
        Timing.go("方法2：", 100_0000, s -> GetHighBitIndexFun2(566554554));
        Timing.go("方法3：", 100_0000, s -> GetHighBitIndexFun3(566554554));

    }

}
