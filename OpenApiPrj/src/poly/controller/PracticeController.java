package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static poly.util.CmmUtil.nvl;

import javax.servlet.http.HttpServletRequest;
@Controller
public class PracticeController {
	// 로킹을 위한 객체
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="table_ex")
	public String table() {
		
		//해당 메서드가 호출받은 로그를 기록
		log.info("시작합니다");
		
		return "/table_ex";
	}
	
	@RequestMapping(value="get")
	public String get(HttpServletRequest request, ModelMap model) 
			throws Exception{
		
		log.info("get 시작");
		String name = nvl(request.getParameter("name"));
		model.addAttribute("name", name);
		
		log.info("name = "+ name);
		
		nvl("1234");

		
		
		return "/get";
	}
	// 포스트 방식의 데이터값 정보 전달을 받는 인터페이스(뷰)
	@RequestMapping(value="form")
	public String form() {
		
		log.info("시작합니다");
		
		return "/form";
	}
	//  method=RequestMethod.POST << 함수를 이용함으로써 포스트방식의 데이터를 받아옴 
	@RequestMapping(value="doPost", method=RequestMethod.POST)
	public String doPost(HttpServletRequest request, ModelMap model) {
		
		log.info("get 시작");
		String name = nvl(request.getParameter("name"));
		model.addAttribute("name", name);
		
		log.info("name = "+ name);
		
		return "/get";
	}
	
}

