package Day3;

import java.util.ArrayList;
import java.util.Arrays;

/*
*## 题目3（训练）

现有如下字符串元素：["aaa", "bbb", "aaa", "aaa", "ccc", "bbb"]，
* 请将所有的元素按顺序存入ArrayList集合中，并遍历集合查看存储结果。

* */
public class HomWork03 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String[] str = {"aaa", "bbb", "aaa", "aaa", "ccc", "bbb"};
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        for (int j = 0; j < list.size(); j++) {
            System.out.print(list.get(j)+" ");
        }
    }
}
