package jp.ac.asojuku.managingeatout.check;

public class CheckItem {

	//メールアドレスの正規表現
		private static final String P_MAILADDRES    =  "^[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+(\\.[a-zA-Z0-9!#$%&'_`/=~\\*\\+\\-\\?\\^\\{\\|\\}]+)*+(.*)@[a-zA-Z0-9][a-zA-Z0-9\\-]*(\\.[a-zA-Z0-9\\-]+)+$";
	//パスワードの正規表現
		private static final String P_PASS = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}";
	//半角カナの正規表現
		public static final String MATCH_HANKANA = "^[\\uFF65-\\uFF9F]+$";
	//数字の正規表現
		public static final String MATCH_NUMBER = "^[0-9]+$";



	//null チェック
		public boolean isEmpy(String name){
			if(name==null || name.length() == 0){
				return false;
			}else{
				return true;
			}
		}


	//メールチェック
		public boolean isMail(String name){
			//あたいが正規表現の値とマッチするか
				return name.matches(P_MAILADDRES);
		}


	//パスワードチェック
		public boolean isPass(String name){
			return name.matches(P_PASS);
		}



	//半カナチェック
		public boolean isKana(String name){
			return name.matches(MATCH_HANKANA );
		}


		public boolean isSuu(String name){
			return name.matches(MATCH_NUMBER);
		}
}
