package jp.ac.asojuku.managingeatout.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.asojuku.gurunabiapi.api.GurunaviAPI;
import jp.ac.asojuku.gurunabiapi.api.condition.RestSearchCondition;
import jp.ac.asojuku.gurunabiapi.json.PrefSearchJson;
import jp.ac.asojuku.gurunabiapi.json.PrefSearchJson.Pref;
import jp.ac.asojuku.gurunabiapi.json.RestSearchJson;
import jp.ac.asojuku.gurunabiapi.json.RestSearchJson.Rest;

public class CallApiAction extends HttpServlet {

	private static final long serialVersionUID = 1788678447772302973L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			GurunaviAPI gurunavi = new GurunaviAPI();


			String shopname = req.getParameter("shopname");
			String pref = req.getParameter("pref");
			String page = req.getParameter("page");
			if( page == null || page.isEmpty() ){
				page = "1";
			}
			///////////////////////////////////
			//レストラン検索API
			RestSearchCondition condition = new RestSearchCondition(shopname,null,pref,null,null,null,null,null,page);
			RestSearchJson rsj = gurunavi.execRestSearchAPI(condition);

			req.setAttribute("RestSearchJson", rsj);
			req.setAttribute("shopname", shopname);
			req.setAttribute("pref", pref);
			//結果を取得
			/*System.out.println("****************レストラン検索API実行結果***********************");
			for( Rest rest : rsj.getRest() ){
				System.out.println("名前："+rest.getName());
				System.out.println("カナ："+rest.getName_kana());
				System.out.println("URL："+rest.getUrl());
				System.out.println("住所："+rest.getAddress());
				System.out.println(rest.getImage_url());
				System.out.println("***************************************");
			}*/

			RequestDispatcher rd = req.getRequestDispatcher("view/view.jsp");
			rd.forward(req, resp);
			//都道府県マスタ取得API
			PrefSearchJson psj = gurunavi.execPrefSearchAPI();

			//結果を取得
			/*System.out.println("****************都道府県マスタ取得API実行結果***********************");
			for( Pref pref : psj.getPref() ){
				System.out.println("コード："+pref.getPref_code());
				System.out.println("名前："+pref.getPref_name());
				System.out.println("エリアコード："+pref.getArea_code());
				System.out.println("***************************************");
			}

			 	//ここから↓は、クラスを分けなかった場合
				URI url;
				url = new URI("http://api.gnavi.co.jp/RestSearchAPI/20150630/?keyid=de7457e0eafff5a5a63b4ce199d022e9&format=json");

				HttpHost proxy = null;
				if( !PROXY_HOST.equals("") ){
					proxy = new HttpHost(PROXY_HOST, PROXY_PORT, "http");
				}
			  // configurations
			  int socketTimeout = 1000;
			  int connectionTimeout = 500;
			  String userAgent = "My Http Client 0.1";
			  // request configuration
			  RequestConfig.Builder builder = RequestConfig.custom()
				      .setConnectTimeout(connectionTimeout)
				      .setSocketTimeout(socketTimeout);
			  if( proxy != null){
				  builder.setProxy(proxy);
			  }
			  RequestConfig requestConfig = builder.build();
			  // headers
			  List<BasicHeader> headers = new ArrayList<BasicHeader>();
			  headers.add(new BasicHeader("Accept-Charset","utf-8"));
			  headers.add(new BasicHeader("Accept-Language","ja, en;q=0.8"));
			  headers.add(new BasicHeader("User-Agent",userAgent));
			  // create client
			  CloseableHttpClient httpClient = HttpClientBuilder.create()
			      .setDefaultRequestConfig(requestConfig)
			      .setDefaultHeaders(headers).build();

			  HttpGet method = new HttpGet(url);
			  HttpResponse response = httpClient.execute(method);
			  int responseStatus = response.getStatusLine().getStatusCode();

			  System.out.println("responseStatus:"+responseStatus);

			  String body = EntityUtils.toString(response.getEntity(), "UTF-8");
			  System.out.println("body:"+body);

				ObjectMapper mapper = new ObjectMapper();
				RestSearchJson info  = mapper.readValue(body, RestSearchJson.class);

				System.out.println(info.getAttributes().getApi_version());
			*/
		} catch ( Exception e){
			e.printStackTrace();
		}

	}

}
