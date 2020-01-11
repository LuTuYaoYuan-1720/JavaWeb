package annotation;

public @interface MyAnno1 {
    int value();

    int age() default 10;

    String name();

    MyAnno2 myAnno2();

    Person per();

    String[] strs();

}
