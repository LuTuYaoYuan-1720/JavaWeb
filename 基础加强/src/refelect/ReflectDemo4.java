package refelect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo4 {

    public static void main(String[] args) throws Exception {

        //获取person的Class对象
        Class personClass = Person.class;

        //获取指定名称的方法
        Method eatMethod = personClass.getMethod("eat");
        //获取对象
        Object person = personClass.newInstance();
        //执行方法
        eatMethod.invoke(person);

        //获取一个有参的重载方法
        Method eatMethod1 = personClass.getMethod("eat", String.class);
        eatMethod1.invoke(person,"rice");

        System.out.println("----------------");

        //获取所有public方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            //也可以获取方法名
            System.out.println(method.getName());
        }

        //获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
