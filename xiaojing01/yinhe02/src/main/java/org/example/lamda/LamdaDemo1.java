package org.example.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LamdaDemo1 {


public  static  void main(String[] args){

    List<String> list= Arrays.asList("apple","banana","orange");
//    for(String  s: list){
//        System.out.println(s);
//    }

    for (String s : list){
        System.out.println(s);
    }

    //022 reduce累加 演示
    List<Integer> list2=Arrays.asList(1,2,3,4,5,6);
    int sum=0;

    for (Integer v :list2){
        sum+=v;

    }
    System.out.println(sum);

    int sum2=list2.stream().reduce(0,(a,b)->a+b);
    System.out.println(sum2);

    List<String> list3 =new ArrayList<>();
    for(String s: list){
        if(s.startsWith("a")){
            list3.add(s);
        }
    }
    System.out.println("------------------我是测试遍历集合打印包含a开头的数据");
    System.out.println(list3);
// 023用filter 过滤lamda表达式的形式
    List<String > list4 =list.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
    System.out.println("------------------我是测试遍历集合打印包含a开头的数据2");
    System.out.println(list4);

//AI 编程的形式
//    List<String> filteredWords = words.stream()
//            .filter(word -> word.contains("a"))



    //024map 求长度
    List<Integer> list6 =new ArrayList<>();
    for (String s  :list){
        list6.add(s.length());
    }
    System.out.println(list6);

    List<Integer> list5=list.stream().map(s -> s.length()).collect(Collectors.toList());
    System.out.println(list5);
    List<Integer> list7 =list.stream().map(k->{
        return k.length();
    }).collect(Collectors.toList());

    System.out.println("------------------我是函数式list7");
    System.out.println(list7);


}
}
