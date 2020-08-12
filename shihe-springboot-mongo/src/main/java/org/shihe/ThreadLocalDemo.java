package org.shihe;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author admin
 * @Date 2020-08-10 10:05
 * @Version 1.0
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        int threadNum = 3;

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(()->{
                for (int j = 0; j <= 2; j++) {
                    MyUtil.add(String.valueOf(j));
                    MyUtil.print();
                }
                MyUtil.set("hello world!!");
                countDownLatch.countDown();
            }).start();
        }
    }

    public static class MyUtil{
        public static void add(String newStr){
            StringBuilder str = StringBuilderUtil.stringBuilderThreadLcoal.get();
            StringBuilderUtil.stringBuilderThreadLcoal.set(str.append(newStr));
        }

        public static void print(){
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    StringBuilderUtil.stringBuilderThreadLcoal.hashCode(),
                    StringBuilderUtil.stringBuilderThreadLcoal.get().hashCode(),
                    StringBuilderUtil.stringBuilderThreadLcoal.get().toString());
        }
        public static void set(String words){
            StringBuilderUtil.stringBuilderThreadLcoal.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    StringBuilderUtil.stringBuilderThreadLcoal.hashCode(),
                    StringBuilderUtil.stringBuilderThreadLcoal.get().hashCode(),
                    StringBuilderUtil.stringBuilderThreadLcoal.get().toString());
        }
    }
    public static class StringBuilderUtil{
        private static ThreadLocal<StringBuilder> stringBuilderThreadLcoal = ThreadLocal.withInitial(()->new StringBuilder());
    }
}
