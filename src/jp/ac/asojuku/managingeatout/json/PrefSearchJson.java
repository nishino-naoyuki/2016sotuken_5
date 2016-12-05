/**
 *
 */
package jp.ac.asojuku.managingeatout.json;

/**
 * 都道府県検索API結果保持クラス
 * @author nishino
 *
 */
public class PrefSearchJson extends GurunaviAPIBaseJson {

	private Pref[] pref;

	public Pref[] getPref() {
		return pref;
	}

	public void setPref(Pref[] pref) {
		this.pref = pref;
	}



	//pref
	public static class Pref{
		private String pref_code;  //都道府県コード
		private String pref_name;  //都道府県名称
		private String area_code;  //所属エリアコード
		public String getPref_code() {
			return pref_code;
		}
		public void setPref_code(String pref_code) {
			this.pref_code = pref_code;
		}
		public String getPref_name() {
			return pref_name;
		}
		public void setPref_name(String pref_name) {
			this.pref_name = pref_name;
		}
		public String getArea_code() {
			return area_code;
		}
		public void setArea_code(String area_code) {
			this.area_code = area_code;
		}


	}
}
