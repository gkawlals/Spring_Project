package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import poly.dto.BoardDto;
import poly.dto.UserDto;
import poly.service.IChatService;
import poly.service.IUserService;

@Controller
@ServerEndpoint(value = "/echo.do") 
public class WebSocketController {

	private static final List<Session> sessionList = new ArrayList<>();
	private static final Logger log = LoggerFactory.getLogger(WebSocketController.class);
	
	public WebSocketController() {
		//WebSocket ws = new WebSocket("ws://localhost:8080/echo.do");
		System.out.println("웹소켓 서버 객체 생성");	
	}
	
	@Resource(name = "ChatService")
	IChatService ChatService;
	
	@Resource(name = "UserService")
	IUserService UserService;
	
	@RequestMapping(value="/user/UserList.do")
	public String ChatUserList(ModelMap model) {
		
		List<UserDto> rList = UserService.getUserList();
		if (rList == null) {
			rList = new ArrayList<>();
		}

		model.addAttribute("rList", rList);

		log.info("BoardList 불러오기");

		for (UserDto e : rList) {

			log.info("BoardList 1번 : " + e.getUser_no());

		}
	return "/user/UserList.do";
		
	}
	
	//@RequestMapping(value = "/user/UserList.do")
	//public String UserList(ModelMap model) { 
	//	log.info("userList 불러오기 시작 ");
	//	List<UserDto> rList = ChatService.UserList();
	//	
	//	if(rList == null ) {
	//		rList = new ArrayList<>();
	//	}
	//	model.addAttribute("rList",rList);
	//	
	//	return "/user/UserList.do";
	//}
	@RequestMapping(value = "/chat.do")
	public ModelAndView getChatViewPage(ModelAndView mav) {
		mav.setViewName("/chat");
		return mav;
	}

	@OnOpen
	public void onOpen(Session session) {
		
		log.info("Open session id:" + session.getId());
		
		//model.addAttribute("rList",rList);
		
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText( "000님이 입장하셨습니다."); // 여기서 로그인한 아이디 받아다가 불러오기 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sessionList.add(session);
	}
	
	/*
     * 모든 사용자에게 메시지를 전달한다.
     * @param self
     * @param message
     */ 
	private void sendAllsessionToMessage(Session self, String message) {
		try {
			for (Session session : WebSocketController.sessionList) {
				if (!self.getId().equals(session.getId())) {
					session.getBasicRemote().sendText(message.split(",")[1] + " : " + message);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("Message From " + message.split(",")[1] + " : " + message.split(",")[0]);
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText("to : " + message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sendAllsessionToMessage(session, message);
	}

	@OnError
	public void onError(Throwable e, Session session) {

	}

	@OnClose
	public void onClose(Session session) {
		log.info("session " + session.getId() + " has ended");
		sessionList.remove(session);
	}

}