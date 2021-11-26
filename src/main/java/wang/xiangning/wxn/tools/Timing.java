/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.tools
 *
 *    Filename:    Timing
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
 *    Create at:   2021/11/26 2:33 下午
 *
 *    Revision:
 *
 *    2021/11/26 2:33 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.tools;

import java.util.function.Consumer;

/**
 * Timing
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/26 2:33 下午
 */
public class Timing {

    public static void go(String name, int num, Consumer<String> consumer) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            consumer.accept(name);
        }
        long e = System.currentTimeMillis();
        System.out.println(name + "耗时" + (e - s));
    }
}
