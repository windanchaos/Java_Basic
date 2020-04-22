package com.chaosbom;

import com.chaosbom.entity.Account;
import com.chaosbom.entity.Student;
import com.chaosbom.repository.AccountRepository;
import com.chaosbom.repository.ClassesRepository;
import com.chaosbom.repository.CustomerRepository;
import com.chaosbom.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisProxyTest {
    public static void main(String[] args) {
        InputStream inputStream=MybatisProxyTest.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        //下面三行代码都是套路
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(inputStream);
        SqlSession session=factory.openSession();
        //获取接口的代理对象
        AccountRepository repository=session.getMapper(AccountRepository.class);
        List<Account> reslut=repository.findAll();
        for(Account account:reslut){
            System.out.println(account.toString());
        }

//        StudentRepository repository=session.getMapper(StudentRepository.class);
//        Student student=repository.findByID(5);
//        System.out.println(student);
//        ClassesRepository repository=session.getMapper(ClassesRepository.class);
//        List<Student> students=repository.findByID(1);
//        for(Object s:students){
//            System.out.println(s);
//        }
//        CustomerRepository repository=session.getMapper(CustomerRepository.class);
//        System.out.println(repository.findCusGoodsByID(1));
        session.close();
    }
}
