package poly.service;

import java.util.List;


import poly.dto.BoardDto;
import poly.dto.GongDto;

public interface IBoardService {
	
	int insertPost(BoardDto pDTO);
	
	List<BoardDto> getBoardList();

	List<GongDto> getGongJiList(GongDto pDTO);
	
	BoardDto getPostDetail(BoardDto pDTO);

	int getDeletePost(BoardDto pDTO);

	int getUpdatePost(BoardDto pDTO);

	List<BoardDto> searchList(BoardDto pDTO);

	List<GongDto> searchGongji(GongDto pDTO);

	
	


}
