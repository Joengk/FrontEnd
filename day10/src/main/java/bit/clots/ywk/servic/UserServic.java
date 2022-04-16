package bit.clots.ywk.servic;


import bit.clots.ywk.mapper.UserMapper;
import bit.clots.ywk.pojo.User;
import bit.clots.ywk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author admin
 */
public class UserServic {

	/**
	 * ��֤��¼�û�
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public static User findByUsernameAndPassword(String username, String password) {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findByUsernameAndPassword(username, password);
		MybatisUtils.close(sqlSession);
		return user;
	}

	/**
	 * �ж��û��Ƿ����
	 *
	 * @param username
	 * @return
	 */
	public static User findUserByName(String username) {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User checkUser = mapper.findUserByName(username);
		MybatisUtils.close(sqlSession);
		return checkUser;
	}

	/**
	 * ����û�
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public static Integer addUser(String username, String password) {
		SqlSession sqlSession = MybatisUtils.getSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Integer integer = mapper.addUser(username, password);
		MybatisUtils.close(sqlSession);
		return integer;
	}


}
