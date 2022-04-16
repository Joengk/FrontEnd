package bit.clots.ywk.pojo;

import lombok.Data;

/**
 * @author admin
 */
@Data
public class Brand {
	// ����
	private Integer id;
	// Ʒ������
	private String brandName;
	// ��ҵ����
	private String companyName;
	// �����ֶ�
	private Integer ordered;
	// ������Ϣ
	private String description;
	// ״̬��0������  1������
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
