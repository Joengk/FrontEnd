package bit.clots.ywk.pojo;

import lombok.Data;

/**
 * @author admin
 */
@Data
public class Brand {
	// 主键
	private Integer id;
	// 品牌名称
	private String brandName;
	// 企业名称
	private String companyName;
	// 排序字段
	private Integer ordered;
	// 描述信息
	private String description;
	// 状态：0：禁用  1：启用
	private Integer status;


	public Brand(Integer id, String brandName, String companyName, Integer ordered, String description, Integer status) {
		this.id = id;
		this.brandName = brandName;
		this.companyName = companyName;
		this.ordered = ordered;
		this.description = description;
		this.status = status;
	}
}
