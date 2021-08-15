package otherexperiment.pecs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Defu Li
 * @since 2021/3/2 21:34
 */
public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<Apple>();
        List<? extends Fruit> fruits = apples;
    }
}
