package com.chaosbom;

import com.chaosbom.entity.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;

public class MybatisNativeTest {
    public static void main(String[] args) {
        //加载mybatis配置文件
        InputStream inputStream= MybatisNativeTest.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= builder.build(inputStream);
        SqlSession session=factory.openSession();
        //这个是mapper的    命名空间#方法
        String statment="com.chaosbom.mapper.AccountMapper.save";
        Account account=new Account("张三","121424",22);
        session.insert(statment,account);
        session.commit();
        session.close();
    }
}
