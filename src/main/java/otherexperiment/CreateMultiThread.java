package otherexperiment;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的三种方式
 * 1、继承Thread类，重写run方法
 * 2、实现Runnable接口，重写run方法
 * 3、使用Future和Callable组合
 */
public class CreateMultiThread {
    public static void main(String[] args) {
        CreateMultiThread obj = new CreateMultiThread();
        System.out.println(obj.test());  // 1
    }

    /**
     * 第三种方法
     * @return
     */
    public int test() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        };

        FutureTask<Integer> future = new FutureTask<>(callable);
        Thread thread = new Thread(future);
        thread.start();
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

/**
 * 第二种方法
 * class Run implements Runnable{
 *
 * @Override public void run() {
 * System.out.println("hello boy!");
 * }
 * }
 * <p>
 * 第一种方法
 * class Mythread extends Thread{
 * @Override public void run() {
 * System.out.println("hello boy!");
 * }
 * }
 * <p>
 * 第一种方法
 * class Mythread extends Thread{
 * @Override public void run() {
 * System.out.println("hello boy!");
 * }
 * }
 */

/**
 * 第一种方法
 class Mythread extends Thread{
@Override public void run() {
System.out.println("hello boy!");
}
}
 */