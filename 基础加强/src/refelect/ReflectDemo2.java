package refelect;

import domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;

        //getFields  方法只能获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();

        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------");

        Field a = personClass.getField("id");
        //获取成员变量a的值
        Person p = new Person();

        Object value = a.get(p);

        System.out.println(value);

        //设置变量值
        a.set(p,"17060210117");
        System.out.println(p);

        System.out.println("=====================");
        //getDeclaredFields 获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        //Field  getDeclaredField(String name)
        Field name = personClass.getDeclaredField("name");
        //忽略访问权限修饰符
        //暴力反射
        name.setAccessible(true);
        Object value2 = name.get(p);
        System.out.println(value2);

        //设置私有的变量
        name.set(p,"xiaoyu");
        System.out.println(p);
    }
}
