/**
 *
 */
package jp.ac.asojuku.managingeatout.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

/**
 * @author nishino
 * Http通信のラッパー
 */
public class HttpWarpper {

	HttpHost proxy = null;
	private HashMap<String,String> paramMap = new HashMap<String,String>();
	private static final int CONNECT_TIMEOUT = 10000;
	private static final int SOCKET_TIMEOUT = 1000;
	private static final String USER_AGENT = "My Http Client 0.1";


	/**
	 * プロキシの設定
	 * @param proxyHost
	 * @param port
	 */
	public void setProxyInfo(String proxyHost,int port){
		proxy = new HttpHost(proxyHost, port, "http");
	}

	/**
	 * HTTP通信で渡すリクエストパラメータを設定する
	 * @param propertyName
	 * @param value
	 */
	public void addRequestParameter(String propertyName,String value,boolean encode){

		try {
			if( encode ){
				value = URLEncoder.encode(value, "UTF-8");
			}
			paramMap.put(propertyName, value);

		} catch (UnsupportedEncodingException e) {
			;
		}
	}

	/**
	 * GET通信を行い、レスポンスを返す
	 * エラーの場合は例外が発生する
	 * @param url
	 * @return
	 * @throws HttpException
	 */
	public String execGet(String url) throws HttpException{
		String body = "";

		try {
			//リクエストの設定値をセット
			RequestConfig requestConfig = getRequestConfig();
			//リクエストヘッダーをセット
			List<BasicHeader> headers = getBasicHeaderList();
			//接続のオブジェクトを作成
			CloseableHttpClient httpClient = HttpClientBuilder.create()
		      .setDefaultRequestConfig(requestConfig)
		      .setDefaultHeaders(headers).build();

			//GET通信を行う
			HttpGet method = new HttpGet(makeGetURL(url));
			HttpResponse response;
			response = httpClient.execute(method);
			int responseStatus = response.getStatusLine().getStatusCode();

			//レスポンスチェック
			if( responseStatus == HttpServletResponse.SC_OK){
				body = EntityUtils.toString(response.getEntity(), "UTF-8");
			}else{
				throw new HttpException(responseStatus);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new HttpException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new HttpException();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			throw new HttpException();
		}

		return body;
	}

	/**
	 * リクエストの設定値をセット
	 * @return
	 */
	private RequestConfig getRequestConfig(){

		  // request configuration
		  RequestConfig.Builder builder = RequestConfig.custom()
			      .setConnectTimeout(CONNECT_TIMEOUT)
			      .setSocketTimeout(SOCKET_TIMEOUT);
		  if( proxy != null){
			  builder.setProxy(proxy);
		  }
		  return builder.build();
	}

	/**
	 * リクエストヘッダーをセット
	 * @return
	 */
	private List<BasicHeader> getBasicHeaderList(){

		  List<BasicHeader> headers = new ArrayList<BasicHeader>();
		  headers.add(new BasicHeader("Accept-Charset","utf-8"));
		  headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));
		  headers.add(new BasicHeader("User-Agent",USER_AGENT));

		  return headers;
	}

	/**
	 * Get用のURLを作成する
	 *  http://xxxxxx?param1=aaa&param2=bbbb&param3=cccc
	 * を作る
	 * @param url
	 * @return
	 * @throws URISyntaxException
	 */
	private URI makeGetURL(String url) throws URISyntaxException{
		StringBuffer sb = new StringBuffer();

		sb.append(url);
		//パラメータをセット
		int count = 0;
		for (Entry<String, String> entry : paramMap.entrySet()) {
			if( count == 0 ){
				sb.append("?");
			}else{
				sb.append("&");
			}
			sb.append(entry.getKey()+"="+ entry.getValue());
			count++;
		}

		return new URI(sb.toString());

	}
}
