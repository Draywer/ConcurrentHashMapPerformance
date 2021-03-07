#### Домашнее задание к занятию 1.4 Коллекции для параллельной (конкурирующей) работы.
#### Задача 2. Разница в производительности

```text
"C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\jbr\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\lib\idea_rt.jar=64113:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\User\IdeaProjects\ConcurrentHashMapPerformance\target\classes;C:\Users\User\.m2\repository\org\apache\httpcomponents\httpclient\4.5.12\httpclient-4.5.12.jar;C:\Users\User\.m2\repository\org\apache\httpcomponents\httpcore\4.4.13\httpcore-4.4.13.jar;C:\Users\User\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\User\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\User\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.12.1\jackson-databind-2.12.1.jar;C:\Users\User\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.12.1\jackson-annotations-2.12.1.jar;C:\Users\User\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.12.1\jackson-core-2.12.1.jar;C:\Users\User\.m2\repository\org\hamcrest\hamcrest-all\1.3\hamcrest-all-1.3.jar ru.idcore.Main
[08.03.2021 02:56:00 1] Начало заполнения массива. Количество записей: 3000000
[08.03.2021 02:56:01 2] Окончание заполнения массива...
[08.03.2021 02:56:01 3] Начало заполнения concurrentHashMap.Количество записей: 3000000
[08.03.2021 02:56:03 4] Окончание заполнения concurrentHashMap...
[08.03.2021 02:56:03 5] Начало заполнения hashMap.Количество записей: 3000000
[08.03.2021 02:56:04 6] Окончание заполнения hashMap...
[08.03.2021 02:56:04 7] Пишем / читаем concurrentHashMap: Количество записей/чтений: 3000000, количество потоков:3
[08.03.2021 02:56:14 8] Окончание записи / чтения concurrentHashMap
[08.03.2021 02:56:14 9] Пишем / читаем hashMap: Количество записей/чтений: 3000000, количество потоков:3
[08.03.2021 02:56:17 10] Окончание записи / чтения hashMap

Process finished with exit code 0
```