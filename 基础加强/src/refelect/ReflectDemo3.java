package refelect;

import domain.Person;

import java.lang.reflect.Constructor;

public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {

        //获取person的Class对象
        Class personClass = Person.class;

        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //创建对象
        Object person = constructor.newInstance("xiaoyu", 17);
        System.out.println(person);
        System.out.println("-------------------------");
        //使用空参构造创建对象
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        Object obj1 = constructor1.newInstance();
        System.out.println(obj1);
        //简化空参创建对象
        Object obj2 = personClass.newInstance();
        System.out.println(obj2);
    }
}
