package otherexperiment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Defu Li
 * @date 2021/2/25 15:49
 */
public class Human {
    public <T extends Human> void func1(T t){
        if(t instanceof Human){
            System.out.println("true");
        }
    }

//    public <T super Human> void func2(){}

    public List<? super Human> func3(){
        return new ArrayList<>();
    }

    public <T> void func4(T t){
        t.toString();
    }



//    public List<? super Human> func3(){
//        return new ArrayList<>();
//    }
//
//    public <T> void func4(T t){
//        t.toString();
//    }

    public static void main(String[] args) {
//        Human human = new Human();
//        human.func1();

        MathOperation result = x -> {x = x*2; return x + 1;};
    }
}

interface MathOperation {
    int operation(int a);
}