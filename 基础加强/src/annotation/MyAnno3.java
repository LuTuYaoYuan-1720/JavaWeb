package annotation;

import java.lang.annotation.*;

//��ʾ��ע��ֻ������������
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
//��ǰ��������ע��ᱣ����class�ֽ��ļ��У�����JVM��ȡ
@Retention(value = RetentionPolicy.RUNTIME)
//�ᱻ��ȡ��java�ĵ���
@Documented
public @interface MyAnno3 {


}
