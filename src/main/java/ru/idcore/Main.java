package ru.idcore;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int MAX_VALUE = 3_000_000;

    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getInstance();
        Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Map<Integer, Integer> hashMap = Collections.synchronizedMap(new HashMap<>());
        int countThread = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(countThread);

        List<Integer> integerList = new ArrayList<>();
        logger.log("Начало заполнения массива. Количество записей: " + MAX_VALUE);
        for (int i = 0; i <MAX_VALUE ; i++) {
            integerList.add((int) (Math.random() * ((MAX_VALUE + 1))));
        }
        logger.log("Окончание заполнения массива...");

        logger.log("Начало заполнения concurrentHashMap.Количество записей: " + MAX_VALUE);
        for (int i = 0; i <integerList.size() ; i++) {
            concurrentHashMap.put(i, integerList.get(i));
        }
        logger.log("Окончание заполнения concurrentHashMap...");

        logger.log("Начало заполнения hashMap.Количество записей: " + MAX_VALUE);
        for (int i = 0; i <integerList.size() ; i++) {
            hashMap.put(i, integerList.get(i));
        }
        logger.log("Окончание заполнения hashMap...");


        logger.log("Пишем / читаем concurrentHashMap: Количество записей/чтений: " + MAX_VALUE + ", количество потоков:" + countThread);
        for (int i = 0; i <countThread ; i++) {
            service.submit(new WriteMapRunnable(concurrentHashMap, MAX_VALUE));
            service.submit(new ReadMapRunnable(concurrentHashMap, MAX_VALUE));
        }
        service.awaitTermination(10, TimeUnit.SECONDS);

        logger.log("Окончание записи / чтения concurrentHashMap");

        logger.log("Пишем / читаем hashMap: Количество записей/чтений: " + MAX_VALUE + ", количество потоков:" + countThread);
        for (int i = 0; i <countThread ; i++) {
            service.submit(new WriteMapRunnable(hashMap, MAX_VALUE));
            service.submit(new ReadMapRunnable(hashMap, MAX_VALUE));
        }
        service.awaitTermination(3, TimeUnit.SECONDS);
        logger.log("Окончание записи / чтения hashMap");

        service.shutdown();

    }
}
