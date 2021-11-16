/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary.xor
 *
 *    Filename:    FindAlone
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
 *    Create at:   2021/11/15 3:56 下午
 *
 *    Revision:
 *
 *    2021/11/15 3:56 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary.xor;

import wang.xiangning.wxn.tools.RandomUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * FindAlone
 * 找出唯一落单的那个数字（也就是仅仅出现一次的那个数）
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 3:56 下午
 */
public class FindAlone {

    public static void FindAloneFun(List<Integer> list) {
        int ans = 0;
        for (int num : list) {
            ans ^= num;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int ans = 763;
        List<Integer> list = new ArrayList<>(2000);
        for (int i = 1; i <= 1000; i++) {
            if (i == ans) {
                continue;
            }
            list.add(i);
            list.add(i);
        }


        list.add(RandomUtil.one(1000), ans);
        Collections.shuffle(list);
        System.out.println(list.size());



        FindAloneFun(list);
    }

}
