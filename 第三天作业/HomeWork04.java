package Day3;


import java.util.ArrayList;

/*
* 有如下员工信息：

~~~java
姓名：张三，工资：3000
姓名：李四，工资：3500
姓名：王五，工资：4000
姓名：赵六，工资：4500
姓名：田七，工资：5000
~~~

先需要将所有的员工信息都存入ArrayList集合中，并完成如下操作：

1、判断是否有姓名为“王五”的员工，如果有，改名为“王小五”

2、判断是否有姓名为“赵六”的员工，如果有，将其删除

3、给姓名为“田七”的员工，涨500工资

* */
public class HomeWork04 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Person person1 = new Person("张三", 3000);
        Person person2 = new Person("李四", 3500);
        Person person3 = new Person("王五", 4000);
        Person person4 = new Person("赵六", 4500);
        Person person5 = new Person("田七", 5000);
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            String name = p.getName();
            int salary = p.getSalary();
            if ("赵六".equals(name)){
                list.remove(i);
                i--;
                System.out.println("删除的员工信息为:"+p.getName());
            }
            if (name.equals("王五")){
                Person p1 = list.get(i);
                p1.setName("王小五");
                System.out.println("修改后的员工名为:"+p1.getName());
            }
            if (name.equals("田七")){
                Person p1 = list.get(i);
                p1.setSalary(salary+500);
                System.out.println("修改后的工资为:"+p1.getSalary());
            }
        }
        System.out.println("====修改后的集合结果为====");
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            System.out.println("姓名："+person.getName()+"\t"+"工资："+person.getSalary());
        }
    }
}

class Person {
    private String name;
    private int salary;

    public Person(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}