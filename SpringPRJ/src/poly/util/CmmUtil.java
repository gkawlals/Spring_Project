package poly.util;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CmmUtil {
	
	public static String nvl(String str, String chg_str) {
		String res;

		if (str == null) {
			res = chg_str;
		} else if (str.equals("")) {
			res = chg_str;
		} else {
			res = str;
		}
		return res;
	}
	
	public static String nvl(String str){
		return nvl(str,"");
	}
	
	public static String checked(String str, String com_str){
		if(str.equals(com_str)){
			return " checked";
		}else{
			return "";
		}
	}
	
	public static String checked(String[] str, String com_str){
		for(int i=0;i<str.length;i++){
			if(str[i].equals(com_str))
				return " checked";
		}
		return "";
	}
	
	public static String select(String str,String com_str){
		if(str.equals(com_str)){
			return " selected";
		}else{
			return "";
		}
	}
	
	public static String pwck ( String password) {
		String strResult = "";
		
		if ( password == null || password.equals(""))return "1";
		if ( password.length() < 8 ) return "2";
		
		try {

			Pattern pAlpabetLow = null; // 소문자 받기 
			Pattern pAlpabetUp = null; // 대문자 받ㅂ기 
			Pattern pNumber = null; // 숫자 받기 
			Pattern pSpecialChar = null; // 특수문자 받기 
			Matcher math;
			int nCharType = 0;
			
			pAlpabetLow.compile("[a-z");
			pAlpabetUp.compile("[A-Z]");
			pNumber.compile("[0-9]");
			pSpecialChar.compile("[#?!@$%^&*-+|()\\'`,./><]");
			
			math = pAlpabetLow.matcher(password);
			if(math.find()) {
				System.out.println(" pAlpabetLow start !");
				nCharType++ ;
			}
			math = pAlpabetUp.matcher(password);
			if(math.find()) {

				System.out.println(" pAlpabetUp start !");
				nCharType++ ;
			}
			math = pNumber.matcher(password);
			if(math.find()) {

				System.out.println(" pNumber start !");
				nCharType++ ;
			}
			math = pSpecialChar.matcher(password);
			if(math.find()) {
				System.out.println(" pSecialChar start !");
				nCharType++ ;
			}
			
			
		}catch (Exception e ){
			strResult = "99";
		}
		return null;
	}
}
