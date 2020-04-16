package com.iotknowyou.LinkedList.CircleSingleLinkedList;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/16 12:13
 * @updateDate 2020/4/16 12:13
 **/
public class User {
    // 编号
    private int number;
    // 用户姓名
    private String name;

    public User(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
