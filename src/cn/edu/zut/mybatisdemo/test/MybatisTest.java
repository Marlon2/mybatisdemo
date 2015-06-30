package cn.edu.zut.mybatisdemo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.edu.zut.mybatisdemo.entity.User;

public class MybatisTest {
	public static void main(String[] args) {
		String resource = "mybatis-conf.xml";
		SqlSession sqlSession = null;
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			User user = sqlSession.selectOne("User.get", 233);
			System.out.println(user.getUserID()+"--"+user.getUserName());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
