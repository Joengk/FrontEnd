package bit.clots.ywk.utils;


import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �� mapper ������д���, �������ݿ����ӵĲ�����ȡ����
 */
public class MapperFactory {
	@SuppressWarnings("all")
	public static <T> T getBean(Class mapperClass) {
		return (T) Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				SqlSession sqlSession = MybatisUtils.getSession();
				Object mapper = sqlSession.getMapper(mapperClass);
				Object result = method.invoke(mapper, args);
				MybatisUtils.close(sqlSession);
				return result;
			}
		});

	}

}
