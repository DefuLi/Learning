package otherexperiment;

/**
 * @author Defu Li
 * @date 2021/2/27 12:43
 */
public class Swan {
    public String name = "Swan";
    public void fly(){
        System.out.println("swan can fly ...");
    }
}

class UglyDuck extends Swan{
    public String name = "UglyDUck";
    public void fly(){
        System.out.println("ugly duck can't fly ...");
    }
}
