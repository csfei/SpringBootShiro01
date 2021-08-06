package com.cuisf.utils;

import java.util.Random;

public class SaltUtils {

    /**
     * 生成随机盐工具
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars="bakfbaowbfjkabofbaABCDEFGHIJKLMNOBWXYZ%$&^%*&*%$0123456789".toCharArray(); //转换为字符数组

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <n ; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];

            stringBuilder.append(aChar);
        }

        return stringBuilder.toString();

    }
}
