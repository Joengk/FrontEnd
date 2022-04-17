package bit.clots.ywk.servic;

import bit.clots.ywk.mapper.UserMapper;
import bit.clots.ywk.pojo.User;
import bit.clots.ywk.utils.MapperFactory;

/**
 * @author admin
 */
public class UserService {
	static UserMapper mapper = MapperFactory.getBean(UserMapper.class);

	/**
	 * 验证登录用户
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public static User findByUsernameAndPassword(String username, String password) {
		return mapper.findByUsernameAndPassword(username, password);
	}

	/**
	 * 判断用户是否存在
	 *
	 * @param username 用户名
	 * @return
	 */
	public static User findUserByName(String username) {
		return mapper.findUserByName(username);
	}

	/**
	 * 添加用户
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public static Integer addUser(String username, String password) {
		return mapper.addUser(username, password);
	}


}
