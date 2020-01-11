package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilsTest {
    @Test
    public void test1() throws InvocationTargetException, IllegalAccessException {
        User user  = new User();

        BeanUtils.setProperty(user,"username","zhangsan");
        System.out.println(user);
    }

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = new HashMap<>();
        map.put("username", new String[]{"superbaby"});
        map.put("password", new String[]{"123"});

        User loginUser = new User();
        BeanUtils.populate(loginUser, map);
        System.out.println(loginUser);
    }

}
