package annotation;

import java.lang.annotation.*;

//表示该注解只能作用于类上
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
//当前被描述的注解会保留到class字节文件中，并被JVM读取
@Retention(value = RetentionPolicy.RUNTIME)
//会被抽取到java文档中
@Documented
public @interface MyAnno3 {


}
