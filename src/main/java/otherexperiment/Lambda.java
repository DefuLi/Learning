package otherexperiment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Defu Li
 * @date 2020/9/15 15:57
 */
public class Lambda {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("runnable labmda");
        new Thread(runnable).start();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        String res = list.stream().map((x) -> x * x).reduce((x, y) -> x + y).get().toString();
        System.out.println(res);

        Lambda lambda = new Lambda();
        lambda.excute(() -> System.out.println("defuli"));
    }

    public void excute(WorkerInterface workerInterface) {
        workerInterface.doSomeWork();
    }
}

@FunctionalInterface
interface WorkerInterface {
    void doSomeWork();
}
