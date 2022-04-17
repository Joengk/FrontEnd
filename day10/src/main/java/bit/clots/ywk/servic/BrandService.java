package bit.clots.ywk.servic;

import bit.clots.ywk.mapper.BrandMapper;
import bit.clots.ywk.pojo.Brand;
import bit.clots.ywk.utils.MapperFactory;

import java.util.List;

/**
 * @author admin
 */
public class BrandService {

	static BrandMapper mapper = MapperFactory.getBean(BrandMapper.class);

	/**
	 * 添加品牌信息
	 *
	 * @param brand 要添加的品牌对象
	 */
	public static void addBrand(Brand brand) {
		mapper.addBrand(brand);
	}

	/**
	 * 根据id从数据库中查询数据
	 *
	 * @param id 需要查询的id
	 * @return
	 */
	public static Brand selectById(Integer id) {
		return mapper.selectById(id);
	}

	/**
	 * 显示所用商品信息
	 *
	 * @return
	 */
	public static List<Brand> selectAllBrand() {
		return mapper.selectAllBrand();
	}


	/**
	 * 更新品牌信息
	 *
	 * @param brand
	 * @return
	 */
	public static Integer updateBrand(Brand brand) {
		return mapper.updateBrand(brand);
	}

	public static Integer deletedBrand(Integer id) {
		return mapper.deletedBrand(id);
	}
}
