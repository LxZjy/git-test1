package Day3;


import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

/*
* 利用面向对象的思想设计一个图书管理系统。图书的属性有：编号，书名，作者，价格。要求提供如下功能：

1、提供操作菜单，可以选择要进行的操作。

2、可以添加图书，添加图书时，编号需要唯一，添加成功，返回到菜单。

3、可以查询图书，显示所有图书信息，然后返回到菜单。

4、可以根据书名，查询单本图书信息，显示信息后，返回到菜单。

5、可以删除图书，通过编号删除，删除成功后，返回到菜单。

6、可以修改图书的信息，但编号不可以修改，修改成功后，返回到菜单。

7、可以退出系统，结束程序运行。

提示：

1、所有图书信息由键盘录入

2、图书的价格可以定义为字符串类型，因为在键盘录入时，不可以先使用nextInt()方法获取整数然后再使用nextLine()方法获取字符串，这样会导致nextLine()方法获取不到数据。
* */
public class HomeWork05 {
    public static void main(String[] args) {
        ArrayList<VFP> list = new ArrayList<>();
        addVFP(list);


    }
    public static void addVFP(ArrayList<VFP>arr){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入图书ID:");
        String id = sc.nextLine();
        System.out.print("请输入书名:");
        String BookName = sc.nextLine();
        System.out.print("请输入书的作者:");
        String writer = sc.nextLine();
        System.out.print("请输入书的价格:");
        String price = sc.nextLine();
        VFP vfp = new VFP();
        vfp.setId(Integer.parseInt(id));
        vfp.setBookName(BookName);
        vfp.setWriter(writer);
        vfp.setPrice(Integer.parseInt(price));
        arr.add(vfp);
    }
}

class VFP {
    private int id;
    private String BookName;
    private String writer;
    private int price;

    public VFP(){
    }

    public VFP(int id, String bookName, String writer, int price) {
        this.id = id;
        BookName = bookName;
        this.writer = writer;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "VFP{" +
                "id=" + id +
                ", BookName='" + BookName + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                '}';
    }
}