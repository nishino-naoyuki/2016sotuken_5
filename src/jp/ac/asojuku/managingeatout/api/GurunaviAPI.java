/**
 *
 */
package jp.ac.asojuku.managingeatout.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.ac.asojuku.managingeatout.api.condition.RestSearchCondition;
import jp.ac.asojuku.managingeatout.http.HttpException;
import jp.ac.asojuku.managingeatout.http.HttpWarpper;
import jp.ac.asojuku.managingeatout.json.PrefSearchJson;
import jp.ac.asojuku.managingeatout.json.RestSearchJson;

/**
 * ぐるナビAPIクラス
 * @author nishino
 *
 */
public class GurunaviAPI {
	private static final String KEYID = "de7457e0eafff5a5a63b4ce199d022e9";
	private static final String PROXY_HOST = "172.16.1.59";
	private static final int PROXY_PORT = 80;

	/**
	 * レストラン検索API
	 * @return
	 */
	public RestSearchJson execRestSearchAPI(RestSearchCondition condition){
		RestSearchJson info = null;

		try{
			//接続オブジェクト取得
			HttpWarpper http = getHttpWarpper();
			//検索条件の指定
			setRestSearchCondition(http,condition);
			//HTTP通信（GET）
			String body = http.execGet("http://api.gnavi.co.jp/RestSearchAPI/20150630");
			//JSONオブジェクトに変換
			ObjectMapper mapper = new ObjectMapper();
			info  = mapper.readValue(body, RestSearchJson.class);

		}catch(HttpException e){
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return info;
	}

	/**
	 * 都道府県マスタ取得APIの実行
	 * @return
	 */
	public PrefSearchJson execPrefSearchAPI(){

		PrefSearchJson info = null;

		try{
			//接続オブジェクト取得
			HttpWarpper http = getHttpWarpper();
			http.addRequestParameter("lang", "ja", false);

			String body = http.execGet("http://api.gnavi.co.jp/master/PrefSearchAPI/20150630/");

			ObjectMapper mapper = new ObjectMapper();
			info  = mapper.readValue(body, PrefSearchJson.class);

		}catch(HttpException e){
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return info;
	}

	////////////////////////ここよりしたはprivateなメソッド///////////////////////////
	/**
	 * HTTPの接続オブジェクトを取得する
	 * @return
	 */
	private HttpWarpper getHttpWarpper(){

		HttpWarpper http = new HttpWarpper();

		//http.setProxyInfo(PROXY_HOST, PROXY_PORT);	//TODO:プロキシが不要の場合はココを消す
		http.addRequestParameter("keyid", KEYID, false);
		http.addRequestParameter("format", "json", false);

		return http;
	}
	/**
	 * レストラン検索APIの検索条件をセットする
	 * @param http
	 * @param condition
	 */
	private void setRestSearchCondition(HttpWarpper http,RestSearchCondition condition){

		if( condition == null ){
			//検索条件に指定なし
			return;
		}

		//店舗名の指定
		if( condition.getShopName() != null){
			http.addRequestParameter("name", condition.getShopName(), true);
		}
		//地方コード
		if( condition.getArea() != null){
			http.addRequestParameter("area", condition.getArea(), true);
		}
		//都道府県コード
		if( condition.getPref() != null){
			http.addRequestParameter("pref", condition.getPref(), true);
		}
		//エリアLコード
		if( condition.getAreacode_l() != null){
			http.addRequestParameter("areacode_l", condition.getAreacode_l(), true);
		}
		//エリアMコード
		if( condition.getAreacode_m() != null){
			http.addRequestParameter("areacode_m", condition.getAreacode_m(), true);
		}
		//エリアSコード
		if( condition.getAreacode_s() != null){
			http.addRequestParameter("areacode_s", condition.getAreacode_s(), true);
		}
		//大業態コード
		if( condition.getCategory_l() != null){
			http.addRequestParameter("category_l", condition.getCategory_l(), true);
		}
		//小業態コード
		if( condition.getCategory_s() != null){
			http.addRequestParameter("category_s", condition.getCategory_s(), true);
		}

		//小業態コード
		if( condition.getOffset_page() != null){
			http.addRequestParameter("offset_page", condition.getOffset_page(), true);
		}

	}

}
