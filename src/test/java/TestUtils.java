import clone.Children;
import clone.Person;
import clone.User;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

public class TestUtils {

    @Test
    public void test1() throws Exception {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(18);
        System.out.println(p1 + ":" + p1.hashCode());
        System.out.println(p2 + ":" + p2.hashCode());


        Class clazz = Class.forName("clone.Person");
        Person p3 = (Person) clazz.getConstructor().newInstance();
        p3.setName("李四");
        p3.setAge(28);


        Person p4 = (Person) clazz.getConstructor().newInstance();
        p4.setName("李四");
        p4.setAge(28);


        System.out.println(p3 + ":" + p3.hashCode());
        System.out.println(p4 + ":" + p4.hashCode());
    }

    @Test
    public void test2() throws Exception {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        Person p2 = p1.clone();
        System.out.println(p1 + ":" + p1.hashCode());
        System.out.println(p2 + ":" + p2.hashCode());

    }

    /**
     * 测试克隆对象和原对象之间的成员变量关系
     *
     * @throws Exception
     */

    @Test
    public void test3() throws Exception {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(4);
        p1.setChildren(children1);
        Person p2 = p1.clone();
        System.out.println(p1 + ":对象的hash值" + p1.hashCode() + "成员变量的hash值" + children1.hashCode());
        System.out.println(p2 + ":对象的hash值" + p2.hashCode() + "成员变量的hash值" + children1.hashCode());

    }


    @Test
    public void test5() throws Exception {
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        Children children1 = new Children();
        children1.setName("张伟");
        children1.setAge(4);
        p1.setChildren(children1);


        Person p2 = p1.clone();
        System.out.println(p1.getChildren());
        System.out.println(p2.getChildren());
        Children children2 = new Children();

        children2.setName("张三");
        p2.setChildren(children2);
        System.out.println(p1.getChildren());
        System.out.println(p2.getChildren());


    }

    @Test
    public void test7() throws Exception {
        User user = new User();
        user.setName("李四");
        user.setAge(16);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(user);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bin);
        User object = (User) in.readObject();
        System.out.println(user+":"+user.hashCode());
        System.out.println(object+":"+object.hashCode());

    }
}
