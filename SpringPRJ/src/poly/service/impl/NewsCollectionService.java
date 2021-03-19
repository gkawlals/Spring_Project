package poly.service.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.service.INewsCollectionService;

@Service("NewsCollectionService")
public class NewsCollectionService implements INewsCollectionService{

	@Override
	public String doNaverNewsContents(String url) throws Exception {
			
		//JSOUP 라이브러리를 통해 사이트 접속되면,그 사이트의 전체 html소스 저장할 변수 
		Document doc = null;
		
		//사이트 접속 (http프로토콜만 가능, https 프로토콜은 보안상 안됨 )
		doc = Jsoup.connect(url).get();
		
		//네이버 뉴스 본문내용에 대한 div소스를 가져온다 
		// <div id = "articleBodyContents" class="_article_body_contents">
		Elements newsContent = doc.select("div._article_body_contents");
		
		//태그 내 텍스트 문구만 가져오기 
		String res = newsContent.text();
		
		doc = null;
		
		return res;
	}
	
	

}
