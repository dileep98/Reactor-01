package com.dk.completablefuture;

import java.util.concurrent.*;

public class FutureDemo1 {

    public String getFirstName() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Dileep";
    }


    public String getLastName()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Kumar";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        FutureDemo1.syncTask();
        FutureDemo1.asyncTask();


    }


    public static void syncTask(){
        long startTime = System.currentTimeMillis();
        FutureDemo1 futureDemo1 = new FutureDemo1();
        String firstname = futureDemo1.getFirstName(); // blocking call
        String lastName = futureDemo1.getLastName(); // blocking call
        String fullName = firstname+" "+lastName;
        System.out.println(fullName);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to run the program : "+ (endTime - startTime));
    }


    public static void asyncTask() throws ExecutionException, InterruptedException {
        System.out.println("asyncTask() executed by Thread : " + Thread.currentThread().getName());
        long startTime = System.currentTimeMillis();
        FutureDemo1 futureDemo1 = new FutureDemo1();

        Callable<String> firstNameCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("getFirstName() executed by Thread : " + Thread.currentThread().getName());
                return futureDemo1.getFirstName();
            }
        };

        Callable<String> lastNameCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("getLastName() executed by Thread : " + Thread.currentThread().getName());
                return futureDemo1.getLastName();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> firstNameFuture = executorService.submit(firstNameCallable);
        Future<String> lastNameFuture = executorService.submit(lastNameCallable);

        String firstName = firstNameFuture.get(); // still blocking
        String lastName = lastNameFuture.get(); // still blocking
        String fullName = firstName+" "+lastName;

        executorService.shutdown();
        System.out.println(fullName);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken to run the program : "+ (endTime - startTime));


        // correct way
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(futureDemo1::getFirstName);
        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(futureDemo1::getLastName);

        String finalString = stringCompletableFuture1.thenCombine(stringCompletableFuture2, (str1, str2) -> str1 + " " + str2).join(); // we are only blocking for one time rather than calling get() for two times
        System.out.println(finalString);


    }

}
