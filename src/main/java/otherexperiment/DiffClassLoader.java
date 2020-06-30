package otherexperiment;

public class DiffClassLoader {
    public static void main(String[] args) {
        // 当前类加载器
        System.out.println(DiffClassLoader.class.getClassLoader());

        // 当前类加载器的父类加载器
        System.out.println(DiffClassLoader.class.getClassLoader().getParent());
        System.out.println(DiffClassLoader.class.getClassLoader().getParent().getParent());
        

    }
}
