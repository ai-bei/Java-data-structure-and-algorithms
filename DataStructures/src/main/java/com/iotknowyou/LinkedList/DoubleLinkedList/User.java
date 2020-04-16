package com.iotknowyou.LinkedList.DoubleLinkedList;

/**
 * @author LiuRongHua
 * @updateUser
 * @description
 * @updateRemark
 * @createDate 2020/4/15 14:03
 * @updateDate 2020/4/15 14:03
 **/
public class User {
    private int Number;
    private String Name;
    private String Nickname;

    public User() {
    }

    public User(int number, String name, String nickname) {
        Number = number;
        Name = name;
        Nickname = nickname;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "Number=" + Number +
                ", Name='" + Name + '\'' +
                ", Nickname='" + Nickname + '\'' +
                '}';
    }
}
