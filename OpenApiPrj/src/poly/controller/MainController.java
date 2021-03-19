package poly.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {
	// 로킹을 위한 객체
	private Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value="index")
	public String Index() {
		
		//해당 메서드가 호출받은 로그를 기록
		log.info(this.getClass());
		
		return "/index";
	}
	
	@RequestMapping(value="practice")
	public String practice() {
		log.info("Practice 시작");
		
		return "/practice";
	}
}
