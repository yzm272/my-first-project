package org.example.lamda;

import java.util.*;
import java.util.stream.Collectors;

public class LamdaDemo2 {
    interface myInterface {
        void doSomething(String s);
    }

    public static void main(String[] args) {
// 025 多线程替换
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world1");
            }
        });

        thread1.start();
        Thread thread2 = new Thread(() -> System.out.println("hello world2"));
        thread2.start();
//026 groups 分组

        List<String> list = Arrays.asList("apple", "banana", "orange");
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String s : list) {
            int length = s.length();
            if (!groups.containsKey(length)) {
                groups.put(length, new ArrayList<>());

            }
            groups.get(length).add(s);

        }
        System.out.println("-----------------groups---------------------");
        System.out.println(groups);
        Map<Integer, List<String>> groups2 = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groups2);

// 027 接口
        myInterface a = new myInterface() {
            @Override
            public void doSomething(String s) {
                System.out.println(s);
            }

        };
        a.doSomething("hello world");

        myInterface b = (s) -> System.out.println(s);

        b.doSomething("hello world2");
// 028 多线程 转lamda 复习
        Thread a1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello World mutiThread");
            }
        });
        a1.start();

        Thread a2 = new Thread(() -> System.out.println("hello World mutiThread2"));
        a2.start();
//029 optional
        String string1 = "hello World Optional";
        if (string1 != null) {
            System.out.println(string1.toUpperCase());
        }
        Optional.ofNullable(string1).map(String::toUpperCase).ifPresent(System.out::println);
//030 sort 流水线

        List<String> list4 = Arrays.asList("orange", "banana", "humberkin", "apple");
        List<String> list5 = new ArrayList<>();
        for (String s : list4) {
            if (s.startsWith("a")) {
                list5.add(s.toUpperCase());
            }
        }
        Collections.sort(list5);
        System.out.println(list5);
        List<String> list6 = list4.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(list6);
    }

}


