import bit.clots.ywk.mapper.UserMapper;
import bit.clots.ywk.pojo.User;
import bit.clots.ywk.utils.MybatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

@Slf4j
public class ConnectionTest {

	@Test
	public void test() {
		SqlSession sqlSession = MybatisUtils.getSession();
		System.out.println(sqlSession);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User u1 = mapper.findByUsernameAndPassword("zhangsan", "123");
		System.out.println(u1);

	}
}
