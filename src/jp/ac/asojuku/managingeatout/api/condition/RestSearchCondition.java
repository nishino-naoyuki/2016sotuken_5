/**
 *
 */
package jp.ac.asojuku.managingeatout.api.condition;

/**
 * レストラン検索条件
 * @author nishino
 *
 * http://api.gnavi.co.jp/api/manual/restsearch/　のリクエストパラメータから抜粋
 * 本当は全部あったほうがよいが、数が多いので一部だけにした。
 *
 */
public class RestSearchCondition {
	private String shopName;	//店舗名
	private String area;   		//地方コード
	private String pref;   		//都道府県コード
	private String areacode_l;   //エリアLコード
	private String areacode_m;   //エリアMコード
	private String areacode_s;   //エリアSコード
	private String category_l;   //大業態コード
	private String category_s;   //小業態コード
	private String offset_page;

	public String getOffset_page() {
		return offset_page;
	}

	public void setOffset_page(String offset_page) {
		this.offset_page = offset_page;
	}

	public RestSearchCondition(){
		;//何もしない
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
