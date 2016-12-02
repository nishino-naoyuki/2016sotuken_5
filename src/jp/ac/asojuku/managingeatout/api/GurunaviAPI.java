/**
 *
 */
package jp.ac.asojuku.gurunabiapi.api;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.ac.asojuku.gurunabiapi.api.condition.RestSearchCondition;
import jp.ac.asojuku.gurunabiapi.http.HttpException;
import jp.ac.asojuku.gurunabiapi.http.HttpWarpper;
import jp.ac.asojuku.gurunabiapi.json.PrefSearchJson;
import jp.ac.asojuku.gurunabiapi.json.RestSearchJson;

/**
 * ����i�rAPI�N���X
 * @author nishino
 *
 */
public class GurunaviAPI {
	private static final String KEYID = "de7457e0eafff5a5a63b4ce199d022e9";
	private static final String PROXY_HOST = "172.16.1.59";
	private static final int PROXY_PORT = 80;

	/**
	 * ���X�g��������API
	 * @return
	 */
	public RestSearchJson execRestSearchAPI(RestSearchCondition condition){
		RestSearchJson info = null;

		try{
			//�ڑ��I�u�W�F�N�g�擾
			HttpWarpper http = getHttpWarpper();
			//���������̎w��
			setRestSearchCondition(http,condition);
			//HTTP�ʐM�iGET�j
			String body = http.execGet("http://api.gnavi.co.jp/RestSearchAPI/20150630");
			//JSON�I�u�W�F�N�g�ɕϊ�
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
	 * �s���{���}�X�^�擾API�̎��s
	 * @return
	 */
	public PrefSearchJson execPrefSearchAPI(){

		PrefSearchJson info = null;

		try{
			//�ڑ��I�u�W�F�N�g�擾
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

	////////////////////////������肵����private�ȃ��\�b�h///////////////////////////
	/**
	 * HTTP�̐ڑ��I�u�W�F�N�g���擾����
	 * @return
	 */
	private HttpWarpper getHttpWarpper(){

		HttpWarpper http = new HttpWarpper();

		//http.setProxyInfo(PROXY_HOST, PROXY_PORT);	//TODO:�v���L�V���s�v�̏ꍇ�̓R�R������
		http.addRequestParameter("keyid", KEYID, false);
		http.addRequestParameter("format", "json", false);

		return http;
	}
	/**
	 * ���X�g��������API�̌����������Z�b�g����
	 * @param http
	 * @param condition
	 */
	private void setRestSearchCondition(HttpWarpper http,RestSearchCondition condition){

		if( condition == null ){
			//���������Ɏw��Ȃ�
			return;
		}

		//�X�ܖ��̎w��
		if( condition.getShopName() != null){
			http.addRequestParameter("name", condition.getShopName(), true);
		}
		//�n���R�[�h
		if( condition.getArea() != null){
			http.addRequestParameter("area", condition.getArea(), true);
		}
		//�s���{���R�[�h
		if( condition.getPref() != null){
			http.addRequestParameter("pref", condition.getPref(), true);
		}
		//�G���AL�R�[�h
		if( condition.getAreacode_l() != null){
			http.addRequestParameter("areacode_l", condition.getAreacode_l(), true);
		}
		//�G���AM�R�[�h
		if( condition.getAreacode_m() != null){
			http.addRequestParameter("areacode_m", condition.getAreacode_m(), true);
		}
		//�G���AS�R�[�h
		if( condition.getAreacode_s() != null){
			http.addRequestParameter("areacode_s", condition.getAreacode_s(), true);
		}
		//��ƑԃR�[�h
		if( condition.getCategory_l() != null){
			http.addRequestParameter("category_l", condition.getCategory_l(), true);
		}
		//���ƑԃR�[�h
		if( condition.getCategory_s() != null){
			http.addRequestParameter("category_s", condition.getCategory_s(), true);
		}

		//���ƑԃR�[�h
		if( condition.getOffset_page() != null){
			http.addRequestParameter("offset_page", condition.getOffset_page(), true);
		}

	}

}
