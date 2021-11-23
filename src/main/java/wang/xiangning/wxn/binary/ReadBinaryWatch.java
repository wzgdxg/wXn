/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    ReadBinaryWatch
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
 *    Create at:   2021/11/23 11:46 上午
 *
 *    Revision:
 *
 *    2021/11/23 11:46 上午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ReadBinaryWatch
 * 401
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/23 11:46 上午
 */
public class ReadBinaryWatch {

    public static List<String> ReadBinaryWatchFun(int turnedOn) {
        /**
         * 先算出0-59（包含0-11）
         * 所有数字的位1的个数，再组合
         */
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<String> ans = new ArrayList<>();

        Map<Integer, Integer> map11 = getLimitList(11, turnedOn, countMap);
        Map<Integer, Integer> map59 = getLimitList(59, turnedOn, countMap);

        map11.forEach((key1, val1) ->{
            map59.forEach((key2, val2) ->{
                if (val1 + val2 == turnedOn) {
                    ans.add(key1 + ":" + String.format("%02d",key2));
                }
            });
        });
        return ans;
    }

    public static Map<Integer, Integer> getLimitList(int max, int limit, HashMap<Integer, Integer> countMap) {
        Map<Integer, Integer> nums = new HashMap<>(2*max);
        int temp;
        for (int i = 0; i <= max; i++) {
            temp = getCount(i, countMap);
            if (temp <= limit) {
                nums.put(i, temp);
            }
        }
        return nums;
    }

//    public static List<String> ReadBinaryWatchFun(int turnedOn) {
//        /**
//         * 4位可以表示0-11
//         * 6位可以表示0-59
//         * 0000  000000
//         * 也就是给定一个1的个数，有几种值的可能。\
//         * 穷举了
//         */
//        HashMap<Integer, Integer> countMap = new HashMap<>();
//        Integer a = 0;
//        Integer b = 0;
//        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < 12; i++) {
//            for (int j = 0; j < 60; j++) {
//                a = getCount(i, countMap);
//                if (a > turnedOn) {
//                    break;
//                }
//
//                b = getCount(j, countMap);
//                if (a + b == turnedOn) {
//                    ans.add(i + ":" + String.format("%02d",j));
//                }
//            }
//        }
//
//        return ans;
//    }

    public static int getCount(int i, HashMap<Integer, Integer> countMap) {
        int tempI = i;
        Integer a = countMap.get(i);
        if (a != null) {
            return a;
        }
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        countMap.put(tempI, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(ReadBinaryWatchFun(1));
    }

}
