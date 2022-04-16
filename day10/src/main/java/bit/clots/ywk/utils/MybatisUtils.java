package bit.clots.ywk.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取 mybaits 数据源工具类
 *
 * @author admin
 */
public class MybatisUtils {
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try {
			//1.获取mybatis-config.xml输入流, Resources 是mybatis提供的读取资源文件流对象
			InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//2.创建一个工人（工厂建造者）
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
			//3.工人根据配置文件输入流创建SqlSession工厂对象
			sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 对外提供获取SqlSession对象的方法
	 */
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	/**
	 * 对外体用关闭SqlSession对象的方法
	 */
	public static void close(SqlSession sqlSession) {
		if ( sqlSession != null ) {
			//mybatis 默认是手动提交
			sqlSession.commit();
			sqlSession.close();
		}
	}
}
