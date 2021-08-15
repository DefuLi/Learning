package otherexperiment.gengricprogram;

/**
 * @author Defu Li
 * @since 2021/2/9 11:48
 */
public abstract class BaseService<T> {
    public Result handle(){
        Result result = new Result();
        method1();
        result.setResponse(method2());
        return result;
    }

    private void method1(){
        System.out.println("method1");
    }

    private T method2(){
        T response = initResponse();
        System.out.println("method2");
        return response;
    }

    protected abstract T initResponse();
}
