package otherexperiment;

public class IsCoreThread {

    /**
     * 判断Java创建的线程是否为内核级线程
     *
     * 可以在任务管理器中查看线程数量是否增多，如果增多了就说明了Java创建的是内核级线程
     * @param args
     */
    public static void main(String[] args) {

        /** 判断Java使用的是否为内核级线程
        for (int i = 0; i < 300; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
         **/
    }
}
