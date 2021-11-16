/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.tools
 *
 *    Filename:    RandomUtil
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
 *    Create at:   2021/11/15 3:09 下午
 *
 *    Revision:
 *
 *    2021/11/15 3:09 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.tools;

import java.util.Random;

/**
 * RandomUtil
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/15 3:09 下午
 */
public class RandomUtil {

    public static int one(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(one(1000));
        }
    }

}
