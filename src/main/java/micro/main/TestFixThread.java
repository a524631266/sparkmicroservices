package micro.main;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFixThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        System.out.println(System.currentTimeMillis());
        Future<Integer> submit = executorService.submit(() -> {
            try {
                Thread.sleep(10000);
                System.out.println("内部");
                return 12;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return  123;
            }
//            finally {
//                System.out.println("外部");
//                return 1111;
//            }
        });
        try {
            Integer integer = submit.get();
            System.out.println("inter" + integer);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
