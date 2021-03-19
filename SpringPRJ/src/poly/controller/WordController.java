package poly.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.WordAnalysisDTO;
import poly.service.IWordAnalysisService;
import poly.service.impl.BoardService;

/**
 * Controller 선언해야만 Spring 프레임 워크에서 Controller인지 인식가능 
 * 자바 서블릿 역할 수
 *
 */
@Controller
public class WordController {
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 비즈니스 로직 ( 중요 로직을 수행하기 위해 사용되는 서비스를 메뫼에 적제 ( 싱글톤패턴 적용 ) 
	 */
	@Resource(name = "WordAnalysisService")
	private IWordAnalysisService wordAnalysisService;
	
	@RequestMapping(value = "word/analysis")
	@ResponseBody
	public Map<String, Integer> analysis(HttpServletRequest request, HttpSession session) throws Exception{
		log.info(this.getClass().getName() + " .analysis start ! ");
		
		//분석할 문장 
		String text = request.getParameter("board_area");
	
		//신조어 및 새롭게 생겨난 가수 및 그룹명은 제대로된 분석이 불가능함 
		//새로운 명사 단어들은 어떻게 데이터를 처리할까 ? => 정답은 데이터 사전의 주기적인업데이트 
		Map<String, Integer> rMap = wordAnalysisService.doWordAnalysis(text);
		
		if(rMap == null ) {
			rMap = new HashMap<String, Integer>();
		}
		
		log.info(this.getClass().getName() + " .analysis end ! ");
		
		return rMap;
	}
	

	
}
