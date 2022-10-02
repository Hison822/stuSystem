package stu;

import java.io.Serializable;

/**
 * @ClassName: Student
 * @Descripiton: 创建学生类，实现Serializable接口（将java对象存储到文件）
 * @Author: 小郑
 * @Date： 2022/10/2 16:26
 * @Version：1.8
 **/
public class Student implements Serializable {

    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private char sex;
    /**
     * 年龄
     */
    private int age;

    public Student() {
    }

    public Student(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
