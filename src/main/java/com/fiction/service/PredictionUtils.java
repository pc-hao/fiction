package com.fiction.service;

public class PredictionUtils {
    public static void check(boolean flag, String message) {
        if (flag) throw new RuntimeException(message);
    }
}
