package Homework;


import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class HomeWork03 {
    public static void main(String[] args) throws IOException {
        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        properties.list(System.out);
        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + "";

        Dog dog = new Dog(name, age, color);
        System.out.println(dog);
        String serFilePath = "e:\\dog.data";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);
        oos.close();
        System.out.println("Dog对象序列化完成");
    }
    //编写一个方法反序列化
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath="e:\\dog.data";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFilePath));
       Dog dog= (Dog) ois.readObject();
       System.out.println("===反序列化后===");
       System.out.println(dog);
       ois.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
