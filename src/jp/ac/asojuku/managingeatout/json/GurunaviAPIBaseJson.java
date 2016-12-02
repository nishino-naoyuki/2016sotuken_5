/**
 *
 */
package jp.ac.asojuku.gurunabiapi.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.ac.asojuku.gurunabiapi.json.GurunaviAPIBaseJson.ApiVersion;

/**
 * 各APIのレスポンスに共通する部分
 * @author nishino
 *
 */
public class GurunaviAPIBaseJson {

	@JsonProperty("@attributes")
	protected ApiVersion attributes;

	public ApiVersion getAttributes() {
		return attributes;
	}

	public void setAttributes(ApiVersion attributes) {
		this.attributes = attributes;
	}

	//api Ver
	public static class ApiVersion {
		@JsonProperty("api_version")
		Object api_version;

		public Object getApi_version() {
			return api_version;
		}

		public void setApi_version(Object api_version) {
			this.api_version = api_version;
		}
	}
}
