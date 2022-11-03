package Day4;

import Day1.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Lx
 * @data 2022/11/3 18:25
 * version 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        List<user> userALlList = new ArrayList<>();
        userALlList.add(new user(18, "豪哥", "女"));
        userALlList.add(new user(19, "小周", "女"));
        userALlList.add(new user(20, "小张", "男"));
        userALlList.add(new user(20, "小尚", "女"));
        userALlList.add(new user(20, "魏楠", "男"));
        // 场景三：找到年龄为20，并且性别为女的用户
        List<user> age20NameSexList = new ArrayList<>();
        for (user user : userALlList) {
            if (20 == user.getAge() && "女".equals(user.getSex())) {
                age20NameSexList.add(user);
            }
        }
        System.out.println(age20NameSexList);
        // 改进
        List<user> collect4 = userALlList.stream()
                .filter(user -> 20 == user.getAge() && "女".equals(user.getSex()))
                .collect(Collectors.toList());
        System.out.println(collect4);
    }
}
