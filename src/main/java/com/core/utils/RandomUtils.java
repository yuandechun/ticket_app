package com.core.utils;

public class RandomUtils {

    private static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final java.util.Random RANDOM = new java.util.Random();

    /***
     * random string
     * @param size
     * @return
     */
    public static String getRandomStr(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(RANDOM_STR.charAt(RANDOM.nextInt(RANDOM_STR.length())));
        }
        return sb.toString();
    }

}
