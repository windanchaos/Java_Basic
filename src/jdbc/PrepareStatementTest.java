package jdbc;

import java.sql.*;

public class PrepareStatementTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
        测试2个sql的执行，其中第二个sql由于主键冲突会失败；
        测试事务sql开启事务后的效果。
         */
        String sql= "INSERT INTO `auth`.`roles` (`role_type`, `role_code`, `shop_id`, `role_name`, `comments`, `created_by`, `created_when`) VALUES ('2', 'SUPPLIERADMIN', '-1', '微商管理系统品牌商管理员', '管理员', '916-sys', '2016-06-18 17:07:16');";
        String sql2="INSERT INTO `auth`.`privileges` (`right_id`, `role_id`, `c`, `r`, `u`, `d`, `e`, `ep`, `created_by`, `created_when`, `modify_by`, `modify_when`) VALUES ( '22001', 329, '0', '1', '0', '0', '0', '0', '916-sys', now(), '916-sys', now());\n";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.188.56.41:9141/auth","mk","mitu521!");
        DatabaseMetaData metaData=connection.getMetaData();
        System.out.println(metaData.supportsBatchUpdates());
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement=connection.prepareStatement(sql);
            PreparedStatement statement2=connection.prepareStatement(sql2);
            statement.executeLargeUpdate(sql);
            statement2.executeLargeUpdate(sql2);
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            connection.close();
        }






    }
}
