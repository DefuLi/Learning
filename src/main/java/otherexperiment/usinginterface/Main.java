package otherexperiment.usinginterface;

/**
 * @author Defu Li
 * @since 2020/9/16 15:40
 */
public class Main {
    public void act(Animal animal) {
        animal.act();
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Dog dog = new Dog();
        obj.act(dog);
    }
}
