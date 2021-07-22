package otherexperiment;

/**
 * Java线程的start和run方法区别
 */
public class StartAndRunThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                sayHello();
                System.out.println("Current thread:" + Thread.currentThread().getName());
            }
        });

        thread.run();
        thread.start();
    }

    public static void sayHello(){
        System.out.println("hello, world!");
    }
}
