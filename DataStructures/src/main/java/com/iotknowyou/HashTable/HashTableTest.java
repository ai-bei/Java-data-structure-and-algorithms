package com.iotknowyou.HashTable;

import java.util.Scanner;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/25 12:00
 * @updateDate 2020/4/25 12:00
 **/
public class HashTableTest {
    public static void main(String[] args) {
        //创建哈希表
//        HashTable<User> hashTab = new HashTable(2);
//        Node<User> user1 = new Node<>(new User(1, "liu"));
//        Node<User> user2 = new Node<>(new User(2, "liu"));
//        Node<User> user3 = new Node<>(new User(3, "liu"));
//        Node<User> user4 = new Node<>(new User(4, "liu"));
//        hashTab.add(user1);
//        hashTab.add(user2);
//        hashTab.add(user3);
//        hashTab.add(user4);
//        hashTab.list();

// -----------------------------------------------------------------------

        //创建哈希表
        HashTable<User> hashTab = new HashTable(2);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add:  添加");
            System.out.println("list: 显示");
            System.out.println("find: 查找");
            System.out.println("exit: 退出");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建节点
                    Node<User> user = new Node<>(new User(id, name));
                    hashTab.add(user);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
//                    id = scanner.nextInt();
//                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
