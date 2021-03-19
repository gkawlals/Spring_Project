package poly.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.AccStatDTO;
import poly.service.IGetAccStatService;
import poly.util.CmmUtil;

@Controller
public class GetAccStatController {
	private Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 비즈니스 로직 ( 중요로직을 수행하기 위해 사용되는 서비스를 메모리에 적재(싱글톤패턴 적용)
	 */
	@Resource(name="GetAccStatService")
	private IGetAccStatService getAccStatService;
	
	/**
	 * JSON 결과를 받아오기 위한 함수
	 */
	@RequestMapping(value = "AccStat/getAccStatForJSON")
	public String getAccStatForJSON(HttpServletRequest request, HttpServletResponse reponse, ModelMap model) throws Exception{
		log.info(this.getClass().getName() + " .getAccStatFroJSON start !");
		
		// OpenAPI url 
		String url = "http://localhost:9010/accStat/getAccStatInfo.do?1=1";
		
		// OpenAPI용 파라미터 받아오기 
		String yyyymm = CmmUtil.nvl(request.getParameter("yyyymm"));
		String a_code = CmmUtil.nvl(request.getParameter("String"));
		
		//yyyymm에 값이 없다면
		if(yyyymm.length() > 0 ) {
			url += "&yyyymm";
		}
		
		// a_code에 값이 없다면
		if(a_code.length() > 0 ) {
			url += "&a_code=" + a_code;
		}
		log.info("url : " + url);
		
		AccStatDTO pDTO = new AccStatDTO();
		pDTO.setUrl(url);
		
		//JSON으로부터 받은 결과를 자바에서 처리가 가능한 데이터 구조로 변경 
		Map<String, Object > rMap = getAccStatService.getAccStatForJSON(pDTO);
		
		//JSON 으로부터 받은 결과를 자바에서 처리가능한 데이터 구조로 변경한 변수를 JSP에 전달 
		model.addAttribute("rMAp",rMap);
		
		log.info(this.getClass().getName() + " .getAccStatFroJSON end !");
		
		return "/AccStat/getAccStatForJSON";
	}
	
}
