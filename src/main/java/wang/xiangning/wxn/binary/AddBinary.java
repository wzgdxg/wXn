/******************************************************************
 *
 *    Powered By hhdd.com.
 *
 *    Copyright (c) 2001-2019
 *    https://kada.hhdd.com/
 *
 *    Package:     wang.xiangning.wxn.binary
 *
 *    Filename:    AddBinary
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
 *    Create at:   2021/11/16 4:55 下午
 *
 *    Revision:
 *
 *    2021/11/16 4:55 下午
 *        - first revision
 *
 *****************************************************************/
package wang.xiangning.wxn.binary;

/**
 * leetCode 67
 * AddBinary
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * @author wangzg
 * @version 1.0.0
 * @create 2021/11/16 4:55 下午
 */
public class AddBinary {

    public static String AddBinaryFun(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        int carry = 0;
        int temp = 0;
        int index;
        int arrLength = aArr.length > bArr.length ? aArr.length : bArr.length;
        char[] arr = new char[arrLength];
        for (int i = 0; i < arrLength; i++) {
            temp = 0;
            temp += carry;
            carry = 0;
            if (aArr.length > i) {
                temp += (aArr[aArr.length-1 - i] - '0');
            }
            if (bArr.length > i) {
                temp += (bArr[bArr.length-1 - i] - '0');
            }
            index = arr.length - 1 - i;
            if (temp == 0) {
                arr[index] = '0';
            } else if (temp == 1) {
                arr[index] = '1';
            } else if(temp == 2) {
                arr[index] = '0';
                carry = 1;
            } else {
                arr[index] = '1';
                carry = 1;
            }
        }
        if (carry == 1) {
            return "1"+new String(arr);
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
//        System.out.println(AddBinaryFun(a, b));

        a = "0";
        b = "0";
        System.out.println(AddBinaryFun(a, b));
    }

}
