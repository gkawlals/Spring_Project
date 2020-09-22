package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.BoardDto;
import poly.dto.GongDto;

@Mapper("BoardMapper")
public interface IBoardMapper {

	int getDeletePost (BoardDto pDTO);
	
	List<BoardDto> getBoardList();

	int insertPost(BoardDto pDTO);

	BoardDto getPostDetail(BoardDto pDTO);

	BoardDto getPostEdit(BoardDto pDTO);

	int getUpdatePost(BoardDto pDTO);

	List<BoardDto> searchList(BoardDto pDTO);

	List<GongDto> getGongJiList(GongDto pDTO);

	List<GongDto> searchGongji(GongDto pDTO);
	
}
