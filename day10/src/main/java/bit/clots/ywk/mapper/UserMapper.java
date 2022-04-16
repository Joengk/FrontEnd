package bit.clots.ywk.mapper;

import bit.clots.ywk.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author admin
 */
public interface UserMapper {


	User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);


	User findUserByName(String name);

	Integer addUser(@Param("name") String name, @Param("password") String password);


}

