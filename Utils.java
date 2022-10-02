package operation;

import stu.Student;
import untils.Save;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Utils
 * @Descripiton: 增  删  改  查
 * @Author: 小郑
 * @Date： 2022/10/2 17:03
 * @Version：1.8
 **/
public class Utils {
    /**
     * 添加学生
     *
     * @param student 学生
     * @return boolean   添加成功 /  失败
     */
    public static boolean stuAdd(Student student) {
        //反序列化 读取文件
        List<Student> students = new ArrayList<>();
        List list = Save.read(List.class);
        int num1 = 0;
        //判断文件是否为空，如果为空就新增
        if (list == null) {
            list = new ArrayList();
            //新增
            list.add(student);
            num1++;
        } else {
            //判断学生是否存在  存在则退出
            if (!isExists(student)) {
                list.add(student);
                num1++;
            }
        }
        Save.write(list);
        return num1 != 0;
    }

    /**
     * 列出所有
     *
     * @return {@link List}<{@link Student}>
     */
    public static List<Student> listAll() {
        List read = Save.read(List.class);
        return read;
    }

    /**
     * 根据姓名查找学生
     *
     * @param name 名字
     * @return {@link Student}
     */
    public static Student findStu(String name) {
        List read = Save.read(List.class);
        if (read == null) {
            return null;
        } else {
            for (Object o : read) {
                Student o1 = (Student) o;
                if (o1.getName().equals(name)) {
                    return o1;
                }
            }
        }
        return null;
    }

    /**
     * 修改学生信息
     *
     * @param student 学生
     * @return boolean
     */
    public static boolean Modify(Student student) {
        List list = Save.read(List.class);
        if (list != null) {
            for (Object o : list) {
                Student o1 = (Student) o;
                if (o1.getName().equals(student.getName())) {
                    o1.setSex(student.getSex());
                    o1.setAge(student.getAge());
                    Save.write(list);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除学生
     *
     * @param name 名字
     * @return boolean
     */
    public static boolean deleteStu(String name) {
        List read = Save.read(List.class);
        if (read == null) {
            return false;
        } else {
            if (findStu(name) != null) {
                for (Object o : read) {
                    Student o1 = (Student) o;
                    //如果学生存在则删除学生
                    if (name.equals(o1.getName())) {
                        read.remove(o1);
                        Save.write(read);
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // 判断学生是否存在
    private static boolean isExists(Student student) {
        List read = Save.read(List.class);
        if (read != null) {
            for (Object o : read) {
                Student read1 = (Student) o;
                if (read1.getName().equals(student.getName())) {
                    return true;  // 存在则返回true
                } else {
                    continue;  // 不存在继续遍历
                }
            }
        }
        //不存在返回false
        return false;
    }

//
//    public static void main(String[] args) {
////        boolean b = stuAdd(new Student("张三", '男', 18));
////        boolean c = stuAdd(new Student("李四", '女', 32));
////        System.out.println(b ? "添加成功" : "添加失败");
////        System.out.println(c ? "添加成功" : "添加失败");
////
////        //遍历
////        Iterator<Student> iterator = listAll().iterator();
////        while (iterator.hasNext()){
////            System.out.println(iterator.next());
////        }
////
////        System.out.println(Modify(new Student("李四", '男', 45)) ? "修改成功" : "修改失败");
//        Iterator<Student> iterator1 = listAll().iterator();
//        while (iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
////        Student stu1 = findStu("王五");
////        if (stu1 == null) {
////            System.out.println("没有该同学");
////        } else {
////            System.out.println(stu1.toString());
////        }
//
//        boolean stu = deleteStu("李四");
//        if (stu){
//            System.out.println("删除成功");
//        } else {
//            System.out.println("删除失败");
//        }
//    }
}
