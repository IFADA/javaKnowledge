package clone;

import lombok.Data;

import java.io.*;


public class Person implements Serializable,Cloneable{
    private String name;
    private int age;
    private  Children children;
    private Grandson grandson;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Children getChildren() {
        return children;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public Person(String name, int age, Children children) {
        this.name = name;
        this.age = age;
        this.children = children;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                '}';
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {

        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bout);
            out.writeObject(this);
            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bin);
            Person person = (Person) in.readObject();
            return clone();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
