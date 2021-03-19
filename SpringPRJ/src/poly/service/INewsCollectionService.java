package poly.service;

public interface INewsCollectionService {
	
	/**
	 * 네이버 뉴스기사 크롤링으로 가져오기 
	 */
	
	String doNaverNewsContents(String url) throws Exception;

}
