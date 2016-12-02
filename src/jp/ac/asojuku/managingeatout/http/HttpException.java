package jp.ac.asojuku.gurunabiapi.http;

public class HttpException extends Exception{
	private int statusCode;


	public HttpException(int statusCode) {
		super();
		this.statusCode = statusCode;
	}


	public HttpException() {
		super();
	}


	public HttpException(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2) {
		super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
	}


	public HttpException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}


	public HttpException(String paramString) {
		super(paramString);
	}


	public HttpException(Throwable paramThrowable) {
		super(paramThrowable);
	}


	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
