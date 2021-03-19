package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.EmpDto;
import poly.service.IEmpService;



@Controller
public class EmpController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "EmpService")
	IEmpService EmpService;
	
	@RequestMapping(value="/emp/EmpList")
	public String EmpList(ModelMap model){
		
		List<EmpDto> rList = EmpService.getEmpList();
		
		if(rList == null) {
			rList = new ArrayList<>();
		}
		
		model.addAttribute("rList",rList);
		
		log.info("empList 불러오기");

		return "/emp/EmpList";
	}
	
	@RequestMapping(value="/emp/EmpMgrList")
	public String EmpMgrList(ModelMap model){
		
		List<EmpDto> rList = EmpService.getEmpMgrList();
		
		if(rList == null) {
			rList = new ArrayList<>();
		}
		
		model.addAttribute("rList",rList);
		
		log.info("empMgrList 불러오기");

		return "/emp/EmpList";
	}
	
}
