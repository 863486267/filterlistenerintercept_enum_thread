package com.zzx.filterlistenerintercept.listenerfilterintercept;

import java.util.Random;

public class RandomChar {
    private static String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
    private static String num = "1234567890";

    public static String getRandomStr(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }

        return sb.toString();
    }

    public static String getRandomNum(int length){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            //产生0-9的数字
            int number = random.nextInt(10);
            sb.append(num.charAt(number));
        }

        return sb.toString();
    }
}
