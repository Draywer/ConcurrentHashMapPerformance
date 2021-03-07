package ru.idcore;

import java.util.Map;

public class ReadMapRunnable implements Runnable {
    private Map<Integer, Integer> map;
    private final int maxValue;

    public ReadMapRunnable(Map<Integer, Integer> map, int maxValue) {
        this.map = map;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxValue; i++) {
            map.get((int) (Math.random() * ((maxValue + 1))));
        }
    }
}
