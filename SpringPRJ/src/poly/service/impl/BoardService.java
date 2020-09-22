package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.BoardDto;
import poly.dto.GongDto;
import poly.persistance.mapper.IBoardMapper;
import poly.service.IBoardService;


@Service("BoardService")
public class BoardService implements IBoardService{
	
	@Resource(name="BoardMapper")
	IBoardMapper BoardMapper;
	
	@Override
	public int insertPost(BoardDto pDTO) {
		return BoardMapper.insertPost(pDTO);
	}
	
	@Override
	public List<BoardDto> getBoardList(){
		
		return BoardMapper.getBoardList();
		
	}
	
	
	@Override
	public List<GongDto> getGongJiList(GongDto pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getGongJiList(pDTO);
	}

	@Override
	public BoardDto getPostDetail(BoardDto pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getPostDetail(pDTO);
	}


	@Override
	public int getDeletePost(BoardDto pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getDeletePost(pDTO);
	}

	@Override
	public int getUpdatePost(BoardDto pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.getUpdatePost(pDTO);
	}

	@Override
	public List<BoardDto> searchList(BoardDto pDTO) {
		System.out.println(pDTO.getPost_title());
		// TODO Auto-generated method stub
		return BoardMapper.searchList(pDTO);
	}

	@Override
	public List<GongDto> searchGongji(GongDto pDTO) {
		// TODO Auto-generated method stub
		return BoardMapper.searchGongji(pDTO);
	}



}
