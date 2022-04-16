package bit.clots.ywk.mapper;

import bit.clots.ywk.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author admin
 */
public interface BrandMapper {

	List<Brand> selectAllBrand();

	Integer addBrand(@Param("brand") Brand brand);

	Brand selectById(@Param("id") Integer id);

	Integer updateBrand(@Param("brand") Brand brand);

	Integer deletedBrand(Integer id);

}
