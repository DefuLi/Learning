package otherexperiment.createautowired;

public class A {
    @Autowired
    public B b;

    public void printBName() {
        System.out.println(b.name);
    }
}
