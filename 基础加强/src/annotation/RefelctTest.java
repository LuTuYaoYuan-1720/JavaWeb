package annotation;

import java.lang.reflect.Method;

/**
 * 框架类
 */
@Pro(className = "annotation.Demo1", methodName = "show")
public class RefelctTest {

    public static void main(String[] args) throws Exception {

        //1.解析注解
        //1.1  获取该类的字节码对象
        Class<RefelctTest> refelctTestClass = RefelctTest.class;

        //2.获取上边的注解对象
        //其实就是在内存中生成一个该注解接口的子类实现对象
        Pro an = refelctTestClass.getAnnotation(Pro.class);

        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        Class cls = Class.forName(className);
        Object demo1 = cls.newInstance();

        Method show = cls.getMethod(methodName);
        show.invoke(demo1);
    }
}
