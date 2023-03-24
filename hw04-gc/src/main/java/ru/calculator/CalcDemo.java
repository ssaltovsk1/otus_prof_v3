package ru.calculator;


/*
-Xms2048m
-Xmx4096m
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./logs/heapdump.hprof
-XX:+UseG1GC
-Xlog:gc=debug:file=C:\_prog\Java\OTUS\_logs\gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m
*/

/*
  ! Если Xms указать больше, чем Xmx - будет ошибка
  ! Если указать значения Xms больше, чем оперативной памяти - также ошибка

  G1 -Xms256m
  Xmx 256 - ошибка - Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
  Xmx 512  - 7492 msec
  Xmx 1024 - 6812 msec
  Xmx 2048 - 7543 msec
  Xmx 4096 - 6564 msec

  G1 -Xms512m
  Xmx 512  - 6645 msec
  Xmx 1024 - 6002 msec
  Xmx 2048 - 5330 msec
  Xmx 4096 - 4443 msec

  G1 -Xms2048m
  Xmx 2048 - 4845 msec
  Xmx 4096 - 4681 msec - После оптимизации 1306 msec

  G1 -Xms4096m
  Xmx 4096 - 5802 msec

  G1 -Xms4096m
  Xmx 16384 - 5802 msec

  Xms 2048m
  Xmx 4096
  ParallelGC - 8824 msec
  SerialGC - 6406 msec
*/

import java.time.LocalDateTime;

public class CalcDemo {
    public static void main(String[] args) {
        long counter = 100_000_000;
        var summator = new Summator();
        long startTime = System.currentTimeMillis();

        for (var idx = 0; idx < counter; idx++) {
            var data = new Data(idx);
            summator.calc(data);

            if (idx % 10_000_000 == 0) {
                System.out.println(LocalDateTime.now() + " current idx:" + idx);
            }
        }

        long delta = System.currentTimeMillis() - startTime;
        System.out.println(summator.getPrevValue());
        System.out.println(summator.getPrevPrevValue());
        System.out.println(summator.getSumLastThreeValues());
        System.out.println(summator.getSomeValue());
        System.out.println(summator.getSum());
        System.out.println("spend msec:" + delta + ", sec:" + (delta / 1000));
    }
}
