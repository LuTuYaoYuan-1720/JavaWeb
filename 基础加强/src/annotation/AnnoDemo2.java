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
        //����show1
    }

    public void Demo() {
        show1();

        //Date �����кܶ࣬���ǻ�������
        Date date = new Date();
    }
}
