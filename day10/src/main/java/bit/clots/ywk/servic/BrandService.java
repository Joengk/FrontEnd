package bit.clots.ywk.servic;

import bit.clots.ywk.mapper.BrandMapper;
import bit.clots.ywk.pojo.Brand;
import bit.clots.ywk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author admin
 */
public class BrandService {
	/**
	 * 添加品牌信息
	 *
	 * @param brand
	 */
	public static void addBrand(Brand brand) {
		SqlSession sqlSession = MybatisUtils.getSession();
		BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
		mapper.addBrand(brand);
		MybatisUtils.close(sqlSession);
	}

	/**
	 * 根据id从数据库中查询数据
	 *
	 * @param id
	 * @return
	 */
	public static Brand selectById(Integer id) {
		SqlSession sqlSession = MybatisUtils.getSession();
		BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
		Brand brand = mapper.selectById(id);
		MybatisUtils.close(sqlSession);
		return brand;
	}

	/**
	 * 显示所用商品信息
	 *
	 * @return
	 */
	public static List<Brand> selectAllBrand() {
		SqlSession sqlSession = MybatisUtils.getSession();
		BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
		List<Brand> brandList = mapper.selectAllBrand();
		MybatisUtils.close(sqlSession);
		return brandList;
	}


	/**
	 * 更新品牌信息
	 *
	 * @param brand
	 * @return
	 */
	public static Integer updateBrand(Brand brand) {
		SqlSession sqlSession = MybatisUtils.getSession();
		BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
		Integer integer = mapper.updateBrand(brand);
		MybatisUtils.close(sqlSession);
		return integer;
	}

	public static Integer deletedBrand(Integer id) {
		SqlSession sqlSession = MybatisUtils.getSession();
		BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
		Integer integer = mapper.deletedBrand(id);
		MybatisUtils.close(sqlSession);
		return integer;
	}
}
