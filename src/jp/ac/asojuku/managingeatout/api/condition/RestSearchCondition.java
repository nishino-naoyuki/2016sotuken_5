/**
 *
 */
package jp.ac.asojuku.gurunabiapi.api.condition;

/**
 * ���X�g������������
 * @author nishino
 *
 * http://api.gnavi.co.jp/api/manual/restsearch/�@�̃��N�G�X�g�p�����[�^���甲��
 * �{���͑S���������ق����悢���A���������̂ňꕔ�����ɂ����B
 *
 */
public class RestSearchCondition {
	private String shopName;	//�X�ܖ�
	private String area;   		//�n���R�[�h
	private String pref;   		//�s���{���R�[�h
	private String areacode_l;   //�G���AL�R�[�h
	private String areacode_m;   //�G���AM�R�[�h
	private String areacode_s;   //�G���AS�R�[�h
	private String category_l;   //��ƑԃR�[�h
	private String category_s;   //���ƑԃR�[�h
	private String offset_page;

	public String getOffset_page() {
		return offset_page;
	}

	public void setOffset_page(String offset_page) {
		this.offset_page = offset_page;
	}

	public RestSearchCondition(){
		;//�������Ȃ�
	}

	public RestSearchCondition(String shopName, String area, String pref, String areacode_l, String areacode_m,
			String areacode_s, String category_l, String category_s, String offset_page) {
		super();
		this.shopName = shopName;
		this.area = area;
		this.pref = pref;
		this.areacode_l = areacode_l;
		this.areacode_m = areacode_m;
		this.areacode_s = areacode_s;
		this.category_l = category_l;
		this.category_s = category_s;
		this.offset_page = offset_page;
	}

	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPref() {
		return pref;
	}
	public void setPref(String pref) {
		this.pref = pref;
	}
	public String getAreacode_l() {
		return areacode_l;
	}
	public void setAreacode_l(String areacode_l) {
		this.areacode_l = areacode_l;
	}
	public String getAreacode_m() {
		return areacode_m;
	}
	public void setAreacode_m(String areacode_m) {
		this.areacode_m = areacode_m;
	}
	public String getAreacode_s() {
		return areacode_s;
	}
	public void setAreacode_s(String areacode_s) {
		this.areacode_s = areacode_s;
	}
	public String getCategory_l() {
		return category_l;
	}
	public void setCategory_l(String category_l) {
		this.category_l = category_l;
	}
	public String getCategory_s() {
		return category_s;
	}
	public void setCategory_s(String category_s) {
		this.category_s = category_s;
	}
}
