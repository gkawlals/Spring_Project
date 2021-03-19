package poly.service;

import java.util.List;

import poly.dto.GongDto;

public interface IGongJiService {

	List<GongDto> getGongJiList();

	List<GongDto> searchGongji(GongDto pDTO);

}
