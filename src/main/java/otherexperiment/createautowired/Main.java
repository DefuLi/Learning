package otherexperiment.createautowired;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 自动装配的过程
        A a = new A();
        Class<? extends A> clazz = a.getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (autowired != null) {
                Class fieldClass = field.getType();  // 在这里就是B.class
                B b = (B) fieldClass.newInstance();
                field.set(a, b);
            }
        }

        // 测试 打印输出
        a.printBName();  // defuli
    }


}
