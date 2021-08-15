package otherexperiment.usinginterface;

/**
 * @author Defu Li
 * @since 2020/9/16 15:39
 */
public class Dog implements Animal {
    @Override
    public void act() {
        System.out.println("狗会叫，还会咬人。");
    }
}
