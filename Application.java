import operation.Utils;
import stu.Student;
import untils.Login;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @ClassName: Application
 * @Descripiton: 主方法 程序入口
 * @Author: 小郑
 * @Date： 2022/10/2 17:00
 * @Version：1.8
 **/
public class Application {
    public static void main(String[] args) {
    // 程序入口
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------欢迎来到简洁版学生管理系统------------------");
        System.out.println("------------------使用本系统前请先登录系统------------");
        boolean isLogin = false;
        int count = 0;
        while (true) {
            if (!isLogin) {
                System.out.print("请输入用户名:");
                String  userName = scanner.next();
                System.out.print("请输入密码:");
                String password = scanner.next();
                boolean login = Login.isLogin(userName, password);

                //密码错误的情况
                if (!login) {
                    count++;
                    if (count == 3) {
                        System.out.println("达到密码错误上，重启系统");
                        return;//结束程序
                    }
                    System.out.println("当前输入错误:" + count + " 次,如果输入错误3次，系统锁定");
                    System.out.println("用户名或者密码错误，请重新输入");
                    continue;//结束本次循环
                }
                //密码正确的情况
                isLogin = true;
                System.out.printf("----------用户登录成功，当前用户名【%s】-------------", userName);
                System.out.println();
            }

            //主菜单
            showChoose();
            int choose = -1;
            if (scanner.hasNext()) {
                choose = scanner.nextInt();
            }else{
                System.out.println("输入有误！");
            }
            switch (choose) {
                case 0:
                    boolean isAdd = Utils.stuAdd(creatStu());
                    if (isAdd) {
                        System.out.println("学生添加成功");
                    } else {
                        System.out.println("学生添加失败（学生已存在）");
                    }
                    break;
                case 1:
                    System.out.print("请输入需要删除的学生名字:");
                    String sn = scanner.next();
                    boolean isDelete = Utils.deleteStu(sn);
                    System.out.println(isDelete ? "删除成功" : "删除失败");
                    break;
                case 2:
                    System.out.print("请输入需要修改的学生的姓名:");
                    String name = scanner.next();
                    System.out.print("请输入需要修改的学生的性别:");
                    char sex = scanner.next().charAt(0);
                    System.out.print("请输入需要修改的学生的年龄:");
                    int age = scanner.nextInt();
                    boolean isUpdate = Utils.Modify(new Student(name, sex, age));
                    System.out.println(isUpdate ? "修改成功" : "修改失败");
                    break;
                case 3:
                    System.out.print("请输需要查询的学生姓名:");
                    Student stu = Utils.findStu(scanner.next());
                    System.out.println(stu.toString());
                    break;
                case 4:
                    System.out.println("显示所有学生信息如下:");
                    show();
                    break;
                case 5:
                    if (choose == 5){
                        System.out.println("确定退出吗?(Y/N)");
                        System.out.print("请输入:");
                        String next = scanner.next();
                        //忽略大小写
                        if ("Y".toUpperCase().equals(next.toUpperCase())){
                            return;
                        }else {
                            break;
                        }

                    }
            }
        }
    }

    public static void showChoose() {
        System.out.println("-------------请输入指令进行相关操作---------------");
        System.out.println("添加学生-0 | 删除学生-1 | 修改学生-2  | 查询单个学生-3 | 查询所有学生-4 | 退出-5 |");
        System.out.println("请输入你要进行的操作");
    }
    //创建商品
    public static Student creatStu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入学生姓名:");
        String name = scanner.next();
        System.out.print("请输入学生性别:");
       char sex = scanner.next().charAt(0); // 获取char类型数据
        System.out.print("请输入学生年龄:");
        int age = scanner.nextInt();
        return new Student( name, sex, age);
    }
public  static  void show(){
    Iterator<Student> iterator1 =Utils. listAll().iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
}
}
