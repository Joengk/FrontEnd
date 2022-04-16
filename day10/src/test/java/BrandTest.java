import bit.clots.ywk.mapper.BrandMapper;
import bit.clots.ywk.pojo.Brand;
import bit.clots.ywk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BrandTest {
	@Test
	public void selectTest() {
		//遍历数据库中的商品数据, 封装到请求中
		SqlSession sqlSession = MybatisUtils.getSession();
		BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
		List<Brand> brands = mapper.selectAllBrand();
		brands.forEach(System.out::println);
	}
}
