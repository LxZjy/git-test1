package Homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork01 {
    public static void main(String[] args) throws IOException {
        String directoryPath="e:\\mytemp";
        File file = new File(directoryPath);
        if (!file.exists()){//如果文件不存在
            //创建
            if (file.mkdirs()){
                System.out.println("创建目录成功");
            }else {
                System.out.println("创建目录失败");
            }
        }
        String filePath=directoryPath+"\\hello.txt";
        file=new File(filePath);
        if (!file.exists()){
            //创建文件
            if (file.createNewFile()){
                System.out.println(filePath+"创建成功");

                //如果文件存在我们就使用BufferedWriter字符输入流写入内容
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("hell,world");
                writer.close();
            }else {
                System.out.println(filePath+"创建失败");
            }
        }else {
            System.out.println(filePath+"已经存在不再重复创建");
        }
    }
}
