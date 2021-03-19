package poly.util;

public class EncryptTest {
	public static void main (String[] args) throws Exception{
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("해시 암호화 결과");
		
		String str =" 암호화 할 문자열 ";
		
		//복호화가 불가능한 해시암호화 알고리즘 실행 
		String hashEnc = EncryptUtil.encHashSHA256(str);
		
		//해시 알고리즘 결과 츨력문 
		System.out.println("hashEnc : " + hashEnc);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ ");
		
		System.out.println("AES128-CBC 암, 복호화 알고리즘 ");
		
		//AES128-CBC 암호화알고리즘 실행 
		String enc = EncryptUtil.encAES128CBC(str);
		
		//AES128-CBC 암호화 알고리즘 결과 
		System.out.println("enc : " + enc);
		
		//AES128-CBC 복호화 알고리즘 실행 
		String dec = EncryptUtil.decAES128CBC(enc);
		
		//AES128-CBC 복호화 알고리즘 결과 
		System.out.println("dec : " + dec);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	
	}
}
