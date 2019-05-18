package com.yyt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
 
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
 
import com.yyt.pojo.Category;
 
public class Test {
 
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //mybatis二级缓存
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //mybatis一级缓存
        SqlSession session=sqlSessionFactory.openSession();
        
        Category c = new Category();
        /*
        //增加
        c.setName("新增加的Category");
        session.insert("addCategory", c);
        */
        /*
        //删除id为4的数据
        c.setId(4);
        session.delete("deleteCategory",c);
        */
        /*
        //获取id为3的数据
        c=session.selectOne("getCategory",3);
        System.out.println("id为3的数据："+c.getName());
        //修改
        c.setName("修改后的Category");
        session.update("updateCategory",c);
        */
        
        
        //查询并显示所有数据
        listAll(session);
        
        session.commit();
        session.close();
         
    }
    private static void listAll(SqlSession session) {
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName()+" "+c.getId());
        }
    }
}
