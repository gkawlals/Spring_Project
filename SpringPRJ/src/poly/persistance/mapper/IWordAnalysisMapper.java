package poly.persistance.mapper;

import config.Mapper;
import poly.dto.WordAnalysisDTO;

@Mapper("WordAnalysisMapper")

public interface IWordAnalysisMapper {

	int insertData(WordAnalysisDTO pDTO);
	
}
