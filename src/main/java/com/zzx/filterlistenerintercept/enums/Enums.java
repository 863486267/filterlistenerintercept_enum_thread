package com.zzx.filterlistenerintercept.enums;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Created by:  Vivian
 * Date: 2018/7/26 18:25
 */

/**
 * 测试在启动类！
 */
public enum Enums {
        SF("顺丰", 111), YT("圆通", 123), ST("申通", 456), YZ("邮政", 789);
        private String complay;
        private int code;

    Enums(String complay, int code) {
            this.complay = complay;
            this.code = code;
        }

        public String getComplay() {
            return complay;
        }


        public int getCode() {
            return code;
        }


    public String complay(int code) {
        for (Enums e : Enums.values()
                ) {
            if (code == e.code) {
                return e.complay;
            }
        }
        return null;
    }

    public int code(String comlpay) {
        for (Enums e : Enums.values()
                ) {
            if (comlpay.equals(e.complay)) {
                return e.code;
            }
        }
        return 0;
    }

    }




