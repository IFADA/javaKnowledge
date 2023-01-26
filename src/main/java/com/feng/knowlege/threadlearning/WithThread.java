package com.feng.knowlege.threadlearning;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

public class WithThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            long start = System.currentTimeMillis();
            List<Callable<String>> callableList = Lists.newArrayList();
            Callable<String> callableA =()->{Thread.sleep(100L);return "A";};
            callableList.add(callableA);
            Callable<String> callableB =()->{Thread.sleep(700L);return "B";};
            callableList.add(callableB);
            List<Future<String>> futureList = executorService.invokeAll(callableList);
            StringBuilder stringBuilder = new StringBuilder();
            for (Future<String> future: futureList) {
                stringBuilder.append(future.get());
            }
            long end = System.currentTimeMillis();


            System.out.println("调用完完毕"+stringBuilder.toString()+"总耗时"+(end-start)+"毫秒");
        }finally {
           executorService.shutdown();
        }
    }
}
