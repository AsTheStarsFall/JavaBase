package com.tianhy.javabase.reflect;

import com.tianhy.javabase.reflect.anno.TestAnnotation;
import com.tianhy.javabase.reflect.interfaces.TestInterface;

import java.lang.reflect.*;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/20
 **/
public class ReflectTest {

    /**
     * 通过反射调用对象：
     * 1.获取该类的Class Type
     * 2.通过getMethod方法获取Method对象
     * 3.通过调用invoke方法来执行对象的某个方法
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = TestMethod.class;
        Method method = clazz.getMethod("method",String.class);
        method.invoke(clazz.getConstructor().newInstance(),"thy");
    }

    public void t1(){
        Field[] fields = TestMethod.class.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i]+",");
//        }
        for (Field field : fields){
//            if(field.isAnnotationPresent(TestAnnotation.class)){
//                TestAnnotation annotation = field.getAnnotation(TestAnnotation.class);
//                String value = annotation.value();
//                System.out.println(value);
//            }
            //类名
            System.out.println(field.getType().getName());
        }
    }

}
