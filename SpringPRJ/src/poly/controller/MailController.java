package poly.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.MailDto;
import poly.service.IMailService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class MailController {

	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="MailService")
	private IMailService mailService;
	
	@RequestMapping(value = "/mail/sendMail")
	public String sendMail() {

		log.info("메일보내기 jsp불러오기 ");
		log.info("메일보내기 시작  ");
		log.info("메일보내기 끝 ");
		
		return "/mail/sendMail";
	}
	
	@RequestMapping(value = "/mail/sendMailResult", method = RequestMethod.POST)
	public String sendMailResult(HttpSession session,HttpServletRequest request, HttpServletResponse response, ModelMap model ) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		
		log.info("sendMailResult Start");
		//DTO불러오기 
		
		//DTO의 있는 정보들 불러오기 
		String toMail = CmmUtil.nvl(request.getParameter("toMail"));
		String title = CmmUtil.nvl(request.getParameter("title"));
		String content = CmmUtil.nvl(request.getParameter("content"));
		
		log.info("toMail: " + toMail);
		log.info("title: " + title);
		log.info("content: " + content);
		
		MailDto pDTO = new MailDto();
		
		pDTO.setContent(content);
		pDTO.setTitle(title);
		pDTO.setToMail(toMail);

		session.setAttribute("toMail",toMail);
		session.setAttribute("title",title);
		session.setAttribute("content",content);
		
		log.info("mailService.sendMailResult Start");
		int res = mailService.sendMailResult(pDTO);
		log.info("mailService.sendMailResult end");
		log.info("res: " + res);
		
		
		if(res==1) {
			log.info("메일 발송 성공 ");
		}else { 
			log.info("메일 발송 실패");
		}
		log.info("sendMail End");
		model.addAttribute("res",String.valueOf(res));

		return "/mail/sendMailResult";
	}

}
