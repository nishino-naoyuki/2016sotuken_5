package jp.ac.asojuku.food.check;

import java.util.ArrayList;
import java.util.List;

import jp.ac.asojuku.food.dto.UserCheckStock;

public class UserAddCheck {
	private CheckItem CI = new CheckItem();
	public  List<String> user(UserCheckStock dto){
		List<String> list = new ArrayList<String>();
		list = mail(dto.getMail(),dto.getRe_mail(),list);
		list = userid(dto.getUseid(),list);
		list = pass(dto.getPass(),dto.getRe_pass(),list);
		list = name(dto.getName_sei(),dto.getName_mei(),list);
		list = furi(dto.getFuri_sei(),dto.getFuri_mei(),list);
		//list = pref(dto.getPref(),list);
		//list = addr(dto.getAddr(),list);
		list = birth(dto.getBirth_y(),dto.getBirth_m(),dto.getBirth_d(),list);
		list = sex(dto.getSex(),list);

		return list;
	}

	//メールアドレスチェック
	public List<String> mail(String mail,String remail,List<String> list){
		boolean flg = CI.isEmpy(mail);
		boolean flg1 = CI.isMail(mail);
		if(flg == false){
			list.add("メールアドレスが入力されていません");
		}else if(flg1 == false){
			list.add("メールアドレスが入力条件を満たしていません");
		}
		flg = CI.isEmpy(remail);
		if(flg == false){
			list.add("メールアドレスが再入力されていません");
		}
		flg = mail.matches(remail);
		if(flg == false){
			list.add("メールアドレスが一致しません");
		}
		return list;
	}

	//パスワードチェック
	public List<String> pass(String pass, String repass, List<String> list){
		boolean flg = CI.isEmpy(pass);
		if(flg==false){
			list.add("パスワードが入力されていません");
		}
		flg = CI.isEmpy(repass);
		if(flg==false){
			list.add("パスワードが再入力されていません");
		}
		boolean flg1 = pass.matches(repass);
		if(flg1==false){
			list.add("パスワードが一致しません");
		}
		flg = CI.isPass(pass);
		if(flg == false){
			list.add("パスワードが入力条件を満たしていません");
		}
		return list;
	}

	//ユーザIDチェック
	public List<String> userid(String name, List<String> list){
		boolean flg = CI.isEmpy(name);
		if(flg == false){
			list.add("ユーザIDが入力されていません");
		}
		return list;
	}

	//名前チェック
	public List<String> name(String mei,String sei,List<String> list){
		boolean flg = CI.isEmpy(sei);
		if(flg == false){
			list.add("名前姓が入力されていません");
		}
		flg = CI.isEmpy(sei);
		if(flg == false){
			list.add("名前、名が入力されていません");
		}
		return list;
	}

	//フリガナチェック
	public List<String> furi(String sei,String mei,List<String> list){
		boolean flg = CI.isEmpy(sei);
		if(flg == false){
			list.add("フリガナ、セイが入力されていません");
		}
		boolean flg1 = CI.isKana(sei);
		if(flg1 == false){
			list.add("セイが半ｶﾅで入力されていません");
		}
		flg = CI.isEmpy(mei);
		if(flg == false){
			list.add("フリガナ、メイが入力されていません");
		}
		flg1 = CI.isKana(mei);
		if(flg1 == false){
			list.add("メイが半ｶﾅで入力されていません");
		}
		return list;
	}

	/*都道府県チェック
	public List<String> pref(String name,List<String> list){
		return list;
	}
	*/


	/*住所チェック
	public List<String> addr(String name,List<String> list){
		return list;
	}
	*/

	//生年月日チェック
	public List<String> birth(String year,String month,String day,List<String> list){
		boolean flag = CI.isEmpy(year);
		boolean flag1 = CI.isEmpy(month);
		boolean flag2 = CI.isEmpy(day);
		boolean flg = CI.isSuu(year);
		if(flag== false || flag1==false || flag2==false){
			return list;
		}else{
			if(flg == false){
				list.add("年が数字で入力されていません");
			}
			flg = CI.isSuu(month);
			if(flg == false){
				list.add("月が数字で入力されていません");
			}
			flg = CI.isSuu(day);
			if(flg == false){
				list.add("日が数字で入力されていません");
			}
		return list;
		}
	}

	//性別チェック
	public List<String> sex(String name,List<String> list){
		boolean flg = CI.isEmpy(name);
		if(flg == false){
			list.add("性別を選択してください");
		}
		return list;
	}
}





