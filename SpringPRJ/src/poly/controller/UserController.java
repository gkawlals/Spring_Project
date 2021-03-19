package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import poly.dto.UserDto;
import poly.service.IUserService;
import poly.util.CmmUtil;
import poly.util.EncryptUtil;

@Controller
public class UserController {
	Logger log = Logger.getLogger(this.getClass());
	
	// 서비스와 이어주는 문구 
	@Resource(name="UserService")
	IUserService userService;
	
	
	//userList를 만드는 컨트롤러
	@RequestMapping(value="/user/UserList")
	public String UserList (ModelMap model) {
		log.info(this.getClass() + "userList start ! ");
		
		List<UserDto> rList = userService.UserList();
		if(rList == null ) {
			rList = new ArrayList<>();
		}
		model.addAttribute("rList", rList);
		log.info(this.getClass() + "userList end ! ");
		
		for (UserDto e : rList) {

			log.info("UserList 1번 : " + e.getUser_no());

		}
		
		return "/user/UserList";
	}
	// MultipartHttpServletRequest <- multipart는 여러개의 파일을 받을때 사용 
	@RequestMapping(value="/ChUserImg.do")
	public String ChUserImg(MultipartHttpServletRequest request, HttpServletResponse response, HttpSession session, ModelMap model) {
		log.info(" Controller ChUserImg start !");
		// 이미지 삽입 경로 파라미터생성 
		String file_path = CmmUtil.nvl(request.getParameter("file_path"),"0");
		log.info(" file_path : "+ file_path);
		
		// 이미지 삽입 (파일명) 파라미터 생성 
		String file_name = (String)request.getParameter("user_img");
		log.info(" user_img : " + file_name );
		
		//File filedir = new File("/Users/hamjimin/Spring_Project/OpenApiPrj/WebContent/WEB-INF/img");
		//File filename = new File(filedir, user_img);
		MultipartFile File = request.getFile("file_path");
	    log.info("File : " + File);

		String path = "\\Users\\hamjimin\\Spring_Project\\OpenApiPrj\\WebContent\\WEB-INF\\img";
		String originFileName = File.getOriginalFilename();
		
		// 파일이 잘 들어 갔는지 원본 파일명 체크
	    System.out.println("originFileName : " + originFileName);

	    // 중복파일 업로드 방지를 위해 원본파일명 앞에 현재 시간 입력
	    file_path = path + System.currentTimeMillis() + originFileName; // 경로 부분
	    file_name = System.currentTimeMillis() + originFileName; // 파일이름
	    log.info("file_path : " + file_path);

	    // 파일 데이터를 safeFile 방식으로 저장
	      try {
	         File.transferTo(new java.io.File(file_path));
	      } catch (Exception e) { // 예외 처리


	         e.printStackTrace(); // 에러의 근거지 메시지 출력
	      }
	    // DB조회할 user_no 받아오기 
	 	String user_no = (String)session.getAttribute("user_no");
	 	log.info(" user_no : "+ user_no);
	 	
		UserDto pDTO = new UserDto();
		
		pDTO.setUser_img(file_path);
		pDTO.setUser_no(user_no);
		
		int res = userService.ChUserImg(pDTO);
		
		String msg = "";
		
		String url = "/index.do";
		
		log.info(" Controller ChUserImg end !");
		
		if (res < 1) {
			// 실패
			msg = "수정 실패 ~";
		} else {
			// 성공
			msg = "수정 완료";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		
		
		return "/redirect";
	}
	
	
	// 아래는 로그인 화면 반환하기
	@RequestMapping(value="user/userLogin")
	// 여기서는 로그인 jsp와 연동 및 디비 데이터 전달 
	public String userLogin() {
		
		log.info(this.getClass()+"user/userLogin start");
		
		 
		log.info(this.getClass()+"user/userLogin end");
		
		return "user/userLogin";
	}
	
	@RequestMapping(value="user/profile.do")
	public String profile() {
		log.info(this.getClass().getName() + " profile.do 열기 ! ");
		log.info(this.getClass().getName() + " profile.do end ! ");
		
		return "user/profile";
	}
	
	//로그인 id password확인하기
	@RequestMapping(value="user/userLoginProc")
	public String userLoginProc(HttpServletRequest request, HttpSession se, ModelMap model, HttpServletResponse responese) throws Exception {
		log.info(this.getClass()+"user/userLoginProc start");
		// 아이디 받고 받는걸 확인 하는 문구
		// nvl은 널값을 표현하지 않는 함수를 사용함 
		//String user_no = CmmUtil.nvl(request.getParameter("user_no"));
		String user_id = CmmUtil.nvl(request.getParameter("user_id"));
		
		//String name = CmmUtil.nvl(request.getParameter("name"));
		
		// 비밀번호 받고 받는걸 확인 하는 문구
		String password = CmmUtil.nvl(request.getParameter("password"));
		
		String msg = "";
		String url = "";
		//log.info("user_no :" + user_no);
		log.info("user_id : " + user_id);
		log.info("password : " + password);
		
		UserDto pDTO = new UserDto();
		//pDTO.setUser_no(user_no);
		pDTO.setUser_id(user_id);
		pDTO.setPassword(EncryptUtil.encHashSHA256(password));
		
		UserDto rDTO = userService.getLoginInfo(pDTO);
		
		
		if(rDTO == null) {
			msg="로그인 실패";
		}
		else {
			log.info("user_id : " + user_id);
			log.info("password : " + password);
			
			msg="로그인 성공";
			
			se.setAttribute("user_no", rDTO.getUser_no());
			se.setAttribute("user_id", rDTO.getUser_id());
			se.setAttribute("password", rDTO.getPassword());
			se.setAttribute("name", rDTO.getName());
			//rDTO = userService.getUserOut(pDTO);
		}
		
		url = "/index.do";
		
		model.addAttribute("msg",msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass()+"user/userLoginProc end");
		
		return "/redirect.do";
	}
	
	@RequestMapping(value="user/userLogout")
	public String logOut( HttpSession se, ModelMap model ) {
		log.info(this.getClass() + " 로그아웃 시작");
		
		String msg = "";
		String url = "";
		
		msg = " 로그아웃 성공";
		url="/";
		
		se.invalidate();
		
		model.addAttribute("msg",msg);
		model.addAttribute("url", url);
		
		log.info(this.getClass() + " 로그아웃 끝");
		return "/redirect";
	}
	
	@RequestMapping(value = "/user/userinsert")
	public String NewPost() {

		log.info("Newuser 불러오기");

		return "/user/userinsert";
	}

	@RequestMapping(value = "/user/newUser.do")
	public String newUser(HttpServletRequest request, ModelMap model) throws Exception {

		log.info(this.getClass()+" newInsert start");
		String msg = "";
		String url = "/user/userLogin.do";
		UserDto uDto = null;
		
		try {
			
		// 요청으로 부터 받은 파라미터 변수에 저장
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		//String user_no = request.getParameter("user_no");
		String email = request.getParameter("email");
		
		CmmUtil.pwck(password);
		
		log.info("user_id : " + user_id);		
		log.info("password : " + password);		
		log.info("name : " + name);		
		//log.info("user_no : " + user_no);		
		log.info("email :" + email);
		//  dto받아오기 
		
		uDto = new UserDto();
			
		//uDto.setUser_no(user_no);
		uDto.setUser_id(user_id);
		uDto.setPassword(EncryptUtil.encHashSHA256(password));
		uDto.setName(name);
		uDto.setEmail(EncryptUtil.encAES128CBC(email));
		

		int res = userService.newUser(uDto);
		log.info(res);


		if (res < 1) {
			// 실패
			msg = "가입 실패";
		} else {
			// 성공
			msg = "가입 완료";
		}
		} catch(Exception e) {
			msg = "회원가입의 실패 하였습니다. ";
			log.info(msg);
			e.printStackTrace();
		
		}finally {	
			
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		log.info(this.getClass()+"user/userInsert end");
		
		uDto = null;
		}
		return "user/chat.do";
	}
	
}
