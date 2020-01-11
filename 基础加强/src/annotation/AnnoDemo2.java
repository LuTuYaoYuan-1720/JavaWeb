package annotation;

import java.util.Date;

@SuppressWarnings("all")
public class AnnoDemo2 {
    @Override
    public String toString() {
        return "AnnoDemo2{}";
    }


    @Deprecated
    public void show1() {

    }

    public void show2() {
        //代替show1
    }

    public void Demo() {
        show1();

        //Date 类中有很多，但是还可以用
        Date date = new Date();
    }
}
