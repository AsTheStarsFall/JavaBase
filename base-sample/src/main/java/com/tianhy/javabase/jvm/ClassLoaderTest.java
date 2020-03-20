package com.tianhy.javabase.jvm;

/**
 * @Author: thy
 * @Date: 2020/2/28 3:25
 * @Desc: 自定义类加载器
 */
public class ClassLoaderTest extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classFromPath = getClassFromPath();
        return defineClass(name, classFromPath, 0, classFromPath.length);
    }

    private byte[] getClassFromPath() {
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
/*        ClassLoaderTest classLoaderTest = new ClassLoaderTest();

        Class<?> myClass = Class.forName("MyClass", true, classLoaderTest);
        Object o = myClass.newInstance();
        System.out.println(o.getClass().getClassLoader());*/
        Class<?> myClass = Class.forName("ClassLoaderTest");
        Object newInstance = myClass.newInstance();

        System.out.println(myClass.getClassLoader());
    }
}
