package ru.idcore;

import java.util.Map;

public class WriteMapRunnable implements Runnable {
    private Map<Integer, Integer> map;
    private final int maxValue;

    public WriteMapRunnable(Map<Integer, Integer> map, int maxValue) {
        this.map = map;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxValue; i++) {
            //map.get((int) (Math.random() * ((maxValue + 1))));
            map.replace(
                    (int) (Math.random() * ((maxValue + 1))),
                    (int) (Math.random() * ((maxValue + 1)))
            );
        }
    }
}
