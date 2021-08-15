package mysql;

import java.sql.*;

/**
 * 测试MySQL若干问题
 *
 * @author Defu Li
 * @since 2021/7/11 21:42
 */
public class MySQLTEST {
    public static void main(String[] args) {
        try {
            // 1、加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");

            // 2、创建连接
            String url = "jdbc:mysql://localhost:3306/iotlab" ;
            String username = "root" ;
            String password = "123456" ;
            Connection con = DriverManager.getConnection(url , username , password );

            // 3、创建Statement对象
            Statement statement = con.createStatement();

            // 4、执行sql
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }

            // 5、关闭连接
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
