package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.GongDto;

@Mapper("GongJiMapper")

public interface IGongJiMapper {

	List<GongDto> getGongJiList();

	List<GongDto> searchGongji(GongDto pDTO);

	
}
