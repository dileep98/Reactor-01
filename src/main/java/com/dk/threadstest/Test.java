package com.dk.threadstest;

import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        using Runnable run()
//        Thread t = new Thread(new Task());
//        t.start();

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new Task()); // returns a future

//        System.out.println(future.get()); // if we put this line here we are blocking the main thread. the out put of main thread will be print at the end
        for(int i = 0; i<10; i++){
            System.out.println("main method is doing this task by the thread :"+ Thread.currentThread().getName());
        }


        System.out.println(future.get()); // still a blocking call. that's the reason they developed completable future.
    }
}


//class Task implements Runnable {
//    @Override
//    public void run() {
//        for(int i = 0; i<10; i++){
//            System.out.println("Runnable run() method is doing this task by the thread :"+ Thread.currentThread().getName());
//        }
//    }
//}


class Task implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i = 0; i<10; i++){
            System.out.println("Callable run() method is doing this task by the thread :"+ Thread.currentThread().getName());
        }
        return "Done...";
    }
}
