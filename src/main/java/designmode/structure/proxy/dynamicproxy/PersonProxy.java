package designmode.structure.proxy.dynamicproxy;

import designmode.structure.proxy.staticproxy.IPerson;
import designmode.structure.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Person动态代理类
 *
 * @author Defu Li
 * @since 2021/7/28 22:34
 */
public class PersonProxy implements InvocationHandler {
    private IPerson person;

    public IPerson getInstance(IPerson person) {
        this.person = person;
        return (IPerson) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行主函数前的代理行为");
        if (method.getName().equals("eat")) {
            System.out.println("这是吃饭");
        }
        if (method.getName().equals("sleep")) {
            System.out.println("这是睡觉");
        }
        System.out.println("执行主函数后的代理行为");
        return null;
    }
}
