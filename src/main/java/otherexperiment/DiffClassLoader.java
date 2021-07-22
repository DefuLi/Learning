package otherexperiment;

import java.io.PrintStream;

public class DiffClassLoader {
    public static void main(String[] args) {
        // 当前类加载器
        final PrintStream out = System.out;
        out.println(DiffClassLoader.class.getClassLoader());

        // 当前类加载器的父类加载器
        ClassLoader classLoader = DiffClassLoader.class.getClassLoader().getParent();
        out.println(classLoader);
        out.println(classLoader.getParent());
        

    }
}
