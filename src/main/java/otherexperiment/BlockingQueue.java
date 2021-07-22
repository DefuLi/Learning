package otherexperiment;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 验证BlockingQueue的阻塞等待
 */
public class BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        arrayBlockingQueue.put(1);
        System.out.println(1);
        arrayBlockingQueue.put(2);
        System.out.println(2);  // 会在这里一直阻塞住  java.lang.Thread.State: WAITING (parking)
        arrayBlockingQueue.put(3);
        System.out.println(3);
    }

}
