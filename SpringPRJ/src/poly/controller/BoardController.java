package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.BoardDto;
import poly.dto.WordAnalysisDTO;
import poly.service.IBoardService;
import poly.service.IWordAnalysisService;
import poly.util.CmmUtil;

@Controller
public class BoardController {

	Logger log = Logger.getLogger(this.getClass());

	@Resource(name = "BoardService")
	IBoardService BoardService;

	@Resource(name = "WordAnalysisService")
	IWordAnalysisService wordAnalysisService;
	
	@RequestMapping(value = "/board/BoardList")
	public String BoardList(ModelMap model) {

		List<BoardDto> rList = BoardService.getBoardList();

		if (rList == null) {
			rList = new ArrayList<>();
		}

		model.addAttribute("rList", rList);

		log.info("BoardList 불러오기");

		for (BoardDto e : rList) {

			log.info("BoardList 1번 : " + e.getPost_no());

		}

		return "/board/BoardList";
	}
	
	@RequestMapping(value = "/board/doPost.do")
	public String doPost(HttpServletRequest request, ModelMap model) {

		// 임시 설정 아이디
		String reg_id = "admin";
		// 요청으로 부터 받은 파라미터 변수에 저장
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");

		// 게시자, 게시글 제목, 게시긇 내용을 담아 서비스에 전송할 DTO객체 생성
		BoardDto pDTO = new BoardDto();

		pDTO.setReg_id(reg_id);
		pDTO.setPost_title(post_title);
		pDTO.setPost_content(post_content);

		int res = BoardService.insertPost(pDTO);

		String msg = "";
		String url = "/board/BoardList.do";
		if (res < 1) {
			// 실패
			msg = "다시 써라~";
		} else {
			// 성공
			msg = "등록 완료";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";
	}

	@RequestMapping(value = "/board/newPost")
	public String NewPost() {

		log.info("Newposrt 불러오기");

		return "board/newPost";
	}

	@RequestMapping(value = "/board/editPost")
	public String editPost(HttpServletRequest request, ModelMap model) {

		log.info("boardEdit 불러오기");

		String post_no = request.getParameter("no");

		BoardDto pDTO = new BoardDto();
		pDTO.setPost_no(post_no);

		BoardDto rDTO = BoardService.getPostDetail(pDTO);

		model.addAttribute("rDTO", rDTO);

		if (rDTO == null) {

			model.addAttribute("msg", "존재하지않음");
			model.addAttribute("url", "/board/BoardList");

		}
		log.info("boardEdit no 불러오기 : " + post_no);

		return "board/editPost";
	}

	@RequestMapping(value = "/board/doEdit")
	public String doEdit(HttpServletRequest request, ModelMap model) {

		String post_no = request.getParameter("post_no");
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");

		// 게시자, 게시글 제목, 게시긇 내용을 담아 서비스에 전송할 DTO객체 생성 BoardDto pDTO = new BoardDto();

		BoardDto pDTO = new BoardDto();

		pDTO.setPost_no(post_no);
		pDTO.setPost_title(post_title);
		pDTO.setPost_content(post_content);

		int res = BoardService.getUpdatePost(pDTO);

		String msg = "";
		String url = "/board/BoardList.do";
		if (res < 1) {
			// 실패
			msg = "수정 실패 ~";
		} else {
			// 성공
			msg = "수정 완료";
		}

		log.info("있니?" + pDTO.getPost_title());

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";
	}

	@RequestMapping(value = "/board/boardDetail")
	public String boardDetail(HttpServletRequest request, ModelMap model) {

		log.info("boardDetail 불러오기");

		String post_no = request.getParameter("no");

		BoardDto pDTO = new BoardDto();
		pDTO.setPost_no(post_no);

		BoardDto rDTO = BoardService.getPostDetail(pDTO);

		if (rDTO == null) {
			model.addAttribute("msg", "존재하지 않습니다.");
			model.addAttribute("url", "/board/BoardList.do");
			return "redirect";
		}

		model.addAttribute("rDTO", rDTO);
		log.info("title : " + rDTO.getPost_title());
		log.info("content : " + rDTO.getPost_content());
		return "board/boardDetail";
	}

	@RequestMapping(value = "/board/DeletePost")
	public String DeletePost(HttpServletRequest request, ModelMap model) {

		log.info("DeletePost 불러오기");

		String post_no = request.getParameter("no");

		BoardDto pDTO = new BoardDto();
		pDTO.setPost_no(post_no);

		// BoardDto rDTO = BoardService.getPostDetail(pDTO);

		int res = BoardService.getDeletePost(pDTO);
		String msg = "";
		String url = "/board/BoardList.do";

		if (res < 1) {
			// 실패
			msg = "삭제 실패~";
		} else {
			// 성공
			msg = "삭제 완료";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);

		return "/redirect";

	}
	
	@RequestMapping(value = "board/searchList")
	public @ResponseBody List<BoardDto> searchList (HttpServletRequest request ) 
	{

		log.info("searchList 시작");
		//jsp에서 값을 받아오는 구문
		String post_title = CmmUtil.nvl(request.getParameter("post_title"));
		log.info(post_title);
		BoardDto pDTO = new BoardDto();
		pDTO.setPost_title(post_title);
		
		List<BoardDto> rList = BoardService.searchList(pDTO);

		log.info("SearchList 불러오기 : " + rList.size());

		log.info("searchList 끝");
		
		return rList;
	}
	
	@RequestMapping(name="word/Insert_N")
	public String insertData (HttpServletRequest request, ModelMap model, HttpSession session) {
		
		log.info( "N행시 Start ! ");
		
		String data_name = request.getParameter("data_name");

		// 게시자, 게시글 제목, 게시긇 내용을 담아 서비스에 전송할 DTO객체 생성
		WordAnalysisDTO pDTO = new WordAnalysisDTO();

		pDTO.setData_name(data_name);

		int res = wordAnalysisService.insertData(pDTO);

		String msg = "";
		String url = "/word/analysis";
		if (res < 1) {
			// 실패
			msg = "다시 써라~";
		} else {
			// 성공
			msg = "등록 완료";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info( "N행시 End ! ");
		
		return "board/BoardList";
	}

}
