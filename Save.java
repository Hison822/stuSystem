package untils;

import java.io.*;

/**
 * @ClassName: Save
 * @Descripiton: 序列化与反序列化实现java对象的保存
 * @Author: 小郑
 * @Date： 2022/10/2 16:45
 * @Version：1.8
 **/
public class Save {
    final static String path = "G:\\大三\\practice\\OSstudent\\src\\untils\\student.txt";

    /**
     * 写  序列化把java对象转换成文件
     * @param t t
     */
    public static <T> void write(T t){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream  = new ObjectOutputStream(
                    new FileOutputStream(path));
            objectOutputStream.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读  将文件转换成java对象
     * @param t t
     * @return {@link T}
     */
    public static <T> T read(Class<T> t){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            Object o = objectInputStream.readObject();
            return (T)o;
        } catch (FileNotFoundException foundException) {
            foundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
