package untils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: Login
 * @Descripiton: TODO
 * @Author: 小郑
 * @Date： 2022/10/2 16:37
 * @Version：1.8
 **/
public class Login {
    /**
     * 是否登录
     *
     * @param uN 用户名
     * @param pS 密码
     * @return boolean
     */
    public static   boolean isLogin(String uN, String pS) {
        String path = "db.properties";
        Properties properties = new Properties();  // 创建类资源加载器
        InputStream resourceAsStream = Login.class.getResourceAsStream(path);
        try {
            properties.load(resourceAsStream); // 加载资源
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取db.properties中的值
        String userName = properties.getProperty("userName");
        String passWord = properties.getProperty("passWord");
        //判断传入的密码是否与数据库中的密码相同
        return userName.equals(uN) || passWord.equals(pS);
    }


}
